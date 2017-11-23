package com.insidegmail.developed.mvp_babikyan.ui.adapter;

/**
 * Created by Simon on 23.11.2017.
 */


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.insidegmail.developed.mvp_babikyan.R;
import com.insidegmail.developed.mvp_babikyan.data.Article;
import com.insidegmail.developed.mvp_babikyan.ui.holder.RecyclerViewHolders;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<Article> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Article> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        @SuppressLint("InflateParams") View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolders recyclerViewHolders = new RecyclerViewHolders(layoutView);
        return recyclerViewHolders;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.title.setText(itemList.get(position).getTitle());

        Glide.with(context)
                .load(itemList.get(position).getUrlToImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}