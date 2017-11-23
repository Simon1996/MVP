package com.insidegmail.developed.mvp_babikyan.main.presenter;

import com.insidegmail.developed.mvp_babikyan.main.MainContract;

import com.insidegmail.developed.mvp_babikyan.network.Net;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Admin on 20.11.2017.
 */

public class MainImpPresenter extends BasePresenterImp<MainContract.View> implements MainContract.Presenter {

    private Net net;

    public MainImpPresenter(Net net) {
        this.net = net;
    }

    @Override
    public void generateList() {
        net.getList().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(requestNews -> {
                    getView().showList(requestNews);
                });
    }
}