package com.example.marcus.knowYou.NaviFragments;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marcus.knowYou.R;
import com.example.marcus.knowYou.DiscoverFragments.Clothes;
import com.example.marcus.knowYou.DiscoverFragments.Foods;
import com.example.marcus.knowYou.DiscoverFragments.Hotels;
import com.example.marcus.knowYou.DiscoverFragments.Transports;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

/**
 * Created by marcus on 16/4/8.
 */
public class Discover extends Fragment {
    private ArrayList<Fragment> fragments;
    private String[] tabNames = new String[]{"最美穿撘","必吃美食","住得起所","畅所欲行"};
    private SlidingTabLayout tabs;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discover_viewpager,null);
        addFragments();
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        tabs = (SlidingTabLayout) view.findViewById(R.id.tabs);
        tabs.setViewPager(viewPager);
        return view;
    }

    private void addFragments() {
        fragments = new ArrayList<>();
        Clothes clothes = new Clothes();
        Foods foods = new Foods();
        Hotels hotels = new Hotels();
        Transports transports = new Transports();
        fragments.add(clothes);
        fragments.add(foods);
        fragments.add(hotels);
        fragments.add(transports);
    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> fragments;

        public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabNames[position];
        }


    }
}
