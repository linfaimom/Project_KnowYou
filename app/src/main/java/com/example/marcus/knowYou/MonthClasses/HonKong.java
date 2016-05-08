package com.example.marcus.knowYou.MonthClasses;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.marcus.knowYou.R;

/**
 * Created by marcus on 16/5/7.
 */
public class HonKong extends Activity {
    private TextView title,content;
    private ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.honkong);
        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/custom.ttf");
        title.setText("香港维多利亚港");
        title.setTextSize(30);
        title.setTypeface(typeface);
        content.setText(R.string.introduce);
        content.setTextSize(18);
    }
}
