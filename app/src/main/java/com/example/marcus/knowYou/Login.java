package com.example.marcus.knowYou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Login extends Activity implements View.OnClickListener{

    private Button login,look;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);
        login = (Button) findViewById(R.id.login);
        look = (Button) findViewById(R.id.look);
        login.setOnClickListener(this);
        look.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent login = new Intent(Login.this,MainActivity.class);
        startActivity(login);
    }
}
