package system;

import io.github.eggy03.ferrumx.windows.service.compounded.HardwareIdService;

@SuppressWarnings("java:S106")
public class HardwareIdServiceExample {

    public static void main(String[] args) {
        new HardwareIdService().get().ifPresent(System.out::println);
    }
}