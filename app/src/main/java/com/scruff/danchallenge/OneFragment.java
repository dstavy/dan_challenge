package com.scruff.danchallenge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class OneFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_fragment, container, false);
        List<Place> oneMStates = new ArrayList<Place>();

        Collection<State> states = ((MyApplication) getActivity().getApplicationContext()).getStateMap().values();

        for (State s : states) {
            if (s.getPop() > 1000000) {
                oneMStates.add(s);
            }
        }
        Collections.sort(oneMStates, new Comparator<Place>() {
            @Override
            public int compare(Place o1, Place o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        setRecyclerView(view, oneMStates);
        return view;

    }

    //Setting recycler view
    private void setRecyclerView(View view, List<Place> places) {

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items

        RecyclerView_Adapter adapter = new RecyclerView_Adapter(places);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview

    }
}
