package com.example.marcus.knowYou;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by marcus on 16/4/16.
 */
public class LoadActivity extends Activity {
    private Button login,register;
    private TextView text,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.RGBA_8888);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
        setContentView(R.layout.start);
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        text = (TextView) findViewById(R.id.text);
        text2 = (TextView) findViewById(R.id.text2);
        //set text with diy style
        Typeface typeface = Typeface.createFromAsset(this.getAssets(),"fonts/custom.ttf");
        text.setTypeface(typeface);
        text2.setTypeface(typeface);
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
                        Intent intent = new Intent(LoadActivity.this, Register.class);
                        startActivity(intent);
                    }
                });
            }
        },2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                text.setVisibility(View.VISIBLE);
                text2.setVisibility(View.VISIBLE);
            }
        },1500);
    }
}
