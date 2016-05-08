package com.example.marcus.knowYou;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Login extends Activity implements View.OnClickListener{
    private ProgressDialog dialog;
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
        dialog = ProgressDialog.show(this,null,"登录中,请稍候....",true,false);
        new LoadingThread(this).start();
    }

    private class LoadingThread extends Thread {
        private Login loginActivity;

        public LoadingThread(Login login){
            loginActivity = login;
        }

        @Override
        public void run() {
            Message message = new Message();
            message.what = 0x123;
            loginActivity.handler.sendMessage(message);
        }
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123){
                Intent login = new Intent(Login.this,MainActivity.class);
                startActivity(login);
                Login.this.finish();
                if (dialog.isShowing()){
                    dialog.dismiss();
                }
            }
        }
    };
}
