package display;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_DesktopMonitor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32DesktopMonitor {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all monitor IDs
        List<String> monitorIdList = Win32_DesktopMonitor.getMonitorID();

        // For each monitorID, fetch a map of its properties
        for(String monitorId : monitorIdList){
            Map<String, String> monitorMap = Win32_DesktopMonitor.getMonitorProperties(monitorId);
            // iterate through the map and print the properties
            for(Map.Entry<String, String> monitor : monitorMap.entrySet()){
                System.out.println(monitor.getKey()+ ": "+ monitor.getValue());
            }
        }
    }
}
