package es.caib.regtel.ws.v1.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.2
 * Fri Mar 26 10:39:27 CET 2010
 * Generated source version: 2.2.2
 * 
 */
 
@WebService(targetNamespace = "urn:es:caib:regtel:ws:v1:services", name = "BackofficeFacade")
@XmlSeeAlso({es.caib.regtel.ws.v1.model.ObjectFactory.class})
public interface BackofficeFacade {

    @ResponseWrapper(localName = "prepararRegistroEntradaResponse", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade", className = "es.caib.regtel.ws.v1.model.PrepararRegistroEntradaResponse")
    @RequestWrapper(localName = "prepararRegistroEntrada", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade", className = "es.caib.regtel.ws.v1.model.PrepararRegistroEntrada")
    @WebResult(name = "prepararRegistroEntradaReturn", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade")
    @WebMethod
    public es.caib.regtel.ws.v1.model.ReferenciaRDSAsientoRegistral prepararRegistroEntrada(
        @WebParam(name = "entrada", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade")
        es.caib.regtel.ws.v1.model.DatosRegistroEntrada entrada
    ) throws BackofficeFacadeException;

    @ResponseWrapper(localName = "registroEntradaResponse", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade", className = "es.caib.regtel.ws.v1.model.RegistroEntradaResponse")
    @RequestWrapper(localName = "registroEntrada", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade", className = "es.caib.regtel.ws.v1.model.RegistroEntrada")
    @WebResult(name = "registroEntradaReturn", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade")
    @WebMethod
    public es.caib.regtel.ws.v1.model.ResultadoRegistro registroEntrada(
        @WebParam(name = "entrada", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade")
        es.caib.regtel.ws.v1.model.DatosRegistroEntrada entrada
    ) throws BackofficeFacadeException;

    @ResponseWrapper(localName = "registroSalidaResponse", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade", className = "es.caib.regtel.ws.v1.model.RegistroSalidaResponse")
    @RequestWrapper(localName = "registroSalida", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade", className = "es.caib.regtel.ws.v1.model.RegistroSalida")
    @WebResult(name = "registroSalidaReturn", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade")
    @WebMethod
    public es.caib.regtel.ws.v1.model.ResultadoRegistro registroSalida(
        @WebParam(name = "notificacion", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade")
        es.caib.regtel.ws.v1.model.DatosRegistroSalida notificacion
    ) throws BackofficeFacadeException;

    @ResponseWrapper(localName = "obtenerAcuseReciboResponse", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade", className = "es.caib.regtel.ws.v1.model.ObtenerAcuseReciboResponse")
    @RequestWrapper(localName = "obtenerAcuseRecibo", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade", className = "es.caib.regtel.ws.v1.model.ObtenerAcuseRecibo")
    @WebResult(name = "obtenerAcuseReciboReturn", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade")
    @WebMethod
    public es.caib.regtel.ws.v1.model.AcuseRecibo obtenerAcuseRecibo(
        @WebParam(name = "numeroRegistro", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade")
        java.lang.String numeroRegistro
    ) throws BackofficeFacadeException;

    @ResponseWrapper(localName = "registroEntradaConFirmaResponse", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade", className = "es.caib.regtel.ws.v1.model.RegistroEntradaConFirmaResponse")
    @RequestWrapper(localName = "registroEntradaConFirma", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade", className = "es.caib.regtel.ws.v1.model.RegistroEntradaConFirma")
    @WebResult(name = "registroEntradaConFirmaReturn", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade")
    @WebMethod
    public es.caib.regtel.ws.v1.model.ResultadoRegistro registroEntradaConFirma(
        @WebParam(name = "referenciaRDS", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade")
        es.caib.regtel.ws.v1.model.ReferenciaRDSAsientoRegistral referenciaRDS,
        @WebParam(name = "firma", targetNamespace = "urn:es:caib:regtel:ws:v1:model:BackofficeFacade")
        es.caib.regtel.ws.v1.model.FirmaWS firma
    ) throws BackofficeFacadeException;
}
