package com.example.marcus.knowYou.NaviFragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.marcus.knowYou.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marcus on 16/4/8.
 */
public class Community extends Fragment {
    private LayoutInflater inflater;
    private View view;
    private ListView listView;
    private List<Map<String,String>> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        view = inflater.inflate(R.layout.community,null);
        setListView();
        return view;
    }

    private void setListView() {
        listView = (ListView) view.findViewById(R.id.listview);
        list = new ArrayList<>();
        for (int i=0;i<10;i++){
            Map<String,String> map = new HashMap<>();
            map.put("topic_pic",String.valueOf(R.drawable.godxiang));
            map.put("topic_name","#哥们去哪儿#");
            map.put("topic_brief","1320个旅游狂魔");
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),list,R.layout.community_listview,
                new String[]{"topic_pic","topic_name","topic_brief"},
                new int[]{R.id.topic_pic,R.id.topic_name,R.id.topic_brief});
        listView.setAdapter(adapter);
    }
}
