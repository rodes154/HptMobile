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
    private HttpTransportSE httpTrans;
    private int soapCount=0;
    private String metodo;
    private Object nullObject;

    public void metodo(String nomeMetodo){
        soap = new SoapObject("http://ws.apache.org/axis2",nomeMetodo);
        metodo = nomeMetodo;
    }

    public void classe(String nomeClasse){
        httpTrans = new HttpTransportSE("http://189.5.142.240:8080/WebServiceTest/services/"+nomeClasse+"?wsdl");
    }

    public void adicionarAtributo(Object o){
        soap.addProperty(String.valueOf(soapCount),o);
        soapCount++;
    }
    public Object realizarConexao(){
        envelope.setOutputSoapObject(soap);
        try {
            httpTrans.call(metodo,envelope);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        try {
            return envelope.getResponse();
        } catch (SoapFault soapFault) {
            soapFault.printStackTrace();
            return nullObject;
        }
    }









}
