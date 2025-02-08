package com.example.user.afinal;

public class User {
    public String Nickname;
    public String Password;
    public String Favcolor;

    public User(String nickname, String password, String favcolor) {
        Nickname = nickname;
        Password = password;
        Favcolor = favcolor;
    }

    @Override
    public String toString() {
        return "User{" +
                "Nickname='" + Nickname + '\'' +
                ", Password='" + Password + '\'' +
                ", Favcolor='" + Favcolor + '\'' +
                '}';
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) { Password = password; }

    public String getFavcolor() {
        return Favcolor;
    }

    public void setFavcolor(String favcolor) { Favcolor = favcolor; }

}
