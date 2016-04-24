package com.example.marcus.knowYou.TravelFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.marcus.knowYou.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;


/**
 * Created by marcus on 16/4/17.
 */
public class Suggest extends Fragment implements ViewPager.OnPageChangeListener{
    private ViewPager viewPager;
    //在第一个位置和最后一个位置分别添加最后一张和第一张图片,用于实现循环滑动
    private int[] imagesId = new int[]{R.drawable.scene1,R.drawable.scene2,
            R.drawable.scene3,R.drawable.scene4};
    private String[] imagesIdNames = new String[]{"image1","image2","image3","image4","image5"};
    private ArrayList<View> viewPagerList;
    private View view;
    private LayoutInflater inflater;
    private CircleIndicator indicator;

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
        indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        viewPagerList = new ArrayList<>();
        for (int i=0; i<imagesId.length; i++){
            View imageView = inflater.inflate(R.layout.suggest_viewpager_views,null);
            ImageView image = (ImageView) imageView.findViewById(R.id.image);
            image.setImageResource(imagesId[i]);
            viewPagerList.add(imageView);
        }
        viewPager.setAdapter(new MyPagerAdapter(viewPagerList));
        viewPager.setOnPageChangeListener(this);
        indicator.setViewPager(viewPager);
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

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageSelected(int position) {

    }

}
