package system;

import io.github.eggy03.ferrumx.windows.service.system.Win32ComputerSystemService;

@SuppressWarnings("java:S106")
public class Win32ComputerSystemExample {

    public static void main(String[] args) {
        new Win32ComputerSystemService().get().ifPresent(System.out::println);
    }

}