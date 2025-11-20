package system;

import io.github.eggy03.ferrumx.windows.service.system.Win32ProcessService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Win32ProcessExample {

    public static void main (String[] args) {

        new Win32ProcessService().get().forEach(process -> log.info(process.toString()));

    }
}
