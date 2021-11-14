package com.tickloop.t33d.api.models;

import com.google.gson.annotations.SerializedName;

public class PlayGameResponse {
    @SerializedName("status")
    String status;

    @SerializedName("username")
    String username;

    public PlayGameResponse(String status, String username){
        this.status = status;
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public String getUsername() {
        return username;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
