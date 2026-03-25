package network.individual;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.entity.network.MsftDnsClientServerAddress;
import io.github.eggy03.ferrumx.windows.entity.network.MsftNetAdapter;
import io.github.eggy03.ferrumx.windows.entity.network.MsftNetConnectionProfile;
import io.github.eggy03.ferrumx.windows.entity.network.MsftNetIpAddress;
import io.github.eggy03.ferrumx.windows.service.network.MsftDnsClientServerAddressService;
import io.github.eggy03.ferrumx.windows.service.network.MsftNetAdapterService;
import io.github.eggy03.ferrumx.windows.service.network.MsftNetConnectionProfileService;
import io.github.eggy03.ferrumx.windows.service.network.MsftNetIpAddressService;

import java.util.List;

@SuppressWarnings("java:S106")
public class MsftNetworkExample {

    public static void main(String[] args) {
        try (PowerShell shell = PowerShell.openSession()) {
            //This example shows how to query each MSFT_* network class individually.
            // can also use service.get() instead of service.get(shell parameter...) to have an auto managed PowerShell session
            // it is recommended to create and re-use your PowerShell session for batch queries like this
            List<MsftNetAdapter> adapterList = new MsftNetAdapterService().get(shell);
            List<MsftNetIpAddress> ipAddressList = new MsftNetIpAddressService().get(shell);
            List<MsftDnsClientServerAddress> dnsClientServerAddressList = new MsftDnsClientServerAddressService().get(shell);
            List<MsftNetConnectionProfile> connectionProfileList = new MsftNetConnectionProfileService().get(shell);

            adapterList.forEach(System.out::println);
            ipAddressList.forEach(System.out::println);
            dnsClientServerAddressList.forEach(System.out::println);
            connectionProfileList.forEach(System.out::println);

            // you can also access individual fields via their getters
        }
    }
}