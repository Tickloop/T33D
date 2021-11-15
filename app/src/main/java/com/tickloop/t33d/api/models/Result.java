package com.tickloop.t33d.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    @SerializedName("status")
    private String status;

    @SerializedName("users")
    private List<String> users;

    public Result(String status, List<String> users) {
        this.status = status;
        this.users = users;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getUsers() {
        return users;
    }
}
