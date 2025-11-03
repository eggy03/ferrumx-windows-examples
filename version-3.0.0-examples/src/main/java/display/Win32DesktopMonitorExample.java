package display;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.display.Win32DesktopMonitorService;

public class Win32DesktopMonitorExample {

    public static void main(String[] args) {

        // retrieve and print all monitor data using an auto-managed PowerShell session
        // The "get()" method returns a list of Win32DesktopMonitor entity objects,
        // and each object’s "toString()" prints its fields in JSON pretty-print format.
        new Win32DesktopMonitorService()
                .get()
                .forEach(monitor -> System.out.println(monitor.toString()));

        // you can also reuse your own PowerShell session if you plan to query multiple services.
        try(PowerShell shell = PowerShell.openSession()){
            new Win32DesktopMonitorService()
                    .get(shell)
                    .forEach(monitor -> System.out.println(monitor.toString()));
        }

        // you can also access individual fields for each Win32DesktopMonitor object
        new Win32DesktopMonitorService()
                .get()
                .forEach(monitor ->
                        System.out.println(monitor.getDeviceId()+", "+monitor.getName()) // more fields accessible
                );
    }
}
