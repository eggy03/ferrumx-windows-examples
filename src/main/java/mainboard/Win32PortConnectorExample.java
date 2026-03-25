package mainboard;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.mainboard.Win32PortConnectorService;

@SuppressWarnings("java:S106")
public class Win32PortConnectorExample {

    public static void main(String[] args) {

        // with auto managed PowerShell session
        new Win32PortConnectorService().get().forEach(System.out::println);

        // with caller managed session
        try (PowerShell shell = PowerShell.openSession()) {
            new Win32PortConnectorService().get(shell).forEach(System.out::println);
        }

        // auto managed with timeout
        new Win32PortConnectorService().get(5L).forEach(System.out::println);
    }
}