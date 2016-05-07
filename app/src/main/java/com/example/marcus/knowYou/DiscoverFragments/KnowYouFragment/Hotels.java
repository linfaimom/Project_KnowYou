package com.example.marcus.knowYou.DiscoverFragments.KnowYouFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.marcus.knowYou.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcus on 16/4/13.
 */
public class Hotels extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.discover_knowyou_hotels,null);
    }
}
