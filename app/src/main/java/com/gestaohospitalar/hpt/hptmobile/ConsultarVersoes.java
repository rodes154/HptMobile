package com.gestaohospitalar.hpt.hptmobile;

import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by rodrigo on 30/05/17.
 */

public class ConsultarVersoes extends AsyncTask<Void, Void ,String[]>{

    @Override
    protected String[] doInBackground(Void... params) {

        ConexaoWebService conexao = new ConexaoWebService();
        conexao.metodo("consultarVersoes");
        conexao.classe("ValidarLogin");
        Object resposta = conexao.realizarConexao();

        return (String[]) resposta;
    }
}
