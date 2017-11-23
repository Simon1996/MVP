package com.insidegmail.developed.mvp_babikyan.ui.holder;

/**
 * Created by Simon on 23.11.2017.
 */


import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.insidegmail.developed.mvp_babikyan.R;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

   public TextView title;
   public ImageView imageView;

    @SuppressLint("WrongViewCast")
    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        title = itemView.findViewById(R.id.title_card);
        imageView = itemView.findViewById(R.id.image);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}