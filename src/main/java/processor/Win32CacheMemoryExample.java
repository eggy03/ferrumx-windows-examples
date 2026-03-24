package processor;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.associatedclasses.Win32_AssociatedProcessorMemory;
import com.ferrumx.system.hardware.Win32_CacheMemory;
import com.ferrumx.system.hardware.Win32_Processor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32CacheMemoryExample {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all CPU IDs
        List<String> cpuIdList = Win32_Processor.getProcessorList();


        // For each CPUID, fetch a list of its Cache IDs
        for(String cpuId : cpuIdList){
            // iterate through the cpuId List and get a list of CacheIDs for the current cpuid
            List<String> cacheIdList = Win32_AssociatedProcessorMemory.getCacheID(cpuId);
            // for each cacheID, get a map of Cache Memory and print its details
            for(String cacheId: cacheIdList){
                Map<String, String> cacheMemoryMap = Win32_CacheMemory.getCPUCache(cacheId);
                cacheMemoryMap.forEach((k, v)-> System.out.println(k+": "+v));
                System.out.println();
            }
        }
    }
}
