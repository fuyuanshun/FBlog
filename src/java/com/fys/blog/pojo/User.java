package com.fys.blog.pojo;

import java.util.List;

public class User {
    private String id;
    private String username;
    private String password;
    private String nickname;
    private String lastLogin;
    private String postId;
    private String birthday;
    private List<Post_> post;
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Post_> getPost() {
        return post;
    }

    public void setPost(List<Post_> post) {
        this.post = post;
    }

    public User() {

    }

    public User(String username, String password, String nickname, String birthday) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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
                ", blogId='" + postId + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}