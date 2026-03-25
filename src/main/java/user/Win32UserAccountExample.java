package user;

import io.github.eggy03.ferrumx.windows.service.user.Win32UserAccountService;

@SuppressWarnings("java:S106")
public class Win32UserAccountExample {

    public static void main(String[] args) {
        new Win32UserAccountService().get().forEach(System.out::println);
    }
}