package com.tickloop.t33d.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static final String BASE_URL = "https://t33d.herokuapp.com/";
    private static Retrofit r = null;

    public static Retrofit getClient() {
        if(r == null){
            //OkHttpClient to follow redirects
            OkHttpClient client = new OkHttpClient.Builder()
                    .followRedirects(true)
                    .followSslRedirects(true)
                    .build();

            // initialize the client
            r = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return r;
    }

}
