package com.insidegmail.developed.mvp_babikyan.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.insidegmail.developed.mvp_babikyan.application.MyApp;
import com.insidegmail.developed.mvp_babikyan.main.presenter.BasePresenter;
import com.insidegmail.developed.mvp_babikyan.main.presenter.BaseView;
import com.insidegmail.developed.mvp_babikyan.main.presenter.PresenterFactory;
import com.insidegmail.developed.mvp_babikyan.manager.PresenterManager;
import com.insidegmail.developed.mvp_babikyan.network.Net;

import java.util.UUID;

/**
 * Created by Admin on 20.11.2017.
 */

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>>
        extends AppCompatActivity implements BaseView, PresenterFactory<P> {
    private static final String INSTANCE_KEY = "presenterKey";
    private String presenterKey = null;
    protected P presenter;
    protected V view;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        if (presenterKey == null) {
            presenterKey = UUID.randomUUID().toString();
        } else {
            savedInstanceState.putString(INSTANCE_KEY, presenterKey);
        }
        presenter = getPresenterManager().getPresenter(presenterKey, this);
        presenter.attach(view);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INSTANCE_KEY, presenterKey);
    }

    public abstract void initView();

    @Override
    protected void onDestroy() {
        if (isFinishing()) {
            getPresenterManager().removePresenter(presenterKey);
        }
        presenter.detach(view);
        super.onDestroy();

    }

    @SuppressLint("ShowToast")
    @Override
    public void showToast() {
        Toast.makeText(this, "MVP is working", Toast.LENGTH_SHORT);
    }

    @Override
    public void showProgressBar() {
        RelativeLayout layout = new RelativeLayout(this);
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(View.VISIBLE);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(100, 100);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        layout.addView(progressBar, params);
        setContentView(layout);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    protected Net getNet() {
        return MyApp.getApp(this).getNet();
    }

    protected PresenterManager getPresenterManager() {
        return MyApp.getApp(this).getPresenterManager();
    }
}