package com.insidegmail.developed.mvp_babikyan.network;

import com.insidegmail.developed.mvp_babikyan.data.News;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Simon on 23.11.2017.
 */
public interface NewsApi {

    @Headers("Content-Type: application/json")
    @GET("v2/top-headlines")
    Observable<News> getNews(
            @Query("sources") String source,
            @Query("apiKey") String apiKey);
}