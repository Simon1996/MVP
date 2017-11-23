package com.insidegmail.developed.mvp_babikyan.main.presenter;

/**
 * Created by Admin on 20.11.2017.
 */

public interface BasePresenter<V extends BaseView> {
    void attach(V view);

    void detach(V view);

    boolean isAttached(V view);

    V getView();
}