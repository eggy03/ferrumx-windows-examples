package mainboard;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_Baseboard;

import java.io.IOException;
import java.util.Map;

public class Win32Baseboard {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // will only give the last baseboard in case multiple instances of it are present
        Map<String, String> baseboardMap = Win32_Baseboard.getMotherboard();
        // iterate through the map and print the properties
        for(Map.Entry<String, String> baseboard : baseboardMap.entrySet()){
            System.out.println(baseboard.getKey()+ ": "+ baseboard.getValue());
        }
    }
}
