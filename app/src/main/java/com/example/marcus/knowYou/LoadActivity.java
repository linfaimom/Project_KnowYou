package com.example.marcus.knowYou;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by marcus on 16/4/16.
 */
public class LoadActivity extends Activity {
    private Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.RGBA_8888);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
        setContentView(R.layout.load);
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                login.setVisibility(View.VISIBLE);
                register.setVisibility(View.VISIBLE);
                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(LoadActivity.this,Login.class);
                        startActivity(intent);
                    }
                });
                register.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(LoadActivity.this,Register.class);
                        startActivity(intent);
                    }
                });
            }
        },1500);
    }
}
