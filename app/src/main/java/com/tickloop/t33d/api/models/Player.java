package com.tickloop.t33d.api.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * A player object is a part of LoginSignupResponse.
 * Token is the auth token sent by the server.
 */
public class Player implements Serializable {
    @SerializedName("username")
    private String username;

    @SerializedName("token")
    private String token;

    public Player(String username, String token){
        this.token = token;
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Player{" +
                "username='" + username + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
