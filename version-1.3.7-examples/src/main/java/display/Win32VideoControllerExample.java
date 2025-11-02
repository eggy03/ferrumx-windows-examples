package display;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_VideoController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32VideoControllerExample {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all gpu IDs
        List<String> gpuIdList = Win32_VideoController.getGPUID();

        // For each gpuID, fetch a map of its properties
        for(String gpuId : gpuIdList){
            Map<String, String> gpuMap = Win32_VideoController.getGPU(gpuId);
            // iterate through the map and print the properties
            for(Map.Entry<String, String> gpu : gpuMap.entrySet()){
                System.out.println(gpu.getKey()+ ": "+ gpu.getValue());
            }
        }
    }
}
