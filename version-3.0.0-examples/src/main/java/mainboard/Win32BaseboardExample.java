package mainboard;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.mainboard.Win32BaseboardService;

public class Win32BaseboardExample {

    public static void main(String[] args) {

        // retrieve and print all baseboard data using an auto-managed PowerShell session
        // The "get()" method returns a list of Win32Baseboard entity objects,
        // and each object’s "toString()" prints its fields in JSON pretty-print format.
        new Win32BaseboardService()
                .get()
                .forEach(baseboard -> System.out.println(baseboard.toString()));

        // you can also reuse your own PowerShell session if you plan to query multiple services.
        try(PowerShell shell = PowerShell.openSession()){
            new Win32BaseboardService()
                    .get(shell)
                    .forEach(baseboard -> System.out.println(baseboard.toString()));
        }

        // you can also access individual fields for each Win32Baseboard object
        new Win32BaseboardService()
                .get()
                .forEach(baseboard ->
                        System.out.println(baseboard.getModel()+", "+baseboard.getManufacturer()) // more fields accessible
                );
    }
}
