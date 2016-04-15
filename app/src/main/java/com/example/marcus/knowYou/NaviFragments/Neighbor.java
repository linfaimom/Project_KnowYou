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

import com.astuetz.PagerSlidingTabStrip;
import com.example.marcus.knowYou.R;
import com.example.marcus.knowYou.ViewPagerFragment.Clothes;
import com.example.marcus.knowYou.ViewPagerFragment.Foods;
import com.example.marcus.knowYou.ViewPagerFragment.Hotels;
import com.example.marcus.knowYou.ViewPagerFragment.Transports;

import java.util.ArrayList;

/**
 * Created by marcus on 16/4/8.
 */
public class Neighbor extends Fragment {
    private ArrayList<Fragment> fragments;
    private String[] tabNames = new String[]{"最美穿撘","必吃美食","住得起所","畅所欲行"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.neighbor_viewpager,null);
        addFragments();
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        tabs.setViewPager(viewPager);
        tabs.setIndicatorColor(Color.RED);
        tabs.setIndicatorHeight(5);
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
