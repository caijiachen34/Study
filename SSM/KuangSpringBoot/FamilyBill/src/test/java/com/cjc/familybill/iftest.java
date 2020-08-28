package com.cjc.familybill;

import org.thymeleaf.util.TextUtils;

public class iftest {
    public static void main(String[] args) {
        String username = null;
        String password = "1";
        usernameif(username);
        passwordif(password);

    }

    private static void passwordif(String password) {
        if (password!=null) {
            System.out.println("password is not null");
        }
    }

    private static void usernameif(String username) {
        if (username==null) {
            System.out.println("username is null");
            return;
        }
    }
}
