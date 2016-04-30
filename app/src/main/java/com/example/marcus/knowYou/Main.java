package com.example.marcus.knowYou;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.marcus.knowYou.NaviFragments.Travel;
import com.example.marcus.knowYou.NaviFragments.Discover;
import com.example.marcus.knowYou.NaviFragments.Community;
import com.example.marcus.knowYou.NaviFragments.Me;

/**
 * Created by marcus on 16/4/7.
 */

public class Main extends FragmentActivity {
    //Fragments
    private Class[] fragments = new Class[]{Travel.class, Discover.class, null, Community.class, Me.class};
    //labels
    private String[] labels = new String[]{"旅行", "发现", "null", "社区", "我"};
    //label_ids
    private String[] label_ids = new String[]{"travel", "gps", "null", "messages", "me"};
    //pictures
    private int[] pictures = new int[]{R.drawable.travel_change, R.drawable.discover_change,
            0, R.drawable.community_change, R.drawable.me_change};
    //TabHost
    private FragmentTabHost tabHost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_fragmenttabhost_layout);
        //initView
        initView();
    }

    private void initView() {
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        //去掉分割线
        tabHost.getTabWidget().setDividerDrawable(null);

        //get fragments' length
        int length = fragments.length;
        //set tab name for every fragment
        for (int i = 0; i < length; i++) {
            tabHost.addTab(tabHost.newTabSpec(label_ids[i]).setIndicator(getTabView(i)), fragments[i], null);
        }

        //对第三个标签进行单独的设置,作为一个弹窗使用
        tabHost.getTabWidget().getChildAt(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageView) v.findViewById(R.id.button)).setImageResource(R.drawable.dismiss);
                showPopWindow(v);
            }

            private void showPopWindow(View v) {
                final View outer = v;
                DisplayMetrics dm = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(dm);
                final int HEIGHT = dm.heightPixels / 4;
                View view = LayoutInflater.from(Main.this).inflate(R.layout.bottom_fragmenttabhost_showpopupwindow, null);
                PopupWindow popWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, HEIGHT);
                popWindow.setTouchable(true);
                popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        ((ImageView)outer.findViewById(R.id.button)).setImageResource(R.drawable.show);
                    }
                });
                //需设置下面两个参数,点击外部才能让popUpWindow自动消失
                popWindow.setFocusable(true);
                popWindow.setBackgroundDrawable(new BitmapDrawable());

                popWindow.showAsDropDown(v);
            }
        });


    }

    //返还自定义样式
    private View getTabView(int i) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = null;
        //单独为其设置按钮样式
        if (i == 2) {
            view = inflater.inflate(R.layout.bottom_fragmenttabhost_showpopupwindow_button, null);
            final ImageView button = (ImageView) view.findViewById(R.id.button);
            button.setImageResource(R.drawable.show);
            return view;
        } else {
            view = inflater.inflate(R.layout.bottom_fragmenttabhost_tabview, null);
            ((TextView) view.findViewById(R.id.tabname)).setText(labels[i]);
            ((ImageView) view.findViewById(R.id.tabpicture)).setImageResource(pictures[i]);
            return view;
        }
    }

}
