package network.combined;

import io.github.eggy03.ferrumx.windows.entity.compounded.Win32NetworkAdapterToConfiguration;
import io.github.eggy03.ferrumx.windows.service.compounded.Win32NetworkAdapterToConfigurationService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Win32NetworkCombinedExample {

    List<Win32NetworkAdapterToConfiguration> combinedNetwork =
            new Win32NetworkAdapterToConfigurationService().get();
}
