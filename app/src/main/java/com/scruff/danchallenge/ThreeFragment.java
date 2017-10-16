package com.scruff.danchallenge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Map;

import static com.scruff.danchallenge.R.id.spinner;


public class ThreeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.three_fragment, container, false);

        Spinner stateSpinner = view.findViewById(spinner);
        final TextView smallCity = view.findViewById(R.id.name_s);
        final TextView bigCity = view.findViewById(R.id.name_b);
        final TextView smallCityPop = view.findViewById(R.id.pop_s);
        final TextView bigCityPop = view.findViewById(R.id.pop_b);
        final CardView layoutSmallCity = view.findViewById(R.id.small_c);
        final CardView layoutBigCity = view.findViewById(R.id.big_c);

        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String stateName = parent.getItemAtPosition(position).toString();
                Map<String, State> states = ((MyApplication) getActivity().getApplicationContext()).getStateMap();
                State state = states.get(stateName);
                if (state != null) {
                    Place smallestCity = state.getSmallestCity();
                    Place biggestCity = state.getBigestCity();
                    smallCity.setText(smallestCity.getName());
                    smallCityPop.setText(NumberFormat.getInstance().format(smallestCity.getPop()));
                    bigCity.setText(biggestCity.getName());
                    bigCityPop.setText(NumberFormat.getInstance().format(biggestCity.getPop()));
                    layoutBigCity.setVisibility(View.VISIBLE);
                    layoutSmallCity.setVisibility(View.VISIBLE);
                } else {
                    smallCity.setText("");
                    smallCityPop.setText("");
                    bigCity.setText("");
                    bigCityPop.setText("");
                    layoutBigCity.setVisibility(View.INVISIBLE);
                    layoutSmallCity.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        stateSpinner.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                layoutBigCity.setVisibility(View.INVISIBLE);
                layoutSmallCity.setVisibility(View.INVISIBLE);
                return false;
            }
        });


        stateSpinner.setSelection(0);
        return view;
    }

}
