package memory;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.memory.Win32PhysicalMemoryService;

@SuppressWarnings("java:S106")
public class Win32PhysicalMemoryExample {

    public static void main(String[] args) {

        // with auto managed PowerShell session
        new Win32PhysicalMemoryService().get().forEach(System.out::println);

        // with caller managed session
        try (PowerShell shell = PowerShell.openSession()) {
            new Win32PhysicalMemoryService().get(shell).forEach(System.out::println);
        }

        // auto managed with timeout
        new Win32PhysicalMemoryService().get(5L).forEach(System.out::println);
    }
}