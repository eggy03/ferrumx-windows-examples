package network.combined;

import io.github.eggy03.ferrumx.windows.entity.compounded.MsftNetAdapterToIpAndDnsAndProfile;
import io.github.eggy03.ferrumx.windows.entity.network.MsftDnsClientServerAddress;
import io.github.eggy03.ferrumx.windows.entity.network.MsftNetAdapter;
import io.github.eggy03.ferrumx.windows.entity.network.MsftNetConnectionProfile;
import io.github.eggy03.ferrumx.windows.entity.network.MsftNetIpAddress;
import io.github.eggy03.ferrumx.windows.service.compounded.MsftNetAdapterToIpAndDnsAndProfileService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@SuppressWarnings("unused")
public class MsftNetworkCombinedExample {

    public static void main(String[] args){

        /*
         * Retrieve the combined network data.
         *
         * This service internally calls multiple MSFT-based WMI/CIM queries
         * (NetAdapter, NetIPAddress, DnsClientServerAddress, NetConnectionProfile)
         * and merges them into a convenient 1:many aggregated structure.
         *
         * Each list entry represents ONE network adapter + all its related info.
         */
        List<MsftNetAdapterToIpAndDnsAndProfile> combinedNetwork =
                new MsftNetAdapterToIpAndDnsAndProfileService().get();

        /*
         * Print each aggregated network object in JSON format.
         *
         * The toString() implementation of MsftNetAdapterToIpAndDnsAndProfile
         * uses Gson pretty-printing.
         */
        combinedNetwork.forEach(network -> log.info("Network\n {}",network.toString()));

        /*
         * Access the individual components.
         *
         * Every MsftNetAdapterToIpAndDnsAndProfile instance gives you:
         *   - InterfaceIndex: the unique Windows adapter index
         *   - Adapter: details about the network adapter itself
         *   - IPAddresses: all IPs bound to this adapter
         *   - DNSServers: DNS servers applied to the adapter
         *   - Profile: connection profile data such as category, name, etc.
         *
         * It is recommended to explore microsoft docs and ferrumx-windows javadocs
         * to know more about the classes
         */
        combinedNetwork.forEach(network -> {
            Long index = network.getInterfaceIndex();
            MsftNetAdapter adapter = network.getAdapter();
            List<MsftNetIpAddress> ipList = network.getIpAddressList();
            List<MsftDnsClientServerAddress> dnsList = network.getDnsClientServerAddressList();
            List<MsftNetConnectionProfile> profileList = network.getNetConnectionProfileList();
        });
    }
}
