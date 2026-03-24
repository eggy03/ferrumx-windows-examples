package user;

import io.github.eggy03.ferrumx.windows.service.user.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserExample {

    public static void main (String[] args){
        log.info(new UserService().getUser().toString());
    }
}
