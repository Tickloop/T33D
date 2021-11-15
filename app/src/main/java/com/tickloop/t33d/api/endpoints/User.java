package com.tickloop.t33d.api.endpoints;

import com.tickloop.t33d.api.models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface User {
    @GET("user")
    Call<Result> getUsers();
}
