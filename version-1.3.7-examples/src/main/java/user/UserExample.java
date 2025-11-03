package user;

import com.ferrumx.system.currentuser.User;

public class UserExample {

    public static void main(String[] args){
        System.out.println(User.getUsername()+"\n"+User.getHome()+"\n"+User.getDirectory());
    }
}
