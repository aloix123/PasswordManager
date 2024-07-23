package com.mainpackage.PasswordManager.Util;

public class UserUtil {
    private static Long id;
    private static String login;
    private static String mainPassword;
    private static String email;
    private static byte[] image;

    public static  Long getId() {
        return id;
    }

    public static void setId(Long id) {
        UserUtil.id = id;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        UserUtil.login = login;
    }

    public static String getMainPassword() {
        return mainPassword;
    }

    public static void setMainPassword(String mainPassword) {
        UserUtil.mainPassword = mainPassword;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserUtil.email = email;
    }

    public static byte[] getImage() {
        return image;
    }

    public static void setImage(byte[] image) {
        UserUtil.image = image;
    }
}
