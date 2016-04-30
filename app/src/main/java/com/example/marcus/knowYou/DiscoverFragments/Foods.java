package com.example.marcus.knowYou.DiscoverFragments;

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
import java.util.List;
import java.util.Map;

/**
 * Created by marcus on 16/4/13.
 */
public class Foods extends Fragment {
    private ListView foodsList;
    private List<Map<String,String>> list;
    private int[] pics = new int[]{};
    private String[][] infos = new String[][]{
            {"七里香","123"},
            {"扬州风味","123"},
            {"巴比汉堡","123"},
            {"东吴人家","123"},
            {"街7中式快餐","123"},
            {"东吴人家","123"},
            {"台湾烤鱼","123"},
            {"正宗韩国快餐","123"},
            {"麦尚堡","123"},
            {"贝壳汉堡","123"}
    };
    private SimpleAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discover_foods,null);
        foodsList = (ListView) view.findViewById(R.id.foodsList);
        initList();
        setAdapter();
        return view;
    }

    private void initList() {
        list = new ArrayList<>();
        for (int i=0; i<infos.length; i++){
            Map<String,String> map = new HashMap<>();
            map.put("pic",String.valueOf(R.drawable.girl));
            map.put("title",infos[i][0]);
            map.put("info",infos[i][1]);
            map.put("star",String.valueOf(R.drawable.me));
            map.put("type","浙师大北门");
            list.add(map);
        }
    }

    private void setAdapter() {
        adapter = new SimpleAdapter(getActivity(),list,R.layout.discover_foods_listview,
                new String[]{"pic","title","info","star","type"},
                new int[]{R.id.pic,R.id.title,R.id.info,R.id.star,R.id.type});
        foodsList.setAdapter(adapter);
    }


}
