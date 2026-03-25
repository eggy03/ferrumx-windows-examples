package processor.individual;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.processor.Win32CacheMemoryService;

@SuppressWarnings("java:S106")
public class Win32CacheMemoryExample {

    public static void main(String[] args) {
        // with auto managed PowerShell session
        new Win32CacheMemoryService().get().forEach(System.out::println);

        // with caller managed session
        try (PowerShell shell = PowerShell.openSession()) {
            new Win32CacheMemoryService().get(shell).forEach(System.out::println);
        }

        // auto managed with timeout
        new Win32CacheMemoryService().get(5L).forEach(System.out::println);
    }
}