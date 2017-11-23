package com.insidegmail.developed.mvp_babikyan.main;

import com.insidegmail.developed.mvp_babikyan.data.Article;
import com.insidegmail.developed.mvp_babikyan.main.presenter.BasePresenter;
import com.insidegmail.developed.mvp_babikyan.main.presenter.BaseView;

import java.util.List;

/**
 * Created by Admin on 20.11.2017.
 */

public interface MainContract {
    interface View extends BaseView {
        void showList(List<Article> newsList);
    }

    interface Presenter extends BasePresenter<View> {
        void generateList();

    }
}