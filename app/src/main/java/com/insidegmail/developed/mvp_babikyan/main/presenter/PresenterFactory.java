package com.insidegmail.developed.mvp_babikyan.main.presenter;

/**
 * Created by Admin on 21.11.2017.
 */

public interface PresenterFactory<P extends BasePresenter> {
   P createPresenter();
}
