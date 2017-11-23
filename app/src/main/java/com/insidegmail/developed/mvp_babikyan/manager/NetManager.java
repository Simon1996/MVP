package com.insidegmail.developed.mvp_babikyan.manager;

import com.insidegmail.developed.mvp_babikyan.StrRequest;
import com.insidegmail.developed.mvp_babikyan.data.Article;
import com.insidegmail.developed.mvp_babikyan.data.News;
import com.insidegmail.developed.mvp_babikyan.network.Net;
import com.insidegmail.developed.mvp_babikyan.network.RestClient;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Admin on 20.11.2017.
 */

public class NetManager implements Net {
    private final RestClient restClient;

    public NetManager() {
        this.restClient = new RestClient();
    }

    @Override
    public Observable<List<Article>> getList() {

        return restClient.getNewsApi().getNews("google-news", StrRequest.API_KEY).map(News::getArticles);

    }
}