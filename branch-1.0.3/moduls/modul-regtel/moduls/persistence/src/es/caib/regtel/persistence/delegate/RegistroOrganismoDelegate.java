package es.caib.regtel.persistence.delegate;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import javax.ejb.CreateException;
import javax.naming.NamingException;

import es.caib.redose.modelInterfaz.ReferenciaRDS;
import es.caib.regtel.model.ResultadoRegistro;
import es.caib.regtel.persistence.intf.RegistroOrganismoEJBLocal;
import es.caib.regtel.persistence.util.RegistroOrganismoEJBUtil;
import es.caib.xml.registro.factoria.impl.AsientoRegistral;
import es.caib.xml.registro.factoria.impl.Justificante;

public class RegistroOrganismoDelegate implements StatelessDelegate {

    /* ========================================================= */
    /* ======================== M�TODOS DE NEGOCIO ============= */
    /* ========================================================= */
	public ResultadoRegistro registroEntrada(AsientoRegistral asiento,ReferenciaRDS refAsiento,Map refAnexos) throws DelegateException
	{
		try
		{			
			return getFacade().registroEntrada( asiento, refAsiento, refAnexos);				
		} catch (Exception e) {
	        throw new DelegateException(e);
	    }	 	 
	 }

	public ResultadoRegistro registroSalida(AsientoRegistral asiento,ReferenciaRDS refAsiento,Map refAnexos) throws DelegateException
	{
		try
		{			
			return getFacade().registroSalida( asiento, refAsiento, refAnexos);				
		} catch (Exception e) {
	        throw new DelegateException(e);
	    }	 	 
	 }
	
	public ResultadoRegistro confirmarPreregistro(String oficina,String codigoProvincia,String codigoMunicipio,String descripcionMunicipio,Justificante justificantePreregistro,ReferenciaRDS refJustificante,ReferenciaRDS refAsiento,Map refAnexos) throws DelegateException
	{
		try
		{			
			return getFacade().confirmarPreregistro(oficina, codigoProvincia, codigoMunicipio, descripcionMunicipio, justificantePreregistro,refJustificante, refAsiento, refAnexos);				
		} catch (Exception e) {
	        throw new DelegateException(e);
	    }	 	 
	 }
	
	 public void anularRegistroEntrada(String numeroRegistro) throws DelegateException
		{
			try
			{			
				getFacade().anularRegistroEntrada(numeroRegistro);				
			} catch (Exception e) {
		        throw new DelegateException(e);
		    }	 	 
		 }
	
	public List obtenerOficinasRegistro() throws DelegateException
	{
		try
		{			
			return getFacade().obtenerOficinasRegistro();				
		} catch (Exception e) {
	        throw new DelegateException(e);
	    }	 	 
	 }
	
	public List obtenerOficinasRegistroUsuario(String usuario) throws DelegateException
	{
		try
		{			
			return getFacade().obtenerOficinasRegistroUsuario(usuario);				
		} catch (Exception e) {
	        throw new DelegateException(e);
	    }	 	 
	 } 
	
	public List obtenerTiposAsunto() throws DelegateException
	{
		try
		{			
			return getFacade().obtenerTiposAsunto();				
		} catch (Exception e) {
	        throw new DelegateException(e);
	    }	 	 
	 }
	
	public List obtenerServiciosDestino() throws DelegateException
	{
		try
		{			
			return getFacade().obtenerServiciosDestino();				
		} catch (Exception e) {
	        throw new DelegateException(e);
	    }	 	 
	 }
	
	
	
    /* ========================================================= */
    /* ======================== REFERENCIA AL FACADE  ========== */
    /* ========================================================= */
    private RegistroOrganismoEJBLocal getFacade() throws NamingException,RemoteException,CreateException {      	    	
    	return RegistroOrganismoEJBUtil.getLocalHome().create();
    }

    protected RegistroOrganismoDelegate() throws DelegateException {        
    }                  
}
