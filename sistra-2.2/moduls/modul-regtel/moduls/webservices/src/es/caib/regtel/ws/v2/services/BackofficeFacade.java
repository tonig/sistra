package es.caib.regtel.ws.v2.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.7
 * Wed Nov 14 16:32:02 CET 2012
 * Generated source version: 2.2.7
 * 
 */
 
@WebService(targetNamespace = "urn:es:caib:regtel:ws:v2:services", name = "BackofficeFacade")
@XmlSeeAlso({es.caib.regtel.ws.v2.model.ObjectFactory.class})
public interface BackofficeFacade {

    @ResponseWrapper(localName = "registroSalidaResponse", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade", className = "es.caib.regtel.ws.v2.model.RegistroSalidaResponse")
    @RequestWrapper(localName = "registroSalida", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade", className = "es.caib.regtel.ws.v2.model.RegistroSalida")
    @WebResult(name = "registroSalidaReturn", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade")
    @WebMethod
    public es.caib.regtel.ws.v2.model.ResultadoRegistro registroSalida(
        @WebParam(name = "notificacion", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade")
        es.caib.regtel.ws.v2.model.DatosRegistroSalida notificacion
    ) throws BackofficeFacadeException;

    @ResponseWrapper(localName = "registroEntradaConFirmaResponse", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade", className = "es.caib.regtel.ws.v2.model.RegistroEntradaConFirmaResponse")
    @RequestWrapper(localName = "registroEntradaConFirma", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade", className = "es.caib.regtel.ws.v2.model.RegistroEntradaConFirma")
    @WebResult(name = "registroEntradaConFirmaReturn", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade")
    @WebMethod
    public es.caib.regtel.ws.v2.model.ResultadoRegistro registroEntradaConFirma(
        @WebParam(name = "referenciaRDS", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade")
        es.caib.regtel.ws.v2.model.ReferenciaRDSAsientoRegistral referenciaRDS,
        @WebParam(name = "firma", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade")
        es.caib.regtel.ws.v2.model.FirmaWS firma
    ) throws BackofficeFacadeException;

    @ResponseWrapper(localName = "obtenerAcuseReciboResponse", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade", className = "es.caib.regtel.ws.v2.model.ObtenerAcuseReciboResponse")
    @RequestWrapper(localName = "obtenerAcuseRecibo", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade", className = "es.caib.regtel.ws.v2.model.ObtenerAcuseRecibo")
    @WebResult(name = "obtenerAcuseReciboReturn", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade")
    @WebMethod
    public es.caib.regtel.ws.v2.model.AcuseRecibo obtenerAcuseRecibo(
        @WebParam(name = "numeroRegistro", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade")
        java.lang.String numeroRegistro
    ) throws BackofficeFacadeException;

    @ResponseWrapper(localName = "registroEntradaResponse", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade", className = "es.caib.regtel.ws.v2.model.RegistroEntradaResponse")
    @RequestWrapper(localName = "registroEntrada", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade", className = "es.caib.regtel.ws.v2.model.RegistroEntrada")
    @WebResult(name = "registroEntradaReturn", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade")
    @WebMethod
    public es.caib.regtel.ws.v2.model.ResultadoRegistro registroEntrada(
        @WebParam(name = "entrada", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade")
        es.caib.regtel.ws.v2.model.DatosRegistroEntrada entrada
    ) throws BackofficeFacadeException;

    @ResponseWrapper(localName = "obtenerDetalleAcuseReciboResponse", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade", className = "es.caib.regtel.ws.v2.model.ObtenerDetalleAcuseReciboResponse")
    @RequestWrapper(localName = "obtenerDetalleAcuseRecibo", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade", className = "es.caib.regtel.ws.v2.model.ObtenerDetalleAcuseRecibo")
    @WebResult(name = "obtenerDetalleAcuseReciboReturn", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade")
    @WebMethod
    public es.caib.regtel.ws.v2.model.DetalleAcuseRecibo obtenerDetalleAcuseRecibo(
        @WebParam(name = "numeroRegistro", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade")
        java.lang.String numeroRegistro
    ) throws BackofficeFacadeException;

    @ResponseWrapper(localName = "prepararRegistroEntradaResponse", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade", className = "es.caib.regtel.ws.v2.model.PrepararRegistroEntradaResponse")
    @RequestWrapper(localName = "prepararRegistroEntrada", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade", className = "es.caib.regtel.ws.v2.model.PrepararRegistroEntrada")
    @WebResult(name = "prepararRegistroEntradaReturn", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade")
    @WebMethod
    public es.caib.regtel.ws.v2.model.ReferenciaRDSAsientoRegistral prepararRegistroEntrada(
        @WebParam(name = "entrada", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade")
        es.caib.regtel.ws.v2.model.DatosRegistroEntrada entrada,
        @WebParam(name = "diasPersistencia", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade")
        java.lang.String diasPersistencia
    ) throws BackofficeFacadeException;
}