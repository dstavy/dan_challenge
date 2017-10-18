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


public class TwoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two_fragment, container, false);
        Spinner stateSpinner = view.findViewById(spinner);
        final TextView avgPopTextView = view.findViewById(R.id.avg_pop);
        final CardView layout = view.findViewById(R.id.avg_pop_card);

        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String stateName = parent.getItemAtPosition(position).toString();
                Map<String, State> states = ((MyApplication) getActivity().getApplicationContext()).getStateMap();
                State state = states.get(stateName);
                if (state != null) {
                    avgPopTextView.setText(NumberFormat.getInstance().format(state.getAvgPop()));
                    layout.setVisibility(View.VISIBLE);
                } else {
                    avgPopTextView.setText("");
                    layout.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        stateSpinner.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                layout.setVisibility(View.INVISIBLE);
                return false;
            }
        });

        stateSpinner.setSelection(0);

        return view;
    }

}
