package com.gestaohospitalar.hpt.hptmobile;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rodrigo on 30/05/17.
 */

public class ConsultarVersoes extends AsyncTask<Void, Void ,Map<Integer, List<String>>>{

    @Override
    protected Map<Integer, List<String>> doInBackground(Void... params) {

        ConexaoWebService conexao = new ConexaoWebService();
        conexao.metodo("consultarPacotes");
        conexao.classe("ValidarLogin");
        Object resposta = conexao.realizarConexao();
        Map<Integer,List<String>> mapPacotes = new HashMap<Integer,List<String>>();
        try{
            mapPacotes = (Map<Integer, List<String>>) resposta;
        }catch(Exception e){
            e.printStackTrace();
        }



        return mapPacotes;
    }
}
