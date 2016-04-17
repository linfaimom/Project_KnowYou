package com.example.marcus.knowYou.NaviFragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.example.marcus.knowYou.DiscoverFragments.Clothes;
import com.example.marcus.knowYou.DiscoverFragments.Foods;
import com.example.marcus.knowYou.DiscoverFragments.Hotels;
import com.example.marcus.knowYou.DiscoverFragments.Transports;
import com.example.marcus.knowYou.R;
import com.example.marcus.knowYou.TravelFragments.SelfDecide;
import com.example.marcus.knowYou.TravelFragments.Suggest;

import java.util.ArrayList;

/**
 * Created by marcus on 16/4/8.
 */
public class Travel extends Fragment {
    private ArrayList<Fragment> fragments;
    private String[] tabNames = new String[]{"热门推荐","想去哪玩"};
    private PagerSlidingTabStrip tabs;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.travel,null);
        addFragments();
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getChildFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        tabs.setViewPager(viewPager);
        //needs to be done
        return view;
    }

    private void addFragments() {
        fragments = new ArrayList<>();
        Suggest suggest = new Suggest();
        SelfDecide selfDecide = new SelfDecide();
        fragments.add(suggest);
        fragments.add(selfDecide);
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
