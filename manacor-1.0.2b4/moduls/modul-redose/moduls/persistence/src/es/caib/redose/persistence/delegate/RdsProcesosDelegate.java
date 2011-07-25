package es.caib.redose.persistence.delegate;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import es.caib.redose.persistence.intf.RdsProcesos;
import es.caib.redose.persistence.util.RdsProcesosUtil;

/**
 * Business delegate para operar con RDS.
 */
public class RdsProcesosDelegate implements StatelessDelegate {

    /* ========================================================= */
    /* ======================== M�TODOS DE NEGOCIO ============= */
    /* ========================================================= */
	
	 public void borradoDocumentosSinUsos() throws DelegateException{
    	try {
           getFacade().borradoDocumentosSinUsos();
        } catch (Exception e) {
            throw new DelegateException(e);
        }
    }
	

    /* ========================================================= */
    /* ======================== REFERENCIA AL FACADE  ========== */
    /* ========================================================= */
    private RdsProcesos getFacade() throws NamingException,CreateException,RemoteException {      	    	
    	return RdsProcesosUtil.getHome().create();
    }

    protected RdsProcesosDelegate() throws DelegateException {       
    }                  
}