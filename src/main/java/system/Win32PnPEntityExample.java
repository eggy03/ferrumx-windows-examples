package system;

import io.github.eggy03.ferrumx.windows.service.system.Win32PnPEntityService;

@SuppressWarnings("java:S106")
public class Win32PnPEntityExample {

    public static void main(String[] args) {
        new Win32PnPEntityService().get().forEach(System.out::println);
    }
}