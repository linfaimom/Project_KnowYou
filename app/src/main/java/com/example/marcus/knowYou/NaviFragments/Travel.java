package com.example.marcus.knowYou.NaviFragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.marcus.knowYou.R;
import com.example.marcus.knowYou.Search;
import com.example.marcus.knowYou.TravelFragments.TravelFriends;
import com.example.marcus.knowYou.TravelFragments.Suggest;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

/**
 * Created by marcus on 16/4/8.
 */
public class Travel extends Fragment {
    private View view;
    private ImageButton search, message;
    private ArrayList<Fragment> fragments;
    private String[] tabNames = new String[]{"推荐", "驴友"};
    private SlidingTabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.travel, null);
        addFragments();
        setImageButtons();
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(),fragments));
        tabLayout = (SlidingTabLayout) view.findViewById(R.id.tabs);
        tabLayout.setViewPager(viewPager);
        return view;
    }

    private void setImageButtons() {
        //travel_search event
        search = (ImageButton) view.findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Search.class);
                startActivity(intent);
            }
        });
    }


    private void addFragments() {
        fragments = new ArrayList<>();
        Suggest suggest = new Suggest();
        TravelFriends travelFriends = new TravelFriends();
        fragments.add(suggest);
        fragments.add(travelFriends);
    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> list;

        public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabNames[position];
        }

    }
}