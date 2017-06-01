package com.gestaohospitalar.hpt.hptmobile;


import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomBar;
    private Button configButton;
    private ListView aba5ListView;

    //Layouts
    RelativeLayout geralLayout,aba2Layout,aba3Layout,aba4Layout,aba5ListLayout;
    FrameLayout aba5Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Componentes em geral
        aba5ListView = (ListView) (findViewById(R.id.aba5ListView));

        //Barras de ferramentas
        bottomBar = (BottomNavigationView)(findViewById(R.id.navigationBar));
        configButton = (Button) (findViewById(R.id.configButton));

        //Layouts
        geralLayout = (RelativeLayout) (findViewById(R.id.abaGeralLayout));
        aba2Layout = (RelativeLayout)(findViewById(R.id.aba2Layout));
        aba3Layout = (RelativeLayout)(findViewById(R.id.aba3Layout));
        aba4Layout = (RelativeLayout)(findViewById(R.id.aba4Layout));
        aba5Layout = (FrameLayout) (findViewById(R.id.aba5Layout));
        aba5ListLayout = (RelativeLayout) findViewById(R.id.aba5ListLayout);

        configButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });

        aba5ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch ((int)id){
                    case 1:
                        System.out.println("1");

                    case 2:
                        System.out.println("2");

                    case 3:
                        System.out.println("3");

                }
            }
        });



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
                carregarAba5();
                break;
        }

    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.configuration_menu, popup.getMenu());
        popup.show();
    }
    public void carregarAba5(){

        ConsultarVersoes consultar = new ConsultarVersoes();
        List<Object> listaGeral = new  ArrayList<>();
        List<String> listaVersoes = new ArrayList<>();
        try {
            listaGeral = consultar.execute().get();
            listaVersoes = (ArrayList<String>)listaGeral.get(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listaVersoes);
        aba5ListView.setAdapter(adapter);
        aba5Layout.setVisibility(View.VISIBLE);
        aba5ListLayout.setVisibility(View.VISIBLE);
    }

}