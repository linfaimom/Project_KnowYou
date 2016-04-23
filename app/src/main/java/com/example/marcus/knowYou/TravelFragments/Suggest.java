package com.example.marcus.knowYou.TravelFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.marcus.knowYou.R;

import java.util.ArrayList;


/**
 * Created by marcus on 16/4/17.
 */
public class Suggest extends Fragment {
    private ViewPager viewPager;
    private int[] imagesId = new int[]{R.drawable.scene1,R.drawable.scene2,R.drawable.scene3,R.drawable.scene4};
    private String[] imagesIdNames = new String[]{"image1","image2","image3","image4","image5"};
    private ArrayList<View> viewPagerList;
    private View view;
    private LayoutInflater inflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        view = inflater.inflate(R.layout.suggest,null);
        setViewPager();
        return view;
    }

    private void setViewPager() {
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPagerList = new ArrayList<>();
        for (int i=0; i<imagesId.length; i++){
            View imageView = inflater.inflate(R.layout.suggest_viewpager_views,null);
            ImageView image = (ImageView) imageView.findViewById(R.id.image);
            image.setImageResource(imagesId[i]);
            viewPagerList.add(imageView);
        }
        viewPager.setAdapter(new MyPagerAdapter(viewPagerList));
    }

    //ViewPager适配器
    class MyPagerAdapter extends PagerAdapter {
        private ArrayList<View> viewPagerList;


        public MyPagerAdapter(ArrayList<View> viewPagerList){
            this.viewPagerList = viewPagerList;
        }

        @Override
        public int getCount() {
            return viewPagerList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewPagerList.get(position));
            return viewPagerList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewPagerList.get(position));
        }
    }

}
