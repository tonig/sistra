
package es.caib.sistra.wsClient.v2.services;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.2.7
 * Wed Jul 25 12:21:54 CEST 2012
 * Generated source version: 2.2.7
 * 
 */

@WebFault(name = "fault", targetNamespace = "urn:es:caib:sistra:ws:v2:model:SistraFacade")
public class SistraFacadeException extends Exception {
    public static final long serialVersionUID = 20120725122154L;
    
    private es.caib.sistra.wsClient.v2.model.SistraFacadeException fault;

    public SistraFacadeException() {
        super();
    }
    
    public SistraFacadeException(String message) {
        super(message);
    }
    
    public SistraFacadeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SistraFacadeException(String message, es.caib.sistra.wsClient.v2.model.SistraFacadeException fault) {
        super(message);
        this.fault = fault;
    }

    public SistraFacadeException(String message, es.caib.sistra.wsClient.v2.model.SistraFacadeException fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public es.caib.sistra.wsClient.v2.model.SistraFacadeException getFaultInfo() {
        return this.fault;
    }
}
