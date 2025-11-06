package network;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.entity.network.Win32NetworkAdapter;
import io.github.eggy03.ferrumx.windows.entity.network.Win32NetworkAdapterConfiguration;
import io.github.eggy03.ferrumx.windows.entity.network.Win32NetworkAdapterSetting;
import io.github.eggy03.ferrumx.windows.service.network.Win32NetworkAdapterConfigurationService;
import io.github.eggy03.ferrumx.windows.service.network.Win32NetworkAdapterService;
import io.github.eggy03.ferrumx.windows.service.network.Win32NetworkAdapterSettingService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class GroupedWin32NetworkExamples {
    
    public static void main(String[] args) {
        
        try (PowerShell shell = PowerShell.openSession()) {

            Map<String, Win32NetworkAdapter> adapterMap = new Win32NetworkAdapterService()
                    .get(shell)
                    .stream()
                    .filter(adapter -> adapter.getDeviceId() != null)
                    .collect(Collectors.toMap(Win32NetworkAdapter::getDeviceId, adapter -> adapter));

            Map<Integer, Win32NetworkAdapterConfiguration> configMap = new Win32NetworkAdapterConfigurationService()
                    .get(shell)
                    .stream()
                    .filter(config -> config.getIndex()!=null)
                    .collect(Collectors.toMap(Win32NetworkAdapterConfiguration::getIndex, config -> config));

            Map<String, List<Integer>> adapterIdToConfigIndexes = new Win32NetworkAdapterSettingService()
                    .get(shell)
                    .stream()
                    .filter(setting -> setting.getNetworkAdapterDeviceId()!=null && setting.getNetworkAdapterConfigurationIndex()!=null)
                    .collect(Collectors
                            .groupingBy(Win32NetworkAdapterSetting::getNetworkAdapterDeviceId,
                                    Collectors.mapping(Win32NetworkAdapterSetting::getNetworkAdapterConfigurationIndex,
                                            Collectors.toList())));

            Map<Win32NetworkAdapter, List<Win32NetworkAdapterConfiguration>> finalMap = adapterIdToConfigIndexes
                    .entrySet()
                    .stream()
                    .collect(Collectors.toMap(
                            set -> adapterMap.get(set.getKey()),
                            set -> set.getValue()
                                    .stream()
                                    .map(configMap::get)
                                    .toList()
                            ));

            finalMap.forEach((k, v)-> {
                log.info(k.toString());
                v.forEach(vt -> log.info(vt.toString()));
            });

        }
    }
}