package user;

import io.github.eggy03.ferrumx.windows.service.user.UserService;

@SuppressWarnings("java:S106")
public class UserExample {

    public static void main(String[] args) {
        System.out.println(new UserService().getUser());
    }
}