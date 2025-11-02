package peripheral;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_PortableBattery;

import java.io.IOException;
import java.util.Map;

public class Win32PortableBatteryExample {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        Map<String, String> batteryMap = Win32_PortableBattery.getPortableBattery();
        // iterate through the map and print the properties
        for(Map.Entry<String, String> battery : batteryMap.entrySet()){
            System.out.println(battery.getKey()+ ": "+ battery.getValue());
        }

    }
}
