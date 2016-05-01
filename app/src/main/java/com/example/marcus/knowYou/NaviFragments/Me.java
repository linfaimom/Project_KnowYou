package com.example.marcus.knowYou.NaviFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.marcus.knowYou.OurAboutPage;
import com.example.marcus.knowYou.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by marcus on 16/4/8.
 */
public class Me extends Fragment {
    private LayoutInflater inflater;
    private View view;
    Button about;
    private ListView listView,listView2;
    private List<Map<String,String>> list;
    private String[] content = new String[]{"我发表的帖子","我的评论","我收藏的帖子","我顶过的帖子"};
    private int[] number = new int[]{10,22,14,41};
    private int[] image = new int[]{R.drawable.pencil,R.drawable.comment,R.drawable.star,R.drawable.agree};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        view = inflater.inflate(R.layout.me,null);
        setListView1();
        setListView2();
        setAbout();
        return view;
    }

    private void setAbout() {
        about = (Button) view.findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAboutPage = new Intent(getActivity(),OurAboutPage.class);
                startActivity(toAboutPage);
            }
        });
    }

    private void setListView2() {
        listView2 = (ListView) view.findViewById(R.id.listview2);
        String[] content = new String[]{"我的分享","黑名单"};
        int[] image = new int[]{R.drawable.share,R.drawable.blacklist};
        List<Map<String,String>> list = new ArrayList<>();
        for (int i=0; i<content.length; i++){
            Map<String,String> map = new HashMap<>();
            map.put("image",String.valueOf(image[i]));
            map.put("content",content[i]);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),list,R.layout.me_listview,
                new String[]{"image","content","number"},
                new int[]{R.id.image,R.id.content,R.id.number});
        listView2.setAdapter(adapter);
    }

    private void setListView1() {
        listView = (ListView) view.findViewById(R.id.listview);
        list = new ArrayList<>();
        for (int i=0; i<content.length; i++){
            Map<String,String> map = new HashMap<>();
            map.put("image",String.valueOf(image[i]));
            map.put("content",content[i]);
            map.put("number",String.valueOf(number[i]));
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),list,R.layout.me_listview,
                new String[]{"image","content","number"},
                new int[]{R.id.image,R.id.content,R.id.number});
        listView.setAdapter(adapter);
    }
}
