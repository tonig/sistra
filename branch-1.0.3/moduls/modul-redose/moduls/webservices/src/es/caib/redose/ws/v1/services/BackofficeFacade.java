package es.caib.redose.ws.v1.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.2
 * Mon Dec 21 17:45:53 CET 2009
 * Generated source version: 2.2.2
 * 
 */
 
@WebService(targetNamespace = "urn:es:caib:redose:ws:v1:services", name = "BackofficeFacade")
@XmlSeeAlso({es.caib.redose.ws.v1.model.ObjectFactory.class})
public interface BackofficeFacade {

    @ResponseWrapper(localName = "consultarDocumentoResponse", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade", className = "es.caib.redose.ws.v1.model.ConsultarDocumentoResponse")
    @RequestWrapper(localName = "consultarDocumento", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade", className = "es.caib.redose.ws.v1.model.ConsultarDocumento")
    @WebResult(name = "consultarDocumentoReturn", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade")
    @WebMethod
    public es.caib.redose.ws.v1.model.DocumentoRDS consultarDocumento(
        @WebParam(name = "referencia", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade")
        es.caib.redose.ws.v1.model.ReferenciaRDS referencia
    ) throws BackofficeFacadeException;

    @ResponseWrapper(localName = "consultarDocumentoFormateadoResponse", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade", className = "es.caib.redose.ws.v1.model.ConsultarDocumentoFormateadoResponse")
    @RequestWrapper(localName = "consultarDocumentoFormateado", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade", className = "es.caib.redose.ws.v1.model.ConsultarDocumentoFormateado")
    @WebResult(name = "consultarDocumentoFormateadoReturn", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade")
    @WebMethod
    public es.caib.redose.ws.v1.model.DocumentoRDS consultarDocumentoFormateado(
        @WebParam(name = "referencia", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade")
        es.caib.redose.ws.v1.model.ReferenciaRDS referencia,
        @WebParam(name = "tipoPlantilla", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade")
        java.lang.String tipoPlantilla,
        @WebParam(name = "idioma", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade")
        java.lang.String idioma
    ) throws BackofficeFacadeException;


    
    @ResponseWrapper(localName = "insertarDocumentoResponse", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade", className = "es.caib.redose.ws.v1.model.InsertarDocumentoResponse")
    @RequestWrapper(localName = "insertarDocumento", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade", className = "es.caib.redose.ws.v1.model.InsertarDocumento")
    @WebResult(name = "insertarDocumentoReturn", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade")
    @WebMethod
    public es.caib.redose.ws.v1.model.ReferenciaRDS insertarDocumento(
        @WebParam(name = "documento", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade")
        es.caib.redose.ws.v1.model.DocumentoRDS documento
    ) throws BackofficeFacadeException;

    @ResponseWrapper(localName = "insertarDocumentoConTransformacionResponse", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade", className = "es.caib.redose.ws.v1.model.InsertarDocumentoConTransformacionResponse")
    @RequestWrapper(localName = "insertarDocumentoConTransformacion", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade", className = "es.caib.redose.ws.v1.model.InsertarDocumentoConTransformacion")
    @WebResult(name = "insertarDocumentoConTransformacionReturn", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade")
    @WebMethod
    public es.caib.redose.ws.v1.model.ReferenciaRDS insertarDocumentoConTransformacion(
        @WebParam(name = "documento", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade")
        es.caib.redose.ws.v1.model.DocumentoRDS documento,
        @WebParam(name = "transformacion", targetNamespace = "urn:es:caib:redose:ws:v1:model:BackofficeFacade")
        es.caib.redose.ws.v1.model.TransformacionRDS transformacion
    ) throws BackofficeFacadeException;
}