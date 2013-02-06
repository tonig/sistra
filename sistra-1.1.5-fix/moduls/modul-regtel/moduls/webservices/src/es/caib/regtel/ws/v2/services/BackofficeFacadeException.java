
package es.caib.regtel.ws.v2.services;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.2.7
 * Wed Jul 25 07:48:56 CEST 2012
 * Generated source version: 2.2.7
 * 
 */

@WebFault(name = "fault", targetNamespace = "urn:es:caib:regtel:ws:v2:model:BackofficeFacade")
public class BackofficeFacadeException extends Exception {
    public static final long serialVersionUID = 20120725074856L;
    
    private es.caib.regtel.ws.v2.model.BackofficeFacadeException fault;

    public BackofficeFacadeException() {
        super();
    }
    
    public BackofficeFacadeException(String message) {
        super(message);
    }
    
    public BackofficeFacadeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BackofficeFacadeException(String message, es.caib.regtel.ws.v2.model.BackofficeFacadeException fault) {
        super(message);
        this.fault = fault;
    }

    public BackofficeFacadeException(String message, es.caib.regtel.ws.v2.model.BackofficeFacadeException fault, Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public es.caib.regtel.ws.v2.model.BackofficeFacadeException getFaultInfo() {
        return this.fault;
    }
}