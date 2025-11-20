package system;

import io.github.eggy03.ferrumx.windows.service.system.Win32EnvironmentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Win32EnvironmentExample {

    public static void main (String[] args) {

        new Win32EnvironmentService().get().forEach(environment -> log.info(environment.toString()));
    }
}
