package system;

import io.github.eggy03.ferrumx.windows.service.system.Win32PnPEntityService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Win32PnPEntityExample {

    public static void main (String[] args) {

        new Win32PnPEntityService().get().forEach(pnp -> log.info(pnp.toString()));
    }
}
