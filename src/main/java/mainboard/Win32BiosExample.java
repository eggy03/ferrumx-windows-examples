package mainboard;

import com.profesorfalken.jpowershell.PowerShell;
import io.github.eggy03.ferrumx.windows.service.mainboard.Win32BiosService;

@SuppressWarnings("java:S106")
public class Win32BiosExample {

    public static void main(String[] args) {

        // with auto managed PowerShell session
        new Win32BiosService().get().forEach(System.out::println);

        // with caller managed session
        try (PowerShell shell = PowerShell.openSession()) {
            new Win32BiosService().get(shell).forEach(System.out::println);
        }

        // auto managed with timeout
        new Win32BiosService().get(5L).forEach(System.out::println);
    }
}