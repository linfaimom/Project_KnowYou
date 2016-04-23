package com.example.marcus.knowYou.TravelFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marcus.knowYou.R;


/**
 * Created by marcus on 16/4/17.
 */
public class TravelFriends extends Fragment {
    private View view;
    private LayoutInflater inflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        view = inflater.inflate(R.layout.travel_friends,null);
        return view;
    }
}
