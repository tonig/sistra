package es.caib.zonaper.persistence.ejb;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.caib.redose.modelInterfaz.ConstantesRDS;
import es.caib.redose.persistence.delegate.DelegateRDSUtil;
import es.caib.redose.persistence.delegate.RdsDelegate;
import es.caib.regtel.persistence.delegate.RegistroOrganismoDelegate;
import es.caib.xml.registro.factoria.ConstantesAsientoXML;
import es.caib.zonaper.model.ElementoExpediente;
import es.caib.zonaper.model.ElementoExpedienteItf;
import es.caib.zonaper.model.Entrada;
import es.caib.zonaper.model.EntradaPreregistro;
import es.caib.zonaper.model.EntradaTelematica;
import es.caib.zonaper.model.EventoExpediente;
import es.caib.zonaper.model.Expediente;
import es.caib.zonaper.model.LogRegistro;
import es.caib.zonaper.model.NotificacionTelematica;
import es.caib.zonaper.model.RegistroExternoPreparado;
import es.caib.zonaper.persistence.delegate.DelegateUtil;
import es.caib.zonaper.persistence.delegate.ExpedienteDelegate;
import es.caib.zonaper.persistence.delegate.LogRegistroDelegate;
import es.caib.zonaper.persistence.delegate.ProcesoBackupDelegate;
import es.caib.zonaper.persistence.delegate.ProcesoRechazarNotificacionDelegate;
import es.caib.zonaper.persistence.delegate.RegistroExternoPreparadoDelegate;
import es.caib.zonaper.persistence.util.AvisosMovilidad;
import es.caib.zonaper.persistence.util.UsernamePasswordCallbackHandler;

/**
 * SessionBean que realiza procesos auto.
 * Los metodos se ejecutaran con el usuario auto
 * 
 *
 * @ejb.bean
 *  name="zonaper/persistence/ProcesosAutoFacade"
 *  jndi-name="es.caib.zonaper.persistence.ProcesosAutoFacade"
 *  type="Stateless"
 *  view-type="remote"
 *  transaction-type="Container"
 *
 * @ejb.transaction type="Required"
 */
public abstract class ProcesosAutoFacadeEJB extends HibernateEJB
{
	private static Log backupLog = LogFactory.getLog( ProcesosAutoFacadeEJB.class );
	
	/**
     * @ejb.create-method
     * @ejb.permission unchecked = "true"
     */
	public void ejbCreate() throws CreateException {
		super.ejbCreate();

	}
	
	/**
	 * Actualiza estado de un expediente	
	 * 
     * @ejb.interface-method
     * @ejb.permission unchecked = "true"
     * 
     */
	public void actualizaEstadoExpediente(Long id)  
	{
		backupLog.debug("actualiza estado expediente " + id);
		
		LoginContext lc = null;		
		try{					
			// Realizamos login JAAS con usuario para proceso automatico	
			Properties props = DelegateUtil.getConfiguracionDelegate().obtenerConfiguracion();
			String user = props.getProperty("auto.user");
			String pass = props.getProperty("auto.pass");
			CallbackHandler handler = new UsernamePasswordCallbackHandler( user, pass ); 					
			lc = new LoginContext("client-login", handler);
			lc.login();
			
			// Actualizamos estado expediente
			doActualizaEstadoExpediente(id);	
			
		}catch (Exception le){
			throw new EJBException("Excepcion al ejecutar proceso",le);
		}finally{				
			// Hacemos el logout
			if ( lc != null ){
				try{lc.logout();}catch(Exception exl){}
			}
		}
	}
	
