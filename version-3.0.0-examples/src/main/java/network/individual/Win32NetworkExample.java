package network.individual;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.entity.network.Win32NetworkAdapter;
import io.github.eggy03.ferrumx.windows.entity.network.Win32NetworkAdapterConfiguration;
import io.github.eggy03.ferrumx.windows.entity.network.Win32NetworkAdapterSetting;
import io.github.eggy03.ferrumx.windows.service.network.Win32NetworkAdapterConfigurationService;
import io.github.eggy03.ferrumx.windows.service.network.Win32NetworkAdapterService;
import io.github.eggy03.ferrumx.windows.service.network.Win32NetworkAdapterSettingService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Win32NetworkExample {

    public static void main (String[] args){
        try (PowerShell shell = PowerShell.openSession()){
            // This example shows how to query each Win32_* network class individually.
            // can also use service.get() instead of service.get(Powershell) to have an auto managed powershell session
            // it is recommended to create and re-use your powershell session for batch queries like this
            List<Win32NetworkAdapter> adapterList = new Win32NetworkAdapterService().get(shell);
            List<Win32NetworkAdapterConfiguration> configurationList = new Win32NetworkAdapterConfigurationService().get(shell);
            List<Win32NetworkAdapterSetting> settingList = new Win32NetworkAdapterSettingService().get(shell);

            adapterList.forEach(adapter -> log.info(adapter.toString()));
            configurationList.forEach(config -> log.info(config.toString()));
            settingList.forEach(setting -> log.info(setting.toString()));

            // you can also access individual fields via their getters
        }
    }
}
