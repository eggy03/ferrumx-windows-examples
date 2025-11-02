package mainboard;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_BIOS;

import java.io.IOException;
import java.util.Map;

public class Win32BiosExample {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // only exposes info about the PrimaryBIOS
        Map<String, String> primaryBiosMap = Win32_BIOS.getPrimaryBIOS();
        // iterate through the map and print the properties
        for(Map.Entry<String, String> primaryBios : primaryBiosMap.entrySet()){
            System.out.println(primaryBios.getKey()+ ": "+ primaryBios.getValue());
        }
    }
}