	/**
	 * Actualiza estado de un expediente a partir de un elemento del expediente.
	 * Si el elemento no pertenece a un expediente no hace nada.
	 * 
     * @ejb.interface-method
     * @ejb.permission unchecked = "true"
     * 
     */
	public void actualizaEstadoExpedienteDelElementoExpediente(String tipoElementoExpediente,Long codigoElementoExpediente)  
	{
		backupLog.debug("actualiza estado expediente del elemento expediente " + tipoElementoExpediente + " - " + codigoElementoExpediente );
		
		LoginContext lc = null;		
		try{					
			// Realizamos login JAAS con usuario para proceso automatico	
			Properties props = DelegateUtil.getConfiguracionDelegate().obtenerConfiguracion();
			String user = props.getProperty("auto.user");
			String pass = props.getProperty("auto.pass");
			CallbackHandler handler = new UsernamePasswordCallbackHandler( user, pass ); 					
			lc = new LoginContext("client-login", handler);
			lc.login();
			
			// Obtenemos elemento expediente
			ElementoExpediente elementoExpe = DelegateUtil.getElementoExpedienteDelegate().obtenerElementoExpediente(tipoElementoExpediente,codigoElementoExpediente);
			
			// Actualizamos estado expediente asociado
			if (elementoExpe != null){
				doActualizaEstadoExpediente(elementoExpe.getExpediente().getCodigo());
			}
				
		}catch (Exception le){
			throw new EJBException("Excepcion al ejecutar proceso",le);
		}finally{				
			// Hacemos el logout
			if ( lc != null ){
				try{lc.logout();}catch(Exception exl){}
			}
		}
	}
	
	
	/**
	 * Genera aviso de creacion de un elemento de un expediente
	 * 
     * @ejb.interface-method
     * @ejb.permission unchecked = "true"
     * 
     */
	public String avisoCreacionElementoExpediente(ElementoExpediente ele) {
		
		backupLog.debug("aviso creacion elemento expediente");
		
		LoginContext lc = null;		
		try{					
			// Realizamos login JAAS con usuario para proceso automatico					
			Properties props = DelegateUtil.getConfiguracionDelegate().obtenerConfiguracion();
			String user = props.getProperty("auto.user");
			String pass = props.getProperty("auto.pass");
			CallbackHandler handler = new UsernamePasswordCallbackHandler( user, pass ); 					
			lc = new LoginContext("client-login", handler);
			lc.login();
			
			// Realizamos aviso
			String idEnvio = AvisosMovilidad.getInstance().avisoCreacionElementoExpediente(ele);
			
			// Asociamos aviso al elemento del expediente
			DelegateUtil.getElementoExpedienteDelegate().establecerAvisoElementoExpediente(ele.getCodigo(), idEnvio);
			
			return idEnvio;
		}catch (LoginException le){
			throw new EJBException("Excepcion al ejecutar proceso",le);
		}catch (Exception e){
			throw new EJBException("Error realizando aviso creacion elemento expediente con usuario auto",e);
		}finally{				
			// Hacemos el logout
			if ( lc != null ){
				try{lc.logout();}catch(Exception exl){}
			}
		}
		
	}
	
	
	/**
	 * Revisa si los registros efectuados se han consolidado y registros externos que se han preparado para firmar a ver si se han relizado
	 * 
     * @ejb.interface-method
     * @ejb.permission unchecked = "true"
     * 
     */
	public void revisarRegistrosEfectuados()  
	{
		backupLog.debug("Revisar registros efectuados");
		
		LoginContext lc = null;		
		try{					
			// Realizamos login JAAS con usuario para proceso automatico	
			Properties props = DelegateUtil.getConfiguracionDelegate().obtenerConfiguracion();
			String user = props.getProperty("auto.user");
			String pass = props.getProperty("auto.pass");
			CallbackHandler handler = new UsernamePasswordCallbackHandler( user, pass ); 					
			lc = new LoginContext("client-login", handler);
			lc.login();
			
			// Revisar registros efectuados
			doRevisarRegistrosEfectuados();
			
			// Revisar registros externos
			doRevisarRegistrosExternosPreparados();					
			
		}catch (Exception le){
			throw new EJBException("Excepcion al ejecutar proceso",le);
		}finally{				
			// Hacemos el logout
			if ( lc != null ){
				try{lc.logout();}catch(Exception exl){}
			}
		}
	}
	
	
	/**
	 * Control entrega de las notificaciones
	 * 
     * @ejb.interface-method
     * @ejb.permission unchecked = "true"
     * 
     */
	public void controlEntregaNotificaciones()  
	{
		backupLog.debug("Control entrega notificaciones");
		
		LoginContext lc = null;		
		try{					
			// Realizamos login JAAS con usuario para proceso automatico	
			Properties props = DelegateUtil.getConfiguracionDelegate().obtenerConfiguracion();
			String user = props.getProperty("auto.user");
			String pass = props.getProperty("auto.pass");
			CallbackHandler handler = new UsernamePasswordCallbackHandler( user, pass ); 					
			lc = new LoginContext("client-login", handler);
			lc.login();
			
			// Recuperamos notificaciones fuera de plazo
			List notificaciones = DelegateUtil.getNotificacionTelematicaDelegate().listarNotificacionesTelematicasFueraPlazo();
			
			// Marcamos como rechazada cada notificacion
			ProcesoRechazarNotificacionDelegate dlg = DelegateUtil.getProcesoRechazarNotificacionDelegate();
			for (Iterator it = notificaciones.iterator(); it.hasNext();) {
				NotificacionTelematica not = (NotificacionTelematica) it.next();
				try {
					dlg.rechazarNotificacion(not.getCodigo());
				}catch (Exception e){
					backupLog.error("Error rechazando notificacion " + not.getCodigo() + " :" + e.getMessage(), e);
				}					
			}			
		}catch (Exception le){
			throw new EJBException("Excepcion al ejecutar proceso",le);
		}finally{				
			// Hacemos el logout
			if ( lc != null ){
				try{lc.logout();}catch(Exception exl){}
			}
		}
	}
	
	
	/**
     * Actualiza estado expediente con la informacion de un tramite de subsanacion
     * @param entrada
     * @param tramiteSubsanacion
     * @throws Exception
     * 
     * @ejb.interface-method
     * @ejb.permission unchecked = "true"
     */
    public void actualizarExpedienteTramiteSubsanacion(Long codigoEntrada, String tipoEntrada) throws Exception{    
    	backupLog.debug("Actualizar expediente con tramite subsanacion");		
		LoginContext lc = null;		
		try{	
			
			// Realizamos login JAAS con usuario para proceso automatico	
			Properties props = DelegateUtil.getConfiguracionDelegate().obtenerConfiguracion();
			String user = props.getProperty("auto.user");
			String pass = props.getProperty("auto.pass");
			CallbackHandler handler = new UsernamePasswordCallbackHandler( user, pass ); 					
			lc = new LoginContext("client-login", handler);
			lc.login();
			
			doActualizarExpedienteTramiteSubsanacion(codigoEntrada, tipoEntrada);
			
    }catch (Exception le){
		throw new EJBException("Excepcion al ejecutar proceso",le);
	}finally{				
		// Hacemos el logout
		if ( lc != null ){
			try{lc.logout();}catch(Exception exl){}
		}
	}
	}
    
	
	// ----------------------------------------------------------------------------------------------
	//	FUNCIONES AUXILIARES
	// ----------------------------------------------------------------------------------------------
	private ElementoExpediente obtenerUltimoElementoExpediente(Long id) 
	{
		Session session = getSession();
		try
		{
			Expediente expediente = ( Expediente )session.load( Expediente.class, id );			
			if (!expediente.getElementos().isEmpty()){
				ElementoExpediente e = null;
				for (Iterator it = expediente.getElementos().iterator();it.hasNext();){
					e = (ElementoExpediente) it.next();
				}
				return e;
			}
			return null;
		}
		catch (HibernateException he) 
		{   
			throw new EJBException(he);
	    } 
		finally 
		{
	        close(session);
	    }
	}
	

