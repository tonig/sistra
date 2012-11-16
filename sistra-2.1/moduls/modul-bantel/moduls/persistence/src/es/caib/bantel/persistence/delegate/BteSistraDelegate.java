package es.caib.bantel.persistence.delegate;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import es.caib.bantel.persistence.intf.BteSistraFacade;
import es.caib.bantel.persistence.util.BteSistraFacadeUtil;
import es.caib.redose.modelInterfaz.ReferenciaRDS;

/**
 * Interfaz para operar con la BTE
 */
public class BteSistraDelegate implements StatelessDelegate {

    /* ========================================================= */
    /* ==        INTEGRACI�N CON PLATAFORMA TRAMITACI�N 	 === */
    /* ========================================================= */
	public String crearEntradaTelematica(ReferenciaRDS refAsiento,ReferenciaRDS refJustificante,Map refDocumentos) throws DelegateException {
        try {
            return getFacade().crearEntradaTelematica(refAsiento,refJustificante,refDocumentos);
        } catch (Exception e) {
        	e.printStackTrace();	
            throw new DelegateException(e);
        }
    }
    
    public String crearEntradaPreregistro(ReferenciaRDS refAsiento,ReferenciaRDS refJustificante,Map refDocumentos,String numeroRegistro,Date fechaRegistro) throws DelegateException {
        try {
            return getFacade().crearEntradaPreregistro(refAsiento,refJustificante,refDocumentos,numeroRegistro,fechaRegistro);
        } catch (Exception e) {
        	e.printStackTrace();	
            throw new DelegateException(e);
        }
    }
    
    public String crearEntradaPreenvioAutomatico(ReferenciaRDS refAsiento,ReferenciaRDS refJustificante,Map refDocumentos,String numeroRegistro,Date fechaRegistro) throws DelegateException {
        try {
            return getFacade().crearEntradaPreenvioAutomatico(refAsiento,refJustificante,refDocumentos,numeroRegistro,fechaRegistro);
        } catch (Exception e) {
        	e.printStackTrace();	
            throw new DelegateException(e);
        }
    }
    
    public String crearEntradaPreregistroIncorrecto(ReferenciaRDS refAsiento,ReferenciaRDS refJustificante,Map refDocumentos,String numeroRegistro,Date fechaRegistro) throws DelegateException {
        try {
            return getFacade().crearEntradaPreregistroIncorrecto(refAsiento,refJustificante,refDocumentos,numeroRegistro,fechaRegistro);
        } catch (Exception e) {
        	e.printStackTrace();	
            throw new DelegateException(e);
        }
    }
    
    public String confirmacionEntradaPreenvioAutomatico(String numPreregistro,String numregistro,Date fechaRegistro)throws DelegateException {
        try {
            return getFacade().confirmacionEntradaPreenvioAutomatico(numPreregistro,numregistro,fechaRegistro);
        } catch (Exception e) {
        	e.printStackTrace();	
            throw new DelegateException(e);
        }
    }
    
    
  
    
    /* ========================================================= */
    /* ======================== REFERENCIA AL FACADE  ========== */
    /* ========================================================= */
    private BteSistraFacade getFacade() throws NamingException,CreateException,RemoteException {      	    	
    	return BteSistraFacadeUtil.getHome( ).create();
    }

    protected BteSistraDelegate() throws DelegateException {        
    }                  
}
