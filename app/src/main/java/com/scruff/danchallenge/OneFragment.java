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
import java.util.List;


public class OneFragment extends Fragment {
    private View view;
    private List<Place> mPlaces;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.one_fragment, container, false);

        Collection<State> places = ((MyApplication) getActivity().getApplicationContext()).getStateMap().values();
        mPlaces = new ArrayList<Place>();

        for (Place p : places) {
            if (p.getPop() > 1000000) {
                mPlaces.add(p);
            }
        }
        //Arrays.sort( mPlaces );

        setRecyclerView();
        return view;

    }

    //Setting recycler view
    private void setRecyclerView() {

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items

        RecyclerView_Adapter adapter = new RecyclerView_Adapter(mPlaces);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview

    }
}
