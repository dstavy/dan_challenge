package com.scruff.danchallenge;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.text.NumberFormat;
import java.util.List;


public class RecyclerView_Adapter extends
        RecyclerView.Adapter<PlaceViewHolder> {
    private final List<Place> places;


    public RecyclerView_Adapter(List<Place> places) {
        this.places = places;

    }


    @Override
    public int getItemCount() {
        return (null != places ? places.size() : 0);

    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        //Setting text over textview
        Place place = places.get(position);
        holder.place.setText(place.getName());
        holder.pop.setText(NumberFormat.getInstance().format(place.getPop()));
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(
            ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.item_row, viewGroup, false);

        return new PlaceViewHolder(mainGroup);
    }

}