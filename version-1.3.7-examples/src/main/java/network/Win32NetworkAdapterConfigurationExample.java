package network;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.associatedclasses.Win32_NetworkAdapterSetting;
import com.ferrumx.system.hardware.Win32_NetworkAdapter;
import com.ferrumx.system.networking.Win32_NetworkAdapterConfiguration;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32NetworkAdapterConfigurationExample {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all networkAdapter IDs which are currently active
        // returns an empty list if the system is not connected to the internet
        List<String> networkAdapterIdList = Win32_NetworkAdapter.getDeviceIDList();

        // For each networkAdapterID, fetch a map of its configuration
        for(String networkAdapterId : networkAdapterIdList){
            // get the config index
            String networkAdapterConfigurationIndex = Win32_NetworkAdapterSetting.getIndex(networkAdapterId);
            Map<String, String> networkAdapterConfigurationMap = Win32_NetworkAdapterConfiguration.getAdapterConfiguration(networkAdapterConfigurationIndex);
            // iterate through the map and print the configuration properties
            for(Map.Entry<String, String> networkAdapterConfiguration : networkAdapterConfigurationMap.entrySet()){
                System.out.println(networkAdapterConfiguration.getKey()+ ": "+ networkAdapterConfiguration.getValue());
            }
        }
    }
}
