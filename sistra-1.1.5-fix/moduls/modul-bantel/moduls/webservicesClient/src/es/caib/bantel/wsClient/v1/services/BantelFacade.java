package es.caib.bantel.wsClient.v1.services;

import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.2
 * Thu Jan 21 09:43:34 CET 2010
 * Generated source version: 2.2.2
 * 
 */
 
@WebService(targetNamespace = "urn:es:caib:bantel:ws:v1:services", name = "BantelFacade")
@XmlSeeAlso({es.caib.bantel.wsClient.v1.model.ObjectFactory.class})
public interface BantelFacade {

    @ResponseWrapper(localName = "avisoEntradasResponse", targetNamespace = "urn:es:caib:bantel:ws:v1:model:BantelFacade", className = "es.caib.bantel.wsClient.v1.model.AvisoEntradasResponse")
    @RequestWrapper(localName = "avisoEntradas", targetNamespace = "urn:es:caib:bantel:ws:v1:model:BantelFacade", className = "es.caib.bantel.wsClient.v1.model.AvisoEntradas")
    @WebMethod(operationName = "avisoEntradas")
    public Response<es.caib.bantel.wsClient.v1.model.AvisoEntradasResponse> avisoEntradasAsync(
        @WebParam(name = "numeroEntradas", targetNamespace = "urn:es:caib:bantel:ws:v1:model:BantelFacade")
        es.caib.bantel.wsClient.v1.model.ReferenciasEntrada numeroEntradas
    );

    @ResponseWrapper(localName = "avisoEntradasResponse", targetNamespace = "urn:es:caib:bantel:ws:v1:model:BantelFacade", className = "es.caib.bantel.wsClient.v1.model.AvisoEntradasResponse")
    @RequestWrapper(localName = "avisoEntradas", targetNamespace = "urn:es:caib:bantel:ws:v1:model:BantelFacade", className = "es.caib.bantel.wsClient.v1.model.AvisoEntradas")
    @WebMethod(operationName = "avisoEntradas")
    public Future<?> avisoEntradasAsync(
        @WebParam(name = "numeroEntradas", targetNamespace = "urn:es:caib:bantel:ws:v1:model:BantelFacade")
        es.caib.bantel.wsClient.v1.model.ReferenciasEntrada numeroEntradas,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<es.caib.bantel.wsClient.v1.model.AvisoEntradasResponse> asyncHandler
    );

    @ResponseWrapper(localName = "avisoEntradasResponse", targetNamespace = "urn:es:caib:bantel:ws:v1:model:BantelFacade", className = "es.caib.bantel.wsClient.v1.model.AvisoEntradasResponse")
    @RequestWrapper(localName = "avisoEntradas", targetNamespace = "urn:es:caib:bantel:ws:v1:model:BantelFacade", className = "es.caib.bantel.wsClient.v1.model.AvisoEntradas")
    @WebMethod
    public void avisoEntradas(
        @WebParam(name = "numeroEntradas", targetNamespace = "urn:es:caib:bantel:ws:v1:model:BantelFacade")
        es.caib.bantel.wsClient.v1.model.ReferenciasEntrada numeroEntradas
    ) throws BantelFacadeException;
}