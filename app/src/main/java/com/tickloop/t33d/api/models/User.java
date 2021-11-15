package com.tickloop.t33d.api.models;

/**
 * This class is used to send user information in body of Login/Signup.
 * This is different than Player as Player holds the username and auth token sent by the server.
 */
public class User {
    String username;
    String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
