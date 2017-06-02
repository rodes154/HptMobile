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
import android.text.method.ScrollingMovementMethod;
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

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import pl.droidsonroids.gif.GifImageView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomBar;
    private Button configButton;
    private ListView aba5ListView;
    private TextView aba5LogTextView;
    private GifImageView aba5Loading;

    //Layouts
    RelativeLayout geralLayout,aba2Layout,aba3Layout,aba4Layout,aba5ListLayout,aba5TextLayout;
    FrameLayout aba5Layout;

    //Listas
    List<Object> listaGeral;

    //Variaveis
    Boolean versoesCarregadas = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Componentes em geral
        aba5ListView = (ListView) (findViewById(R.id.aba5ListView));
        aba5LogTextView = (TextView) (findViewById(R.id.aba5LogTextView));
        aba5Loading = (GifImageView) (findViewById(R.id.aba5LoadingImageView));

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
        aba5TextLayout = (RelativeLayout) findViewById(R.id.aba5TextLayout);

        configButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(v);
            }
        });

        aba5ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                aba5LogTextView.setText(((ArrayList<String>) (listaGeral.get(2))).get((int)id));

                aba5ListLayout.setVisibility(View.INVISIBLE);
                aba5TextLayout.setVisibility(View.VISIBLE);

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

        aba5LogTextView.setMovementMethod(new ScrollingMovementMethod());
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
                executarConsultarVersoes();
                break;
        }

    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.configuration_menu, popup.getMenu());
        popup.show();
    }

    public void executarConsultarVersoes(){
        aba5Loading.setVisibility(View.VISIBLE);

        aba5TextLayout.setVisibility(View.INVISIBLE);

        aba5ListLayout.setVisibility(View.VISIBLE);
        aba5Layout.setVisibility(View.VISIBLE);

        if(!versoesCarregadas){
            ConsultarVersoes consultar = new ConsultarVersoes(this);
            consultar.execute();
        }else{
            aba5Loading.setVisibility(View.INVISIBLE);
        }
    }

    public void carregarAba5(List<Object> objects){

        listaGeral = new ArrayList<>();

        listaGeral = objects;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, (ArrayList<String>)listaGeral.get(1));
        aba5ListView.setAdapter(adapter);
        System.out.println(adapter.getCount());
        if(adapter.getCount()>1){
            versoesCarregadas = true;
        }
        aba5Loading.setVisibility(View.INVISIBLE);

    }

}