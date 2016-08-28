package com.github.akosbordas.authentication;

public class CredentialsProvider {

    private static String username;
    private static String password;


    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        CredentialsProvider.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        CredentialsProvider.password = password;
    }





}
