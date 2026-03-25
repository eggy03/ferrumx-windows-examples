package system;

import io.github.eggy03.ferrumx.windows.service.system.Win32ProcessService;

@SuppressWarnings("java:S106")
public class Win32ProcessExample {

    public static void main(String[] args) {
        new Win32ProcessService().get().forEach(System.out::println);
    }
}