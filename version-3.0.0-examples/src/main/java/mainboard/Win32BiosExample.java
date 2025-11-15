package mainboard;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.mainboard.Win32BiosService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Win32BiosExample {

    public static void main(String[] args){

        // retrieve and print all Bios data using an auto-managed PowerShell session
        // The "get()" method returns a list of Win32Bios entity objects,
        // and each object’s "toString()" prints its fields in JSON pretty-print format.
        new Win32BiosService()
                .get()
                .forEach(bios -> log.info(bios.toString()));

        // you can also reuse your own PowerShell session if you plan to query multiple services.
        try(PowerShell shell = PowerShell.openSession()){
            new Win32BiosService()
                    .get(shell)
                    .forEach(bios -> log.info(bios.toString()));
        }

        // you can also access individual fields for each Win32Bios object
        new Win32BiosService()
                .get()
                .forEach(bios ->
                        log.info("{}, {}", bios.getName(), bios.isPrimaryBios()) // more fields accessible
                );
    }
}
