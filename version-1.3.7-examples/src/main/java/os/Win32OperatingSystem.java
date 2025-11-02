package os;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.operating_system.Win32_OperatingSystem;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32OperatingSystem {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all os IDs
        List<String> osIdList = Win32_OperatingSystem.getOSList();

        // For each osID, fetch a map of its properties
        for(String osId : osIdList){
            Map<String, String> osMap = Win32_OperatingSystem.getOSInfo(osId);
            // iterate through the map and print the properties
            for(Map.Entry<String, String> os : osMap.entrySet()){
                System.out.println(os.getKey()+ ": "+ os.getValue());
            }
        }
    }
}
