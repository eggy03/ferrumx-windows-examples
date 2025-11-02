package peripheral;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_Battery;

import java.io.IOException;
import java.util.Map;

public class Win32BatteryExample {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        Map<String, String> batteryMap = Win32_Battery.getBattery();
        // iterate through the map and print the properties
        for(Map.Entry<String, String> cpu : batteryMap.entrySet()){
            System.out.println(cpu.getKey()+ ": "+ cpu.getValue());
        }

    }
}
