package processor;

import com.ferrumx.exceptions.ShellException;
import com.ferrumx.system.hardware.Win32_Processor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Win32Processor {

    public static void main(String[] args) throws IOException, ShellException, InterruptedException {

        // get a List of all CPU IDs
        List<String> processorIdList = Win32_Processor.getProcessorList();

        // For each CPUID, fetch a map of its properties
        for(String processorId: processorIdList){
            Map<String, String> object = Win32_Processor.getCurrentProcessor(processorId);
            // iterate through the map and print the properties
            for(Map.Entry<String, String> processorProperty : object.entrySet()){
               System.out.println(processorProperty.getKey()+ ": "+ processorProperty.getValue());
            }
        }
    }
}
