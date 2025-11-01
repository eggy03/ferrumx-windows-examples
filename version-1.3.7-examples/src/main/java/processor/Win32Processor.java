package processor;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_Processor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32Processor {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all CPU IDs
        List<String> cpuIdList = Win32_Processor.getProcessorList();

        // For each CPUID, fetch a map of its properties
        for(String cpuId : cpuIdList){
            Map<String, String> cpuMap = Win32_Processor.getCurrentProcessor(cpuId);
            // iterate through the map and print the properties
            for(Map.Entry<String, String> cpu : cpuMap.entrySet()){
               System.out.println(cpu.getKey()+ ": "+ cpu.getValue());
            }
        }
    }
}
