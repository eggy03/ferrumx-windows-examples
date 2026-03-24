package network.combined;

import io.github.eggy03.ferrumx.windows.entity.compounded.Win32NetworkAdapterToConfiguration;
import io.github.eggy03.ferrumx.windows.entity.network.Win32NetworkAdapter;
import io.github.eggy03.ferrumx.windows.entity.network.Win32NetworkAdapterConfiguration;
import io.github.eggy03.ferrumx.windows.service.compounded.Win32NetworkAdapterToConfigurationService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@SuppressWarnings("unused")
public class Win32NetworkCombinedExample {

    public static void main (String[] args){

        List<Win32NetworkAdapterToConfiguration> combinedNetwork =
                new Win32NetworkAdapterToConfigurationService().get();

        // json pretty print
        combinedNetwork.forEach(network -> log.info(network.toString()));

        // access individual fields
        combinedNetwork.forEach(network -> {
            String deviceId = network.getDeviceId();
            Win32NetworkAdapter adapter = network.getAdapter();
            List<Win32NetworkAdapterConfiguration> configurationList = network.getConfigurationList();
        });
    }
}
