package system;

import io.github.eggy03.ferrumx.windows.service.system.Win32ComputerSystemService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Win32ComputerSystemExample {

    public static void main (String[] args) {

        new Win32ComputerSystemService().get().ifPresent(computerSystem -> log.info(computerSystem.toString()));
    }

}
