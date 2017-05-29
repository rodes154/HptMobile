package com.gestaohospitalar.hpt.hptmobile;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomBar;
    private TextView toolBarTitle;
    private Button buttonConfig1;

    //Layouts
    RelativeLayout geralLayout,aba2Layout,aba3Layout,aba4Layout,aba5Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Barras de ferramentas
        bottomBar = (BottomNavigationView)(findViewById(R.id.navigationBar));
        toolBarTitle = (TextView)(findViewById(R.id.toolbarTitle));




        //Layouts
        geralLayout = (RelativeLayout) (findViewById(R.id.abaGeralLayout));
        aba2Layout = (RelativeLayout)(findViewById(R.id.aba2Layout));
        aba3Layout = (RelativeLayout)(findViewById(R.id.aba3Layout));
        aba4Layout = (RelativeLayout)(findViewById(R.id.aba4Layout));
        aba5Layout = (RelativeLayout)(findViewById(R.id.aba5Layout));


        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.geral:
                        trocarLayout(1);
                        return true;
                    case R.id.aba2:
                        trocarLayout(2);
                        return true;
                    case R.id.aba3:
                        trocarLayout(3);
                        return true;
                    case R.id.aba4:
                        trocarLayout(4);
                        return true;
                    case R.id.aba5:
                        trocarLayout(5);
                        return true;
                    default:
                        return false;
                }
            }
        });

    }

    private void trocarLayout(int aba){

        geralLayout.setVisibility(View.INVISIBLE);
        aba2Layout.setVisibility(View.INVISIBLE);
        aba3Layout.setVisibility(View.INVISIBLE);
        aba4Layout.setVisibility(View.INVISIBLE);
        aba5Layout.setVisibility(View.INVISIBLE);

        switch (aba){
            case 1:
                geralLayout.setVisibility(View.VISIBLE);
                break;
            case 2:
                aba2Layout.setVisibility(View.VISIBLE);
                break;
            case 3:
                aba3Layout.setVisibility(View.VISIBLE);
                break;
            case 4:
                aba4Layout.setVisibility(View.VISIBLE);
                break;
            case 5:
                aba5Layout.setVisibility(View.VISIBLE);
                break;
        }

    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.configuration_menu, popup.getMenu());
        popup.show();
    }

    private void abrirSobreActivity(){
        //Intent sobreIntent = new Intent(this, SobreActivity.class);
       // startActivity(sobreIntent);
    }

}