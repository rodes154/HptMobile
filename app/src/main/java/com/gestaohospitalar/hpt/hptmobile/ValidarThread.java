package com.gestaohospitalar.hpt.hptmobile;

import android.os.AsyncTask;

/**
 * Created by rodrigo on 29/05/17.
 */

public class ValidarThread extends AsyncTask <String[], Boolean ,Boolean> {

    @Override
    protected Boolean doInBackground(String[]... params) {

        ValidarCredenciais validarCredenciais = new ValidarCredenciais();


        System.out.println(params[0][0]+"   "+params[0][1]);
        if(validarCredenciais.validar(params[0][0],params[0][1])){
            return true;
        }else{
            System.out.println("Senha incorreta");
            return false;
        }
    }
}
