package com.insidegmail.developed.mvp_babikyan.main.presenter;

/**
 * Created by Admin on 20.11.2017.
 */

abstract class BasePresenterImp<V extends BaseView> implements BasePresenter<V> {
    private V view;

    @Override
    public void attach(V view) {
        this.view = view;
    }

    @Override
    public void detach(V view) {
        if(isAttached(view)) {
            this.view = null;
        }
    }

    @Override
    public boolean isAttached(V view) {
        return this.view != null;
    }

    @Override
    public V getView() {
        return view;
    }
}
