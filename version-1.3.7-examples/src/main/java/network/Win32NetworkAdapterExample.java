package network;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_NetworkAdapter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32NetworkAdapterExample {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all networkAdapter IDs which are currently active
        // returns an empty list if the system is not connected to the internet
        List<String> networkAdapterIdList = Win32_NetworkAdapter.getDeviceIDList();

        // For each networkAdapterID, fetch a map of its properties
        for(String networkAdapterId : networkAdapterIdList){
            Map<String, String> networkAdapterMap = Win32_NetworkAdapter.getNetworkAdapters(networkAdapterId);
            // iterate through the map and print the properties
            for(Map.Entry<String, String> networkAdapter : networkAdapterMap.entrySet()){
                System.out.println(networkAdapter.getKey()+ ": "+ networkAdapter.getValue());
            }
        }
    }
}
