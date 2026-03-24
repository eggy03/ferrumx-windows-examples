package processor;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.associatedclasses.Win32_AssociatedProcessorMemory;
import com.ferrumx.system.hardware.Win32_Processor;

import java.io.IOException;
import java.util.List;

public class Win32AssociatedProcessorMemoryExample {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all CPU IDs
        List<String> cpuIdList = Win32_Processor.getProcessorList();

        // For each CPUID, fetch a list of its Cache IDs
        for(String id: cpuIdList){
            // iterate through the list and print the cache IDs
            Win32_AssociatedProcessorMemory.getCacheID(id).forEach(
                    cacheId -> System.out.println("CacheID: "+cacheId)
            );
        }
    }
}
