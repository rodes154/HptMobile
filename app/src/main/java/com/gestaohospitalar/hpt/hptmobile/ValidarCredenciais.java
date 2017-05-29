package com.gestaohospitalar.hpt.hptmobile;

/**
 * Created by rodrigo on 26/05/17.
 */

public class ValidarCredenciais {

    ConexaoWebService conexaoWebService = new ConexaoWebService();

    public boolean validar(String login, String senha){

        conexaoWebService.classe("ChecarLogin");
        conexaoWebService.metodo("checarLogin");
        conexaoWebService.adicionarAtributo(login);
        conexaoWebService.adicionarAtributo(senha);
        Object resposta = conexaoWebService.realizarConexao();

        return (boolean)resposta;

    }
}
