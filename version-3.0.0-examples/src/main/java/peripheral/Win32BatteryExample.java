package peripheral;

import io.github.eggy03.ferrumx.windows.service.peripheral.Win32BatteryService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Win32BatteryExample {

    public static void main (String[] args){

        // can also use service.get(Powershell) instead of service.get() to have a manually managed powershell session
        // it is recommended to create and re-use your powershell session for batch queries
        new Win32BatteryService().get()
                .forEach(printer -> log.info(printer.toString()));

        // you can also access individual fields via their getters
    }
}
