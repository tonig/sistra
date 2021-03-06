package es.caib.sistra.wsClient.v1.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.2
 * Mon Mar 15 16:15:58 CET 2010
 * Generated source version: 2.2.2
 * 
 */
 
@WebService(targetNamespace = "urn:es:caib:sistra:ws:v1:services", name = "SistraFacade")
@XmlSeeAlso({es.caib.sistra.wsClient.v1.model.ObjectFactory.class})
public interface SistraFacade {

    @ResponseWrapper(localName = "obtenerDominioResponse", targetNamespace = "urn:es:caib:sistra:ws:v1:model:SistraFacade", className = "es.caib.sistra.wsClient.v1.model.ObtenerDominioResponse")
    @RequestWrapper(localName = "obtenerDominio", targetNamespace = "urn:es:caib:sistra:ws:v1:model:SistraFacade", className = "es.caib.sistra.wsClient.v1.model.ObtenerDominio")
    @WebResult(name = "obtenerDominioReturn", targetNamespace = "urn:es:caib:sistra:ws:v1:model:SistraFacade")
    @WebMethod
    public es.caib.sistra.wsClient.v1.model.ValoresDominio obtenerDominio(
        @WebParam(name = "id", targetNamespace = "urn:es:caib:sistra:ws:v1:model:SistraFacade")
        java.lang.String id,
        @WebParam(name = "parametros", targetNamespace = "urn:es:caib:sistra:ws:v1:model:SistraFacade")
        es.caib.sistra.wsClient.v1.model.ParametrosDominio parametros
    ) throws SistraFacadeException;

    @ResponseWrapper(localName = "realizarConsultaResponse", targetNamespace = "urn:es:caib:sistra:ws:v1:model:SistraFacade", className = "es.caib.sistra.wsClient.v1.model.RealizarConsultaResponse")
    @RequestWrapper(localName = "realizarConsulta", targetNamespace = "urn:es:caib:sistra:ws:v1:model:SistraFacade", className = "es.caib.sistra.wsClient.v1.model.RealizarConsulta")
    @WebResult(name = "realizarConsultaReturn", targetNamespace = "urn:es:caib:sistra:ws:v1:model:SistraFacade")
    @WebMethod
    public es.caib.sistra.wsClient.v1.model.DocumentosConsulta realizarConsulta(
        @WebParam(name = "identificadorTramite", targetNamespace = "urn:es:caib:sistra:ws:v1:model:SistraFacade")
        java.lang.String identificadorTramite,
        @WebParam(name = "forms", targetNamespace = "urn:es:caib:sistra:ws:v1:model:SistraFacade")
        es.caib.sistra.wsClient.v1.model.FormulariosConsulta forms
    ) throws SistraFacadeException;
}
