package peripheral;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.peripheral.Win32BatteryService;

@SuppressWarnings("java:S106")
public class Win32BatteryExample {

    public static void main(String[] args) {

        // with auto managed PowerShell session
        new Win32BatteryService().get().forEach(System.out::println);

        // with caller managed session
        try (PowerShell shell = PowerShell.openSession()) {
            new Win32BatteryService().get(shell).forEach(System.out::println);
        }

        // auto managed with timeout
        new Win32BatteryService().get(5L).forEach(System.out::println);
    }
}