package com.gestaohospitalar.hpt.hptmobile;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by rodrigo on 26/05/17.
 */

public class ConexaoWebService {


    private SoapObject soap;
    private SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
    private HttpTransportSE httpTrans = new HttpTransportSE("http://192.168.0.123:8080/HptMobileWebService/services/ValidarLogin?wsdl");
    private String metodo;

    public void metodo(String nomeMetodo){
        soap = new SoapObject("http://ws.apache.org/axis2",nomeMetodo);
        metodo = nomeMetodo;
    }

    public void classe(String nomeClasse){
        httpTrans = new HttpTransportSE("http://192.168.0.123:8080/HptMobileWebService/services/"+nomeClasse+"?wsdl");
    }

    public void adicionarAtributo(String nomeAtributo, Object o){
        soap.addProperty(nomeAtributo,o);
    }
    public Object realizarConexao(){
        envelope.setOutputSoapObject(soap);
        try {
            httpTrans.call("validarLogin",envelope);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        try {
            return envelope.getResponse();
        } catch (SoapFault soapFault) {
            soapFault.printStackTrace();
            return false;
        }
    }









}
