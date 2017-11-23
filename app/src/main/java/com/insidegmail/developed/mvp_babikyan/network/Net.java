package com.insidegmail.developed.mvp_babikyan.network;

import com.insidegmail.developed.mvp_babikyan.data.Article;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Admin on 20.11.2017.
 */

public interface Net {
    Observable<List<Article>> getList();
}
