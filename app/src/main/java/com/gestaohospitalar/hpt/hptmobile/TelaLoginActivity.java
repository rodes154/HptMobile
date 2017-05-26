package com.gestaohospitalar.hpt.hptmobile;

import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaLoginActivity extends AppCompatActivity {

    EditText usernameEdittext;
    EditText passwordEdittext;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        usernameEdittext = (EditText) findViewById(R.id.usernameEdittext);
        passwordEdittext = (EditText) findViewById(R.id.passwordEdittext);
        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        loginButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        loginButton.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP);
                        loginButton.invalidate();
                        break;
                    case MotionEvent.ACTION_UP:
                        loginButton.getBackground().clearColorFilter();
                        loginButton.invalidate();
                        break;
                }
                return false;
            }
        });



    }
}
