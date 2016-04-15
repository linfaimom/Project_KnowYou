package com.example.marcus.knowYou.NaviFragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.marcus.knowYou.R;

/**
 * Created by marcus on 16/4/8.
 */
public class Travel extends Fragment {
    private ListView listView;
    private ListAdapter adapter;
    private String[] names = new String[]{"Lin","You","Liu","Li"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.travel,null);
        listView = (ListView) view.findViewById(R.id.list);
        showListView();
        listViewSelected();
        return view;
    }

    private void listViewSelected() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Travel.this.getActivity(), "you click position " + position, Toast.LENGTH_SHORT).
                        show();
            }
        });
    }


    private void showListView() {
        adapter = new ArrayAdapter<>(this.getActivity(),android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);
    }
}
