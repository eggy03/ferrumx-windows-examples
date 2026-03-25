package peripheral;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.peripheral.Win32SoundDeviceService;

@SuppressWarnings("java:S106")
public class Win32SoundDeviceExample {

    public static void main(String[] args) {

        // with auto managed PowerShell session
        new Win32SoundDeviceService().get().forEach(System.out::println);

        // with caller managed session
        try (PowerShell shell = PowerShell.openSession()) {
            new Win32SoundDeviceService().get(shell).forEach(System.out::println);
        }

        // auto managed with timeout
        new Win32SoundDeviceService().get(5L).forEach(System.out::println);
    }
}