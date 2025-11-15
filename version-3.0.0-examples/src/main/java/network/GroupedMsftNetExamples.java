package network;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.entity.network.MsftDnsClientServerAddress;
import io.github.eggy03.ferrumx.windows.entity.network.MsftNetAdapter;
import io.github.eggy03.ferrumx.windows.entity.network.MsftNetConnectionProfile;
import io.github.eggy03.ferrumx.windows.entity.network.MsftNetIpAddress;
import io.github.eggy03.ferrumx.windows.service.network.MsftDnsClientServerAddressService;
import io.github.eggy03.ferrumx.windows.service.network.MsftNetAdapterService;
import io.github.eggy03.ferrumx.windows.service.network.MsftNetConnectionProfileService;
import io.github.eggy03.ferrumx.windows.service.network.MsftNetIpAddressService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class GroupedMsftNetExamples {

    public static void main(String[] args) {

        try(PowerShell shell = PowerShell.openSession()){

            Map<Long, MsftNetAdapter> indexIdToAdapterInstanceMap = new MsftNetAdapterService()
                    .get(shell)
                    .stream()
                    .filter(adapter-> adapter.getInterfaceIndex()!=null)
                    .collect(Collectors.toMap(MsftNetAdapter::getInterfaceIndex, adapter->adapter));

            Map<Long, List<MsftNetIpAddress>> indexIdToIpInstanceMap = new MsftNetIpAddressService()
                    .get(shell)
                    .stream()
                    .filter(ip-> ip.getInterfaceIndex()!=null)
                    .collect(Collectors.groupingBy(MsftNetIpAddress::getInterfaceIndex,
                                    Collectors.mapping(ip-> ip, Collectors.toList())));

            Map<Long, List<MsftDnsClientServerAddress>> indexIdToDnsMap = new MsftDnsClientServerAddressService()
                    .get(shell)
                    .stream()
                    .filter(dns-> dns.getInterfaceIndex()!=null)
                    .collect(Collectors.groupingBy(MsftDnsClientServerAddress::getInterfaceIndex,
                                    Collectors.mapping(dns -> dns, Collectors.toList())));

            Map<Long, MsftNetConnectionProfile> indexIdToActiveProfile = new MsftNetConnectionProfileService()
                    .get(shell)
                    .stream()
                    .filter(profile -> profile.getInterfaceIndex()!=null)
                    .collect(Collectors.toMap(MsftNetConnectionProfile::getInterfaceIndex, profile -> profile));

            indexIdToAdapterInstanceMap.forEach((index, adapter) -> {
                log.info("Adapter Config: {}", adapter.toString());

                indexIdToIpInstanceMap
                        .getOrDefault(index, List.of())
                        .forEach(ip-> log.info("IP Config: {}", ip.toString()));

                indexIdToDnsMap
                        .getOrDefault(index, List.of())
                        .forEach(dns-> log.info("DNS Config: {}", dns.toString()));

                log.info(indexIdToActiveProfile.getOrDefault(index, MsftNetConnectionProfile.builder().build()).toString());
            });
        }
    }
}
