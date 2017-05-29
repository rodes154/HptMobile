package com.gestaohospitalar.hpt.hptmobile;

/**
 * Created by rodrigo on 26/05/17.
 */

public class ValidarCredenciais {

    ConexaoWebService conexaoWebService = new ConexaoWebService();

    public boolean validar(String login, String senha){

        conexaoWebService.metodo("validarLogin");
        conexaoWebService.classe("ValidarLogin");
        conexaoWebService.adicionarAtributo("user",login);
        conexaoWebService.adicionarAtributo("pass",senha);
        Object resposta = conexaoWebService.realizarConexao();

        if(resposta.toString().equals("true")){
            System.out.println("logged in");
            return true;
        }else{
            return false;
        }
    }
}
