package com.imitaz.communicating_upwards_from_nested_fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Fragment_A extends Fragment implements View.OnClickListener {
    private View view;
    private Context mContext;
    Button button;


    private ViewReplaceInterface mActivityListener;


    @Override
    public void onClick(View v) {
        Log.d("onClick", "are");
        mActivityListener.currentView("Hello, First fragment. I am the Fragment_B.");
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mActivityListener = (ViewReplaceInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement interface");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_a, container, false);
        view.findViewById(R.id.btn_fragment_a).setOnClickListener(this);
        mContext = getActivity().getApplicationContext();
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivityListener = null;
    }

}
