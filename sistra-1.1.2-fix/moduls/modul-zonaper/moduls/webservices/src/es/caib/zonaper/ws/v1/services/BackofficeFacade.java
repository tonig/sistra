package es.caib.zonaper.ws.v1.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.2
 * Fri Mar 26 10:36:56 CET 2010
 * Generated source version: 2.2.2
 * 
 */
 
@WebService(targetNamespace = "urn:es:caib:zonaper:ws:v1:services", name = "BackofficeFacade")
@XmlSeeAlso({es.caib.zonaper.ws.v1.model.ObjectFactory.class})
public interface BackofficeFacade {

    @ResponseWrapper(localName = "altaExpedienteResponse", targetNamespace = "urn:es:caib:zonaper:ws:v1:model:BackofficeFacade", className = "es.caib.zonaper.ws.v1.model.AltaExpedienteResponse")
    @RequestWrapper(localName = "altaExpediente", targetNamespace = "urn:es:caib:zonaper:ws:v1:model:BackofficeFacade", className = "es.caib.zonaper.ws.v1.model.AltaExpediente")
    @WebResult(name = "altaExpedienteReturn", targetNamespace = "urn:es:caib:zonaper:ws:v1:model:BackofficeFacade")
    @WebMethod
    public java.lang.String altaExpediente(
        @WebParam(name = "expediente", targetNamespace = "urn:es:caib:zonaper:ws:v1:model:BackofficeFacade")
        es.caib.zonaper.ws.v1.model.Expediente expediente
    ) throws BackofficeFacadeException;

    @ResponseWrapper(localName = "altaEventoExpedienteResponse", targetNamespace = "urn:es:caib:zonaper:ws:v1:model:BackofficeFacade", className = "es.caib.zonaper.ws.v1.model.AltaEventoExpedienteResponse")
    @RequestWrapper(localName = "altaEventoExpediente", targetNamespace = "urn:es:caib:zonaper:ws:v1:model:BackofficeFacade", className = "es.caib.zonaper.ws.v1.model.AltaEventoExpediente")
    @WebMethod
    public void altaEventoExpediente(
        @WebParam(name = "unidadAdministrativa", targetNamespace = "urn:es:caib:zonaper:ws:v1:model:BackofficeFacade")
        long unidadAdministrativa,
        @WebParam(name = "identificadorExpediente", targetNamespace = "urn:es:caib:zonaper:ws:v1:model:BackofficeFacade")
        java.lang.String identificadorExpediente,
        @WebParam(name = "claveExpediente", targetNamespace = "urn:es:caib:zonaper:ws:v1:model:BackofficeFacade")
        java.lang.String claveExpediente,
        @WebParam(name = "evento", targetNamespace = "urn:es:caib:zonaper:ws:v1:model:BackofficeFacade")
        es.caib.zonaper.ws.v1.model.EventoExpediente evento
    ) throws BackofficeFacadeException;
}