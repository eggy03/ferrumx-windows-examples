package mainboard;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_PortConnector;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32PortConnector {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all PortConnector IDs
        List<String> portConnectorIdList = Win32_PortConnector.getBaseboardPortID();

        // For each PortConnectorID, fetch a map of its properties
        for(String portConnectorId : portConnectorIdList){
            Map<String, String> portConnectorMap = Win32_PortConnector.getBaseboardPorts(portConnectorId);
            // iterate through the map and print the properties
            for(Map.Entry<String, String> portConnector : portConnectorMap.entrySet()){
                System.out.println(portConnector.getKey()+ ": "+ portConnector.getValue());
            }
        }
    }
}
