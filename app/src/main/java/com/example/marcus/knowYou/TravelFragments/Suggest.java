package com.example.marcus.knowYou.TravelFragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marcus.knowYou.MonthClasses.HonKong;
import com.example.marcus.knowYou.R;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Types.BoomType;
import com.nightonke.boommenu.Types.ButtonType;
import com.nightonke.boommenu.Types.PlaceType;
import com.nightonke.boommenu.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
    private ArrayList<View> viewPagerList;
    private ArrayList<Map<String,Integer>> gridViewList;
    private CircleIndicator indicator;
    private String[][] infos = new String[][]{
            {"God翔","是否是打发斯蒂芬爱的方式啊所发生的是否是否的所发生的发生的发生的防守打法是否撒发生的发生的防守打法是的发生的发的发生的封"},
            {"God翔","是否是打发斯蒂芬爱的方式啊所发生的是否是否的所发生的发生的发生的防守打法是否撒发生的发生的防守打法是的发生的发的发生的封"},
            {"God翔","是否是打发斯蒂芬爱的方式啊所发生的是否是否的所发生的发生的发生的防守打法是否撒发生的发生的防守打法是的发生的发的发生的封"},
            {"God翔","是否是打发斯蒂芬爱的方式啊所发生的是否是否的所发生的发生的发生的防守打法是否撒发生的发生的防守打法是的发生的发的发生的封"},
            {"God翔","是否是打发斯蒂芬爱的方式啊所发生的是否是否的所发生的发生的发生的防守打法是否撒发生的发生的防守打法是的发生的发的发生的封"},
            {"God翔","是否是打发斯蒂芬爱的方式啊所发生的是否是否的所发生的发生的发生的防守打法是否撒发生的发生的防守打法是的发生的发的发生的封"},
            {"God翔","是否是打发斯蒂芬爱的方式啊所发生的是否是否的所发生的发生的发生的防守打法是否撒发生的发生的防守打法是的发生的发的发生的封"},
            {"God翔","是否是打发斯蒂芬爱的方式啊所发生的是否是否的所发生的发生的发生的防守打法是否撒发生的发生的防守打法是的发生的发的发生的封"},
            {"God翔","是否是打发斯蒂芬爱的方式啊所发生的是否是否的所发生的发生的发生的防守打法是否撒发生的发生的防守打法是的发生的发的发生的封"},
            {"God翔","是否是打发斯蒂芬爱的方式啊所发生的是否是否的所发生的发生的发生的防守打法是否撒发生的发生的防守打法是的发生的发的发生的封"}
    };
    private static String[] Colors = {
            "#F44336",
            "#E91E63",
            "#9C27B0",
            "#2196F3",
            "#03A9F4",
            "#00BCD4",
            "#009688",
            "#4CAF50",
            "#8BC34A",
            "#CDDC39",
            "#FFEB3B",
            "#FFC107",
            "#FF9800",
            "#FF5722",
            "#795548",
            "#9E9E9E",
            "#607D8B"};
    //to be added.
    private Class[] monthClasses = new Class[]{HonKong.class,HonKong.class,HonKong.class,HonKong.class};

    public static int GetRandomColor() {
        Random random = new Random();
        int p = random.nextInt(Colors.length);
        return Color.parseColor(Colors[p]);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        view = inflater.inflate(R.layout.travel_suggest,null);
        setViewPager();
        setGridView();
        setListView();
        return view;
    }

    private void setListView() {
        shareListView = (ListView) view.findViewById(R.id.listview);
        shareListView.setAdapter(new MyBaseAdapter());
    }

    private void setGridView() {
        monthlyGridView = (GridView) view.findViewById(R.id.gridview);
        gridViewList = new ArrayList<>();
        for (int i=0; i<imagesId.length; i++){
            Map<String,Integer> map = new HashMap<>();
            map.put("image",imagesId[i]);
            gridViewList.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),gridViewList,R.layout.travel_suggest_gridview,
                new String[]{"image"},new int[]{R.id.image});
        monthlyGridView.setAdapter(adapter);
        //设置点击事项
        monthlyGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),monthClasses[position]);
                startActivity(intent);
            }
        });
    }

    private void setViewPager() {
        themeViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        viewPagerList = new ArrayList<>();
        for (int i=0; i<imagesId.length; i++){
            View imageView = inflater.inflate(R.layout.travel_suggest_viewpager_views,null);
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

    //ListView适配器
    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return infos.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, final ViewGroup parent) {
            final ViewHolder viewHolder;

            if (convertView == null){
                convertView = inflater.inflate(R.layout.travel_suggest_share_listview,null);
                viewHolder = new ViewHolder();
                viewHolder.userPic = (ImageView) convertView.findViewById(R.id.user_pic);
                viewHolder.nickName = (TextView) convertView.findViewById(R.id.nickname);
                viewHolder.content = (TextView) convertView.findViewById(R.id.content);
                viewHolder.image1 = (ImageView) convertView.findViewById(R.id.image1);
                viewHolder.image2 = (ImageView) convertView.findViewById(R.id.image2);
                viewHolder.time = (TextView) convertView.findViewById(R.id.time);
                viewHolder.menu = (BoomMenuButton) convertView.findViewById(R.id.boom_circle);
                convertView.setTag(viewHolder);
            }
            else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.userPic.setImageResource(R.drawable.godxiang);
            viewHolder.nickName.setText(infos[position][0]);
            viewHolder.content.setText(infos[position][1]);
            viewHolder.image1.setImageResource(R.drawable.girl);
            //image2

            viewHolder.time.setText("1小时前");

            //set BoomMenu
            final Drawable[] circleSubButtonDrawables = new Drawable[3];
            int[] drawablesResource = new int[]{
                    R.drawable.mark,
                    R.drawable.refresh,
                    R.drawable.copy
            };
            for (int i = 0; i < 3; i++)
                circleSubButtonDrawables[i]
                        = ContextCompat.getDrawable(parent.getContext(), drawablesResource[i]);

            final int[][] subButtonColors = new int[3][2];
            for (int i = 0; i < 3; i++) {
                subButtonColors[i][1] = GetRandomColor();
                subButtonColors[i][0] = Util.getInstance().getPressedColor(subButtonColors[i][1]);
            }

            final String[] circleSubButtonTexts = new String[]{
                    "No. " + position,
                    "No. " + position,
                    "No. " + position};
            viewHolder.menu.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Now with Builder, you can init BMB more convenient
                    new BoomMenuButton.Builder()
                            .subButtons(circleSubButtonDrawables, subButtonColors, circleSubButtonTexts)
                            .button(ButtonType.CIRCLE)
                            .boom(BoomType.PARABOLA)
                            .place(PlaceType.CIRCLE_3_1)
                            .subButtonsShadow(Util.getInstance().dp2px(2), Util.getInstance().dp2px(2))
                            .onSubButtonClick(new BoomMenuButton.OnSubButtonClickListener() {
                                @Override
                                public void onClick(int buttonIndex) {
                                    Toast.makeText(
                                            parent.getContext(),
                                            "On click " + circleSubButtonTexts[buttonIndex],
                                            Toast.LENGTH_SHORT).show();
                                }
                            })
                            .init(viewHolder.menu);
                }
            }, 1);
            return convertView;
        }

        class ViewHolder {
            ImageView userPic;
            TextView nickName;
            TextView content;
            ImageView image1;
            ImageView image2;
            TextView time;
            BoomMenuButton menu;
        }

    }

}
