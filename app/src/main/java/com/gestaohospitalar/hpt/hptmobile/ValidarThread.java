package com.gestaohospitalar.hpt.hptmobile;

/**
 * Created by rodrigo on 29/05/17.
 */

public class ValidarThread extends Thread {

    String username;
    String password;
    boolean loginRealizado = false;

    @Override
    public void run(){
        synchronized (this){
            ValidarCredenciais validarCredenciais = new ValidarCredenciais();
            if(validarCredenciais.validar(username,password)){
                loginRealizado = true;
                notifyAll();
            }else{
                System.out.println("Senha incorreta");
                notifyAll();
            }

        }
    }
    public void inserirCredenciais(String nome, String senha){
        username=nome;
        password=senha;
    }
    public boolean getStatus(){
        return loginRealizado;
    }
}
