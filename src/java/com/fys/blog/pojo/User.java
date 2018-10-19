package com.fys.blog.pojo;

public class User {
    String username;
    String password;
    String nickname;
    String lastLogin;
    String blogId;
    String birthday;

    public User() {

    }

    public User(String username, String password, String nickname, String birthday) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", blogId='" + blogId + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}