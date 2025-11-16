package processor.individual;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.processor.Win32AssociatedProcessorMemoryService;
import io.github.eggy03.ferrumx.windows.service.processor.Win32CacheMemoryService;
import io.github.eggy03.ferrumx.windows.service.processor.Win32ProcessorService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Win32ProcessorAndCacheExample {

    public static void main(String[] args){
        // This example shows how to query each of Win32_Processor, Win32_AssociatedProcessorMemory and Win32_CacheMemory.
        // You can also use service.get() instead of service.get(Powershell) to have an auto managed powershell session
        // However, it is recommended to create and re-use your powershell session for batch queries like this
        try (PowerShell shell = PowerShell.openSession()){

            new Win32ProcessorService().get(shell)
                    .forEach(processor -> log.info(processor.toString()));

            new Win32AssociatedProcessorMemoryService().get(shell)
                    .forEach(apm -> log.info(apm.toString()));

            new Win32CacheMemoryService().get(shell)
                    .forEach(cache -> log.info(cache.toString()));
        }
    }
}
