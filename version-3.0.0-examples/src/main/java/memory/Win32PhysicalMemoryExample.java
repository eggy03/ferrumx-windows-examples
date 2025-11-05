package memory;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.memory.Win32PhysicalMemoryService;


public class Win32PhysicalMemoryExample {

    public static void main(String[] args){

        // retrieve and print all PhysicalMemory data using an auto-managed PowerShell session
        // The "get()" method returns a list of Win32PhysicalMemory entity objects,
        // and each object’s "toString()" prints its fields in JSON pretty-print format.
        new Win32PhysicalMemoryService()
                .get()
                .forEach(memory -> System.out.println(memory.toString()));

        // you can also reuse your own PowerShell session if you plan to query multiple services.
        try(PowerShell shell = PowerShell.openSession()){
            new Win32PhysicalMemoryService()
                    .get(shell)
                    .forEach(memory -> System.out.println(memory.toString()));
        }

        // you can also access individual fields for each Win32PhysicalMemory object
        new Win32PhysicalMemoryService()
                .get()
                .forEach(memory ->
                        System.out.println(memory.getTag()+", "+memory.getPartNumber()) // more fields accessible
                );
    }
}
