package com.example.marcus.knowYou;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by marcus on 16/4/19.
 */
public class TabEntries implements CustomTabEntity {
    private String title;
    private int selectIcon;
    private int unSelectIcon;

    public TabEntries(String title, int selectIcon, int unSelectIcon){
        this.title = title;
        this.selectIcon = selectIcon;
        this.unSelectIcon = unSelectIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectIcon;
    }
}
