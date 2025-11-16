package user;

import io.github.eggy03.ferrumx.windows.service.user.Win32UserAccountService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Win32UserAccountExample {

    public static void main (String[] args) {
        new Win32UserAccountService().get()
                .forEach(user -> log.info(user.toString()));
    }
}
