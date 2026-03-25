package peripheral;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.peripheral.Win32PrinterService;

@SuppressWarnings("java:S106")
public class Win32PrinterExample {

    public static void main(String[] args) {

        // with auto managed PowerShell session
        new Win32PrinterService().get().forEach(System.out::println);

        // with caller managed session
        try (PowerShell shell = PowerShell.openSession()) {
            new Win32PrinterService().get(shell).forEach(System.out::println);
        }

        // auto managed with timeout
        new Win32PrinterService().get(5L).forEach(System.out::println);
    }
}