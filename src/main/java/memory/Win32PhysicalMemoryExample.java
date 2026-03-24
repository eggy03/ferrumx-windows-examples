package memory;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_PhysicalMemory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32PhysicalMemoryExample {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all memory IDs
        List<String> memoryIdList = Win32_PhysicalMemory.getTag();

        // For each memoryID, fetch a map of its properties
        for(String memoryId : memoryIdList){
            Map<String, String> memoryMap = Win32_PhysicalMemory.getMemory(memoryId);
            // iterate through the map and print the properties
            memoryMap.forEach((k, v)-> System.out.println(k+": "+v));
        }
    }
}
