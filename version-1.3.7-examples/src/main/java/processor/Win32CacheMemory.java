package processor;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.associatedclasses.Win32_AssociatedProcessorMemory;
import com.ferrumx.system.hardware.Win32_CacheMemory;
import com.ferrumx.system.hardware.Win32_Processor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32CacheMemory {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all CPU IDs
        List<String> cpuIdList = Win32_Processor.getProcessorList();


        // For each CPUID, fetch a list of its Cache IDs
        for(String cpuId : cpuIdList){
            // iterate through the list and print the cache IDs
            List<String> cacheIdList = Win32_AssociatedProcessorMemory.getCacheID(cpuId);
            // for each cacheID, get a map of Cache Memory and print its details
            for(String cacheId: cacheIdList){
                Map<String, String> cacheMemoryMap = Win32_CacheMemory.getCPUCache(cacheId);
                for(Map.Entry<String, String> cacheMemory: cacheMemoryMap.entrySet()){
                    System.out.println(cacheMemory.getKey()+ ": "+cacheMemory.getValue());
                }
                System.out.println();
            }
        }
    }
}
