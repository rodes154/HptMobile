package com.gestaohospitalar.hpt.hptmobile;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaLoginActivity extends AppCompatActivity {

    EditText usernameEdittext;
    EditText passwordEdittext;
    Button loginButton;
    TextView respostaCredenciaisTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        usernameEdittext = (EditText) findViewById(R.id.usernameEdittext);
        passwordEdittext = (EditText) findViewById(R.id.passwordEdittext);
        loginButton = (Button) findViewById(R.id.loginButton);
        respostaCredenciaisTextView = (TextView) findViewById(R.id.respostaCredenciaisTextView);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarLogin(usernameEdittext.getText().toString(),passwordEdittext.getText().toString());
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

    private void realizarLogin(String user, String pass){

        ValidarCredenciais v1 = new ValidarCredenciais();
        if(v1.validar(user,pass)){
            respostaCredenciaisTextView.setText("Login Realizado");
        }else{
            respostaCredenciaisTextView.setText("Login ou senha incorretos.");
        }

    }
}
