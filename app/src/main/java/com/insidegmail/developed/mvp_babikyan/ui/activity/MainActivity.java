package com.insidegmail.developed.mvp_babikyan.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.insidegmail.developed.mvp_babikyan.R;
import com.insidegmail.developed.mvp_babikyan.ui.adapter.RecyclerViewAdapter;
import com.insidegmail.developed.mvp_babikyan.data.Article;
import com.insidegmail.developed.mvp_babikyan.main.MainContract;
import com.insidegmail.developed.mvp_babikyan.main.presenter.MainImpPresenter;

import java.util.List;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter> implements MainContract.View {

    GridLayoutManager gridLayoutManager;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        presenter.generateList();
    }

    @Override
    public void initView() {
        view = this;
    }

    @Override
    public MainContract.Presenter createPresenter() {
        return new MainImpPresenter(getNet());
    }

    @Override
    public void showList(List<Article> newsList) {
        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, newsList);
        recyclerView.setAdapter(rcAdapter);
        Log.e("NetManager", "Size:" + newsList.size());
    }
}
