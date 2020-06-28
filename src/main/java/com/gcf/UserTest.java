package com.gcf;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class UserTest {
    public static void main(String[] args) {
        User sUser = new User("小张三","15",null);
        User user = new User("大张三","55",sUser);
        User tempU = user;
        user = sUser;
        System.out.println(tempU.getName());
//        changeUser(user.user);
//        sUser.setName("111");
//        changeUser(sUser);
//        System.out.println(user.user.getName());
//        System.out.println(sUser.toString());
    }

    public static void changeUser(User user){
//        System.out.println(user.toString());
        user = new User("小小张三","25",null);
        System.out.println(user.toString());
    }


    @Getter
    @Setter
    public static class User{
        String name;
        String age;
        User user;

        public User(String name, String age, User user) {
            this.name = name;
            this.age = age;
            this.user = user;
        }
    }
}
