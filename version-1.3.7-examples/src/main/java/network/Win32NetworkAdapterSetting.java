package network;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.associatedclasses.Win32_NetworkAdapterSetting;
import com.ferrumx.system.hardware.Win32_NetworkAdapter;

import java.io.IOException;
import java.util.List;

public class Win32NetworkAdapterSetting {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all networkAdapter IDs which are currently active
        // returns an empty list if the system is not connected to the internet
        List<String> networkAdapterIdList = Win32_NetworkAdapter.getDeviceIDList();

        // For each networkAdapterID, fetch a list of configuration index IDs
        // This index ID will be the index of the configuration that will join an adapter with its configuration

        // The linking is as follows:
        // Win32_NetworkAdapter (adapterID) -> Win32_NetworkAdapterSetting (adapterID, index) -> Win32_NetworkAdapterConfiguration (index)
        for(String networkAdapterId : networkAdapterIdList){
            System.out.println(Win32_NetworkAdapterSetting.getIndex(networkAdapterId));
        }
    }
}
