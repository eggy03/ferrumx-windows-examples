package display;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.display.Win32VideoControllerService;

public class Win32VideoControllerExample {

    public static void main(String[] args) {

        // retrieve and print all Video Controller data using an auto-managed PowerShell session
        // The "get()" method returns a list of Win32VideoController entity objects,
        // and each object’s "toString()" prints its fields in JSON pretty-print format.
        new Win32VideoControllerService()
                .get()
                .forEach(videoController -> System.out.println(videoController.toString()));

        // you can also reuse your own PowerShell session if you plan to query multiple services.
        try(PowerShell shell = PowerShell.openSession()){
            new Win32VideoControllerService()
                    .get(shell)
                    .forEach(videoController -> System.out.println(videoController.toString()));
        }

        // you can also access individual fields for each Win32VideoController object
        new Win32VideoControllerService()
                .get()
                .forEach(videoController ->
                        System.out.println(videoController.getDeviceId()+", "+videoController.getName()) // more fields accessible
                );
    }
}
