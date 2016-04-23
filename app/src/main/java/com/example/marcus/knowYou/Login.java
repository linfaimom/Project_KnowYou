package com.example.marcus.knowYou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Login extends Activity implements View.OnClickListener{

    private Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login :
                Intent login = new Intent(Login.this,Main.class);
                startActivity(login);
                break;

            case R.id.register :
                Intent register = new Intent(Login.this,Register.class);
                startActivity(register);
                break;
        }
    }
}
