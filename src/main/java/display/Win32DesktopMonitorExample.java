package display;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.display.Win32DesktopMonitorService;

@SuppressWarnings("java:S106")
public class Win32DesktopMonitorExample {

    public static void main(String[] args) {

        // with auto managed PowerShell session
        new Win32DesktopMonitorService().get().forEach(System.out::println);

        // with caller managed session
        try (PowerShell shell = PowerShell.openSession()) {
            new Win32DesktopMonitorService().get(shell).forEach(System.out::println);
        }

        // auto managed with timeout
        new Win32DesktopMonitorService().get(5L).forEach(System.out::println);
    }
}