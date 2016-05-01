package com.example.marcus.knowYou;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;

/**
 * Created by marcus on 16/5/1.
 */
public class OurAboutPage extends Activity {
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.scene1)
                .addGroup("Connect with us")
                .addEmail("linfaimom@gmail.com")
                .addWebsite("http://www.godxiang.top")
                .addTwitter("LinFXMD")
                .addGitHub("linfaimom")
                .create();
        setContentView(view);
    }
}
