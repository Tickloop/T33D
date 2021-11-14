package com.tickloop.t33d.api.endpoints;

import com.tickloop.t33d.api.models.SignupLoginResponse;
import com.tickloop.t33d.api.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignupLogin {
    @POST("signup")
    Call<SignupLoginResponse> signup(@Body User user);

    @POST("login")
    Call<SignupLoginResponse> login(@Body User user);
}
