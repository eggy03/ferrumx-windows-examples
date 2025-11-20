package system;

import io.github.eggy03.ferrumx.windows.service.system.Win32OperatingSystemService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Win32OperatingSystemExample {

    public static void main (String[] args) {

        new Win32OperatingSystemService().get().forEach(operatingSystem -> log.info(operatingSystem.toString()));

    }
}
