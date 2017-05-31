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
    private String met;
    private Object nullObject = false;

    public void metodo(String nomeMetodo){
        soap = new SoapObject("http://ws.apache.org/axis2",nomeMetodo);
        met = nomeMetodo;
    }

    public void classe(String nomeClasse){
        httpTrans = new HttpTransportSE("http://127.0.0.1:8080/HptMobileWebService/services/"+nomeClasse+"?wsdl");
        httpTrans = new HttpTransportSE("http://127.0.0.1:8080/HptMobileWebService/services/ValidarLogin?wsdl");
    }

    public void adicionarAtributo(String nomeAtributo, Object o){
        soap.addProperty(nomeAtributo,o);
    }
    public Object realizarConexao(){
        envelope.setOutputSoapObject(soap);
        try {
            httpTrans.call(met,envelope);
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
