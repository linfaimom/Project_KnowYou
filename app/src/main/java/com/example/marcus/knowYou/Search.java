package com.example.marcus.knowYou;

import android.app.Activity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by marcus on 16/4/23.
 */
public class Search extends Activity {
    private AutoCompleteTextView autoText;
    private String[] cityNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_search);
        cityNames = getResources().getStringArray(R.array.Zhejiang);
        setText();
    }

    private void setText() {
        autoText = (AutoCompleteTextView) findViewById(R.id.autotext);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i=0; i<cityNames.length; i++){
            arrayList.add(cityNames[i]);
        }
        ArrayAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        autoText.setAdapter(adapter);
        //打开Activity自动聚焦这个textview,然后自动弹出键盘
        autoText.setFocusable(true);
        autoText.setFocusableInTouchMode(true);
        autoText.requestFocus();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                InputMethodManager manager = (InputMethodManager) autoText.getContext().getSystemService(INPUT_METHOD_SERVICE);
                manager.showSoftInput(autoText,0);
            }
        },400);
    }
}
