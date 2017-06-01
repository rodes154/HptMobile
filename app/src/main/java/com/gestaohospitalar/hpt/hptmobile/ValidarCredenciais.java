package com.gestaohospitalar.hpt.hptmobile;

import android.os.AsyncTask;

import java.lang.ref.WeakReference;

/**
 * Created by rodrigo on 29/05/17.
 */

public class ValidarCredenciais extends AsyncTask <String[], Boolean ,Boolean> {

    WeakReference<SplashScreenActivity> splashScreenActivityWeakReference;
    public ValidarCredenciais(SplashScreenActivity callback){
        splashScreenActivityWeakReference = new WeakReference<SplashScreenActivity>(callback);
    }

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

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        SplashScreenActivity ref = splashScreenActivityWeakReference.get();
        if (ref != null) {
            ref.realizarLogin(aBoolean);
        }
    }
}
