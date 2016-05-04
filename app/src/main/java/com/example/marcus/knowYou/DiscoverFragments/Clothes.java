package com.example.marcus.knowYou.DiscoverFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.etsy.android.grid.StaggeredGridView;
import com.example.marcus.knowYou.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcus on 16/4/13.
 */
public class Clothes extends Fragment {
    private View view;
    private LayoutInflater inflater;
    private StaggeredGridView gridView;
    private ArrayList<Map<String,String>> datas;
    private String[] contents = new String[]{
            "小清新","御姐范","萝莉控","港台味","欧美风","日韩流"};
    private int[] images = new int[]{
            R.drawable.clothes1,R.drawable.clothes2,R.drawable.clothes3,
            R.drawable.clothes4,R.drawable.clothes5,R.drawable.clothes6};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        view = inflater.inflate(R.layout.discover_clothes,null);
        setStaggeredGridView();
        return view;
    }

    private void setStaggeredGridView() {
        gridView = (StaggeredGridView) view.findViewById(R.id.grid_view);
        datas = new ArrayList<>();
        for (int i=0; i<images.length;i++) {
            Map<String,String> map = new HashMap<>();
            map.put("image",String.valueOf(images[i]));
            map.put("content",contents[i]);
            datas.add(map);
        }
        ListAdapter adapter = new SimpleAdapter(getActivity(),datas,R.layout.discover_staggeredgridview,
                new String[]{"image","content"},
                new int[]{R.id.image,R.id.content});
        gridView.setAdapter(adapter);
    }
}
