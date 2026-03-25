package network.combined;

import io.github.eggy03.ferrumx.windows.entity.compounded.Win32NetworkAdapterToConfiguration;
import io.github.eggy03.ferrumx.windows.entity.network.Win32NetworkAdapter;
import io.github.eggy03.ferrumx.windows.entity.network.Win32NetworkAdapterConfiguration;
import io.github.eggy03.ferrumx.windows.service.compounded.Win32NetworkAdapterToConfigurationService;

import java.util.List;

@SuppressWarnings({"unused", "java:S106"})
public class Win32NetworkCombinedExample {

    public static void main(String[] args) {

        List<Win32NetworkAdapterToConfiguration> combinedNetwork = new Win32NetworkAdapterToConfigurationService().get();

        /*
         * Print each aggregated network object in JSON format.
         *
         * The toString() implementation of Win32NetworkAdapterToConfiguration
         * uses Gson pretty-printing.
         */
        combinedNetwork.forEach(System.out::println);

        /*
         * Access the individual components.
         *
         * Every MsftNetAdapterToIpAndDnsAndProfile instance gives you:
         * - Adapter ID: the adapter ID assigned to a network interface by Windows
         * - Adapter Instance: The Win32NetworkAdapter instance having the adapter ID
         * - Config List: A List of Win32NetworkAdapterConfiguration associated with the particular adapter
         *
         * Check out the class level documentation to know more about the classes
         */
        combinedNetwork.forEach(network -> {
            String adapterId = network.getDeviceId();
            Win32NetworkAdapter adapterInstance = network.getAdapter();
            List<Win32NetworkAdapterConfiguration> configurationList = network.getConfigurationList();

            // access or print them
        });
    }
}