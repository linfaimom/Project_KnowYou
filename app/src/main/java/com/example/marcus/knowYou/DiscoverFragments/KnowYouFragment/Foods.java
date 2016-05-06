package com.example.marcus.knowYou.DiscoverFragments.KnowYouFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.etsy.android.grid.StaggeredGridView;
import com.example.marcus.knowYou.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marcus on 16/4/13.
 */
public class Foods extends Fragment {
    private StaggeredGridView foodsList;
    private List<Map<String,String>> list;
    private int[] pics = new int[]{
            R.drawable.food1,R.drawable.food2,R.drawable.food3,
            R.drawable.food4,R.drawable.food5,R.drawable.food6};
    private String[] infos = new String[]{
            "金华汤包", "东阳瓦罐鸡", "兰溪鸡子馃",
            "油炸臭干夹馒头", "金华拉拉面", "金华大汤圆"};
    private SimpleAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discover_knowyou_foods,null);
        foodsList = (StaggeredGridView) view.findViewById(R.id.grid_view);
        initList();
        setAdapter();
        return view;
    }

    private void initList() {
        list = new ArrayList<>();
        for (int i=0; i<infos.length; i++){
            Map<String,String> map = new HashMap<>();
            map.put("image",String.valueOf(pics[i]));
            map.put("content",infos[i]);
            list.add(map);
        }
    }

    private void setAdapter() {
        adapter = new SimpleAdapter(getActivity(),list,R.layout.discover_knowyou_foods_gridview,
                new String[]{"image","content"},
                new int[]{R.id.image,R.id.content});
        foodsList.setAdapter(adapter);
    }


}
