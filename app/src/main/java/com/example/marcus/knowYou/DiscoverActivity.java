package com.example.marcus.knowYou;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.marcus.knowYou.DiscoverFragments.KnowYou;
import com.example.marcus.knowYou.DiscoverFragments.StoreMessageShow;
import com.flyco.tablayout.SegmentTabLayout;

import java.util.ArrayList;

/**
 * Created by marcus on 16/5/6.
 */
public class DiscoverActivity extends FragmentActivity {
    private SegmentTabLayout tabs;
    private ImageButton button;
    private ArrayList<Fragment> fragments;
    private String[] tabNames = new String[]{"懂你","喧哗"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discover);
        addFragments();
        setTabs();
        // set back icon pressed event.
        button = (ImageButton) findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addFragments() {
        fragments = new ArrayList<>();
        KnowYou knowYou = new KnowYou();
        StoreMessageShow storeMessageShow = new StoreMessageShow();
        fragments.add(knowYou);
        fragments.add(storeMessageShow);
    }

    private void setTabs() {
        tabs = (SegmentTabLayout) findViewById(R.id.tabs);
        tabs.setTabData(tabNames,this,R.id.content,fragments);
    }
}
