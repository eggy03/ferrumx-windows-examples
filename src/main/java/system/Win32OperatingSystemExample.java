package system;

import io.github.eggy03.ferrumx.windows.service.system.Win32OperatingSystemService;

@SuppressWarnings("java:S106")
public class Win32OperatingSystemExample {

    public static void main(String[] args) {
        new Win32OperatingSystemService().get().forEach(System.out::println);

    }
}