package com.tickloop.t33d.api.models;

import com.google.gson.annotations.SerializedName;

public class JoinHostGameResponse {
    @SerializedName("status")
    String status;

    @SerializedName("lobby")
    String lobby;

    public JoinHostGameResponse(String status, String lobby){
        this.status = status;
        this.lobby = lobby;
    }

    public String getLobby() {
        return lobby;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLobby(String lobby) {
        this.lobby = lobby;
    }
}
