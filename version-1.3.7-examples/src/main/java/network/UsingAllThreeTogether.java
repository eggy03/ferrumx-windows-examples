package network;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.associatedclasses.Win32_NetworkAdapterSetting;
import com.ferrumx.system.hardware.Win32_NetworkAdapter;
import com.ferrumx.system.networking.Win32_NetworkAdapterConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UsingAllThreeTogether {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all networkAdapter IDs which are currently active
        // returns an empty list if the system is not connected to the internet
        List<String> networkAdapterIdList = Win32_NetworkAdapter.getDeviceIDList();

        // For each networkAdapterID, fetch a map of its properties
        for(String networkAdapterId : networkAdapterIdList){

            // get the adapters
            Map<String, String> networkAdapterMap = Win32_NetworkAdapter.getNetworkAdapters(networkAdapterId);

            // get the configuration index id for the particular adapter
            String networkAdapterConfigurationIndex = Win32_NetworkAdapterSetting.getIndex(networkAdapterId);

            //get the configuration via the configuration index id
            Map<String, String> networkAdapterConfigurationMap = Win32_NetworkAdapterConfiguration.getAdapterConfiguration(networkAdapterConfigurationIndex);

            // iterate through the maps and print the properties
            networkAdapterMap.forEach((k, v)-> System.out.println(k+": "+v));
            networkAdapterConfigurationMap.forEach((k, v)-> System.out.println(k+": "+v));
            System.out.println();
        }
    }
}
