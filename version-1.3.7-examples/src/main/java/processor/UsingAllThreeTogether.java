package processor;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.associatedclasses.Win32_AssociatedProcessorMemory;
import com.ferrumx.system.hardware.Win32_CacheMemory;
import com.ferrumx.system.hardware.Win32_Processor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UsingAllThreeTogether {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all CPU IDs
        List<String> cpuIdList = Win32_Processor.getProcessorList();

        for(String cpuId : cpuIdList){
            // get a map of cpu properties for the current CPU
            Map<String, String> cpuMap = Win32_Processor.getCurrentProcessor(cpuId);
            for(Map.Entry<String, String> cpu: cpuMap.entrySet()){
                System.out.println(cpu.getKey()+ ": "+cpu.getValue());
            }
            System.out.println();

            // get a list of CacheIDs for the current CPU
            List<String> cacheIdList = Win32_AssociatedProcessorMemory.getCacheID(cpuId);

            for(String cacheId: cacheIdList){
                // for each cacheID, get a map of Cache Memory and print its details
                Map<String, String> cacheMemoryMap = Win32_CacheMemory.getCPUCache(cacheId);
                for(Map.Entry<String, String> cacheMemory: cacheMemoryMap.entrySet()){
                    System.out.println(cacheMemory.getKey()+ ": "+cacheMemory.getValue());
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
