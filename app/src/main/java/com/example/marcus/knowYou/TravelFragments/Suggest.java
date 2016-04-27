package com.example.marcus.knowYou.TravelFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.marcus.knowYou.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import me.relex.circleindicator.CircleIndicator;


/**
 * Created by marcus on 16/4/17.
 */
public class Suggest extends Fragment {
    private View view;
    private LayoutInflater inflater;
    private ViewPager themeViewPager;
    private GridView monthlyGridView;
    private ListView shareListView;
    private int[] imagesId = new int[]{R.drawable.scene1,R.drawable.scene2,
            R.drawable.scene3,R.drawable.scene4};
    private String[] imagesIdNames = new String[]{"image1","image2","image3","image4"};
    private ArrayList<View> viewPagerList;
    private ArrayList<Map<String,Integer>> gridViewList;
    private ArrayList<Map<String,String>> listViewItems;
    private CircleIndicator indicator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        view = inflater.inflate(R.layout.suggest,null);
        setViewPager();
        setGridView();
        setListView();
        return view;
    }

    private void setListView() {
        shareListView = (ListView) view.findViewById(R.id.listview);
        String[][] infos = new String[][]{
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
        listViewItems = new ArrayList<>();
        for (int i=0; i<infos.length; i++){
            Map<String,String> map = new HashMap<>();
            map.put("pic",String.valueOf(R.drawable.girl));
            map.put("title",infos[i][0]);
            map.put("info",infos[i][1]);
            map.put("star",String.valueOf(R.drawable.clothes));
            map.put("type","浙师大北门");
            listViewItems.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),listViewItems,R.layout.foods_listview,
                new String[]{"pic","title","info","star","type"},
                new int[]{R.id.pic,R.id.title,R.id.info,R.id.star,R.id.type});
        shareListView.setAdapter(adapter);
    }

    private void setGridView() {
        monthlyGridView = (GridView) view.findViewById(R.id.gridview);
        gridViewList = new ArrayList<>();
        for (int i=0; i<imagesId.length; i++){
            Map<String,Integer> map = new HashMap<>();
            map.put("image",imagesId[i]);
            gridViewList.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),gridViewList,R.layout.suggest_grid_view,
                new String[]{"image"},new int[]{R.id.image});
        monthlyGridView.setAdapter(adapter);
    }

    private void setViewPager() {
        themeViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        viewPagerList = new ArrayList<>();
        for (int i=0; i<imagesId.length; i++){
            View imageView = inflater.inflate(R.layout.suggest_viewpager_views,null);
            ImageView image = (ImageView) imageView.findViewById(R.id.image);
            image.setImageResource(imagesId[i]);
            viewPagerList.add(imageView);
        }
        themeViewPager.setAdapter(new MyPagerAdapter(viewPagerList));
        //设置监听器,needs to be done
        themeViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        indicator.setViewPager(themeViewPager);
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
