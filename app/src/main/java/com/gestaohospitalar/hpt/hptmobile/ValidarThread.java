package com.gestaohospitalar.hpt.hptmobile;

import android.os.AsyncTask;

/**
 * Created by rodrigo on 29/05/17.
 */

public class ValidarThread extends AsyncTask <String[], Boolean ,Boolean> {

    @Override
    protected Boolean doInBackground(String[]... params) {

        ConexaoWebService conexaoWebService = new ConexaoWebService();

        conexaoWebService.metodo("validarLogin");
        conexaoWebService.classe("ValidarLogin");
        conexaoWebService.adicionarAtributo("user",params[0][0]);
        conexaoWebService.adicionarAtributo("pass",params[0][1]);
        Object resposta = conexaoWebService.realizarConexao();

        if(resposta.toString().equals("true")){
            System.out.println("logged in");
            return true;
        }else{
            return false;
        }
    }
}
