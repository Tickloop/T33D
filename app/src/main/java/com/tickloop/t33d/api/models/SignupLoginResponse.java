package com.tickloop.t33d.api.models;

import com.google.gson.annotations.SerializedName;

public class SignupLoginResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("user")
    private Player player;

    public SignupLoginResponse(String status, Player player){
        this.status = status;
        this.player = player;
    }

    public String getStatus() {
        return status;
    }

    public Player getPlayer() {
        return player;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
