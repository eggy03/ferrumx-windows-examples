package system;

import io.github.eggy03.ferrumx.windows.service.system.Win32EnvironmentService;

@SuppressWarnings("java:S106")
public class Win32EnvironmentExample {

    public static void main(String[] args) {
        new Win32EnvironmentService().get().forEach(System.out::println);
    }
}