	private void doActualizaEstadoExpediente(Long id){
		// Obtenemos ultimo elemento del expediente y obtenemos su detalle
		ElementoExpedienteItf de = null;
		ElementoExpediente e = obtenerUltimoElementoExpediente(id);		
		try{
			de = DelegateUtil.getElementoExpedienteDelegate().obtenerDetalleElementoExpediente(e.getCodigo());
		}catch(Exception dex){
			throw new EJBException(dex);
		}
		
		// Calculamos estado y fecha fin
		String estado = null;
		Date fechaFin = null;
		if (e.getTipoElemento().equals(ElementoExpediente.TIPO_ENTRADA_TELEMATICA)){
			estado = Expediente.ESTADO_SOLICITUD_ENVIADA;
			fechaFin = ((EntradaTelematica) de).getFecha();
		}else if (e.getTipoElemento().equals(ElementoExpediente.TIPO_ENTRADA_PREREGISTRO)){
			if ( ((EntradaPreregistro) de).getFechaConfirmacion() != null ){
			estado = Expediente.ESTADO_SOLICITUD_ENVIADA;
			}else{
				estado = Expediente.ESTADO_SOLICITUD_ENVIADA_PENDIENTE_DOCUMENTACION_PRESENCIAL;				
			}
			fechaFin = ((EntradaPreregistro) de).getFecha();
		}else if (e.getTipoElemento().equals(ElementoExpediente.TIPO_AVISO_EXPEDIENTE)){
			if ( ((EventoExpediente) de).getFechaConsulta() != null){
				estado 	 = Expediente.ESTADO_AVISO_RECIBIDO;
				fechaFin = ((EventoExpediente) de).getFecha();
			}else{
				estado = Expediente.ESTADO_AVISO_PENDIENTE;
				fechaFin = ((EventoExpediente) de).getFecha();
			}
		}else if (e.getTipoElemento().equals(ElementoExpediente.TIPO_NOTIFICACION)){
			if ( ((NotificacionTelematica) de).getFechaAcuse() != null){
				estado = Expediente.ESTADO_NOTIFICACION_RECIBIDA;
				fechaFin = ((NotificacionTelematica) de).getFechaRegistro();
			}else{
				estado = Expediente.ESTADO_NOTIFICACION_PENDIENTE;
				fechaFin = ((NotificacionTelematica) de).getFechaRegistro();
			}
		}
		
		// Actualizamos expediente
		Session session = getSession();
		try
		{
			Expediente expediente = ( Expediente )session.load( Expediente.class, id );			
			expediente.setFechaFin(fechaFin);
			expediente.setEstado(estado);
			session.update(expediente);
		}
		catch (HibernateException he) 
		{   
			throw new EJBException(he);
	    } 
		finally 
		{
	        close(session);
	    }
	}
    /**
     * Revisa registros efectuados para ver si se han consolidado
     *
     */
	private void doRevisarRegistrosEfectuados() throws Exception{
		LogRegistroDelegate dlg = DelegateUtil.getLogRegistroDelegate();
		RegistroOrganismoDelegate dlgOrg = es.caib.regtel.persistence.delegate.DelegateUtil.getRegistroOrganismoDelegate();
		List logRegs = dlg.listarLogRegistro();
		if(logRegs != null){
			for(int i=0;i<logRegs.size();i++){
				LogRegistro logReg = (LogRegistro)logRegs.get(i);
				//A�adimos 15 minutos a la fecha de registro.
				Date dateAux = new Date();
	            int minutesToAdd = 15;  // 15 minutos
                Calendar cal = Calendar.getInstance();
	            cal.setTime(logReg.getFechaRegistro());
	            cal.add(Calendar.MINUTE, minutesToAdd);
	            /*  miramos si se ha registrado por lo menos 15 minutos antes de la ejecuci�n del proceso, para dar tiempo
	             *	a que termine la TX global
	             */
				if(cal.getTime().before(dateAux)){
					if(dlg.tieneUsos(logReg)){
						dlg.borrarLogRegistro(logReg.getId());
					}else{
						if(logReg.getId().getTipoRegistro().equals(ConstantesAsientoXML.TIPO_REGISTRO_SALIDA+"")){
							dlgOrg.anularRegistroSalida(logReg.getId().getNumeroRegistro(), logReg.getFechaRegistro());
						}else{
							dlgOrg.anularRegistroEntrada(logReg.getId().getNumeroRegistro(), logReg.getFechaRegistro());
						}
						logReg.setAnulado("S");
						dlg.grabarLogRegistro(logReg);
					}
				}			
			}
		}
	}
    
	
	private void doActualizarExpedienteTramiteSubsanacion(Long codigoEntrada, String tipoEntrada) throws Exception{
		Entrada entrada = null;
		if (tipoEntrada.equals(ElementoExpediente.TIPO_ENTRADA_TELEMATICA)){
			entrada = DelegateUtil.getEntradaTelematicaDelegate().obtenerEntradaTelematica(codigoEntrada);
		}else{
			entrada = DelegateUtil.getEntradaPreregistroDelegate().obtenerEntradaPreregistro(codigoEntrada);
		}
		if (entrada == null){
			throw new Exception("No se encuentra entrada con codigo " + tipoEntrada + "-" + codigoEntrada);
		}
		
		ExpedienteDelegate ed = DelegateUtil.getExpedienteDelegate();
		Expediente expe = ed.obtenerExpediente(entrada.getSubsanacionExpedienteUA().longValue(),entrada.getSubsanacionExpedienteCodigo());
		if (expe == null){
			throw new Exception("No existe expediente indicado en datos propios: " + entrada.getSubsanacionExpedienteUA()+ " - " + entrada.getSubsanacionExpedienteCodigo());
		}    	
    	ElementoExpediente el = new ElementoExpediente();
    	el.setExpediente(expe);
    	el.setTipoElemento(entrada instanceof EntradaTelematica?ElementoExpediente.TIPO_ENTRADA_TELEMATICA:ElementoExpediente.TIPO_ENTRADA_PREREGISTRO);
    	el.setFecha(entrada.getFecha());
    	el.setCodigoElemento(entrada.getCodigo());
    	expe.addElementoExpediente(el,entrada);
    	DelegateUtil.getExpedienteDelegate().grabarExpediente(expe);
	}
	
	/**
	 * Comprueba si hay registros externos preparados caducados y los elimina.
	 */
	private void doRevisarRegistrosExternosPreparados() throws Exception{
		RegistroExternoPreparadoDelegate dlg = DelegateUtil.getRegistroExternoPreparadoDelegate();
		RdsDelegate rdsDlg = DelegateRDSUtil.getRdsDelegate();
		List regs = dlg.listarCaducados();
		if (regs != null) {
			for (Iterator it = regs.iterator();it.hasNext();){
				RegistroExternoPreparado r = (RegistroExternoPreparado) it.next();				
				// Borramos usos de persistencia
				rdsDlg.eliminarUsos(ConstantesRDS.TIPOUSO_TRAMITEPERSISTENTE, r.getIdPersistencia());
				// Borramos log registro
				dlg.borrarRegistroExternoPreparado(r.getCodigoRdsAsiento());
			}			
		}		
	}
	
}