package com.insidegmail.developed.mvp_babikyan.network;

/**
 * Created by Simon on 23.11.2017.
 */


import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.insidegmail.developed.mvp_babikyan.StrRequest;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private final Gson gson;
    private OkHttpClient client;
    private NewsApi newsApi;

    public RestClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NonNull String message) {
                Log.e("HTTP: ", message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .build();
        gson = new Gson();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(StrRequest.API +"/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
       newsApi = retrofit.create(NewsApi.class);
    }

    public NewsApi getNewsApi() {
        return newsApi ;
    }

    public OkHttpClient getClient() {
        return client;
    }

    public Gson getGson() {
        return gson;
    }
}
