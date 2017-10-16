package com.scruff.danchallenge;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class DemoViewHolder extends RecyclerView.ViewHolder {


    public final TextView place;
    public final TextView pop;


    public DemoViewHolder(View view) {
        super(view);


        this.place = view.findViewById(R.id.place);
        this.pop = view.findViewById(R.id.pop);

    }


}