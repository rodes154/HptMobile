package com.gestaohospitalar.hpt.hptmobile;

import android.content.Intent;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rodrigo on 30/05/17.
 */

public class ConsultarVersoes extends AsyncTask<Void, Void ,List<Object>>{

    @Override
    protected List<Object> doInBackground(Void... params) {

        ConexaoWebService conexao = new ConexaoWebService();
        conexao.metodo("consultarPacotes");
        conexao.classe("ValidarLogin");
        String jsonData = String.valueOf(conexao.realizarConexao());

        Gson gson = new Gson();
        Map<Integer,List<String>> mapObject = gson.fromJson(jsonData,new TypeToken<Map<Integer,List<String>>>(){}.getType());

        List<Integer> keys = new ArrayList<>();
        List<String> nomes = new ArrayList<>();
        List<String> logs = new ArrayList<>();
        List<String> data = new ArrayList<>();


        for(int i=0;i<=mapObject.size();i++){
            if(mapObject.keySet().contains(i)){
                keys.add(i);
                List<String> tempList = mapObject.get(i);
                nomes.add(tempList.get(0));
                logs.add(tempList.get(1));
                data.add(tempList.get(2));
            }
        }

        List<Object> lista = new ArrayList<>();
        lista.add(keys);
        lista.add(nomes);
        lista.add(logs);
        lista.add(data);

        return lista;
    }
}
