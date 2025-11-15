package mainboard;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.mainboard.Win32PortConnectorService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Win32PortConnectorExample {

    public static void main(String[] args){

        // retrieve and print all PortConnector data using an auto-managed PowerShell session
        // The "get()" method returns a list of Win32PortConnector entity objects,
        // and each object’s "toString()" prints its fields in JSON pretty-print format.
        new Win32PortConnectorService()
                .get()
                .forEach(portConnector -> log.info(portConnector.toString()));

        // you can also reuse your own PowerShell session if you plan to query multiple services.
        try(PowerShell shell = PowerShell.openSession()){
            new Win32PortConnectorService()
                    .get(shell)
                    .forEach(portConnector -> log.info(portConnector.toString()));
        }

        // you can also access individual fields for each Win32PortConnector object
        new Win32PortConnectorService()
                .get()
                .forEach(portConnector ->
                        log.info("{}, {}", portConnector.getTag(), portConnector.getExternalReferenceDesignator()) // more fields accessible
                );
    }
}
