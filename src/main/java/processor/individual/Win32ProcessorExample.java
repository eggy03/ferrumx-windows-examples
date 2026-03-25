package processor.individual;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.processor.Win32ProcessorService;

@SuppressWarnings("java:S106")
public class Win32ProcessorExample {

    public static void main(String[] args) {
        // with auto managed PowerShell session
        new Win32ProcessorService().get().forEach(System.out::println);

        // with caller managed session
        try (PowerShell shell = PowerShell.openSession()) {
            new Win32ProcessorService().get(shell).forEach(System.out::println);
        }

        // auto managed with timeout
        new Win32ProcessorService().get(5L).forEach(System.out::println);
    }
}