package os;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.operating_system.Win32_TimeZone;

import java.io.IOException;
import java.util.Map;

public class Win32TimeZone {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        Map<String, String> tzMap = Win32_TimeZone.getOSTimeZone();
        // iterate through the map and print the properties
        for(Map.Entry<String, String> tz : tzMap.entrySet()){
            System.out.println(tz.getKey()+ ": "+ tz.getValue());
        }
    }
}
