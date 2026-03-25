package processor.individual;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.processor.Win32AssociatedProcessorMemoryService;

@SuppressWarnings("java:S106")
public class Win32AssociatedProcessorMemoryExample {

    public static void main(String[] args) {
        // with auto managed PowerShell session
        new Win32AssociatedProcessorMemoryService().get().forEach(System.out::println);

        // with caller managed session
        try (PowerShell shell = PowerShell.openSession()) {
            new Win32AssociatedProcessorMemoryService().get(shell).forEach(System.out::println);
        }

        // auto managed with timeout
        new Win32AssociatedProcessorMemoryService().get(5L).forEach(System.out::println);
    }
}