package es.caib.zonaper.persistence.ejb;

import java.lang.reflect.InvocationTargetException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.naming.InitialContext;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import es.caib.zonaper.persistence.delegate.DelegateUtil;
import es.caib.redose.modelInterfaz.ReferenciaRDS;
import es.caib.redose.modelInterfaz.UsoRDS;
import es.caib.redose.persistence.delegate.DelegateRDSUtil;
import es.caib.redose.persistence.delegate.RdsDelegate;
import es.caib.sistra.plugins.PluginFactory;
import es.caib.sistra.plugins.login.PluginLoginIntf;
import es.caib.util.CredentialUtil;
import es.caib.zonaper.model.DocumentoPersistente;
import es.caib.zonaper.model.DocumentoPersistenteBackup;
import es.caib.zonaper.model.TramitePersistente;
import es.caib.zonaper.model.TramitePersistenteBackup;
import es.caib.zonaper.modelInterfaz.PersonaPAD;
import es.caib.zonaper.persistence.util.GeneradorId;

/**
 * SessionBean para mantener y consultar TramitePersistente
 *
 * @ejb.bean
 *  name="zonaper/persistence/TramitePersistenteFacade"
 *  jndi-name="es.caib.zonaper.persistence.TramitePersistenteFacade"
 *  type="Stateless"
 *  view-type="remote"
 *  transaction-type="Container"
 *
 * @ejb.transaction type="Required"
 * 
 * @ejb.env-entry name="roleAuto" type="java.lang.String" value="${role.auto}"
 * @ejb.env-entry name="roleHelpdesk" type="java.lang.String" value="${role.helpdesk}"
 */
public abstract class TramitePersistenteFacadeEJB extends HibernateEJB {

	private String roleAuto;
	private String roleHelpdesk;

	/**
     * @ejb.create-method
     * @ejb.permission role-name="${role.auto}"
     * @ejb.permission role-name="${role.todos}"
     */
	public void ejbCreate() throws CreateException {
		super.ejbCreate();
		try{
			InitialContext initialContext = new InitialContext();			 
			roleAuto = (( String ) initialContext.lookup( "java:comp/env/roleAuto" ));		
			roleHelpdesk = (( String ) initialContext.lookup( "java:comp/env/roleHelpdesk" ));
		}catch(Exception ex){
			log.error(ex);
		}			
	}
	 

	/**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.auto}"
     * @ejb.permission role-name="${role.todos}"
     * @ejb.permission role-name="${role.helpdesk}"
     */
    public TramitePersistente obtenerTramitePersistente(String id) {
        Session session = getSession();
        try {
        	// Cargamos tramitePersistente        	
        	Query query = session
            .createQuery("FROM TramitePersistente AS m WHERE m.idPersistencia = :id")
            .setParameter("id",id);
            //query.setCacheable(true);
            if (query.list().isEmpty()){
            	return null;
            	//throw new HibernateException("No existe tr�mite con id " + id);
            }
            
            log.debug( "Size tramite persistente query result " + query.list().size() );
            
            // System.out.println ( "Size tramite persistente query result " + query.list().size() );
            // System.out.println( query.list() );
            
            TramitePersistente tramitePersistente = (TramitePersistente)  query.uniqueResult(); 
                        
            controlAccesoTramite(tramitePersistente,true,null);
            
        	// Cargamos documentos
        	Hibernate.initialize(tramitePersistente.getDocumentos());        	
            return tramitePersistente;
        } catch (Exception he) {        	
        	throw new EJBException("No se puede obtener tramite con idPersistencia " + id,  he);
        } finally {
            close(session);
        }
    }
    
    /**
     * Comprueba si existe tramite persistente con ese id persistencia
     * @ejb.interface-method    
     * @ejb.permission role-name="${role.todos}"
     */
    public boolean existeTramitePersistente(String id) {
        Session session = getSession();
        try {    	
        	Query query = session
            .createQuery("FROM TramitePersistente AS m WHERE m.idPersistencia = :id")
            .setParameter("id",id);
            //query.setCacheable(true);
            if (query.list().isEmpty()){
            	return false;
            } else {
            	return true;
            }            
        } catch (Exception he) {        	
        	throw new EJBException("No se puede obtener tramite con idPersistencia " + id,  he);
        } finally {
            close(session);
        }
    }
    
    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.helpdesk}"
     */
    public TramitePersistente obtenerTramitePersistenteBackup(String id) {
        Session session = getSession();
        try {
        	// Cargamos tramitePersistente        	
        	Query query = session
            .createQuery("FROM TramitePersistenteBackup AS m WHERE m.idPersistencia = :id")
            .setParameter("id",id);
            //query.setCacheable(true);
            if (query.list().isEmpty()){
            	return null;
            	//throw new HibernateException("No existe tr�mite con id " + id);
            }
            
            log.debug( "Size tramite persistente backup query result " + query.list().size() );
            
            // System.out.println ( "Size tramite persistente query result " + query.list().size() );
            // System.out.println( query.list() );
            
        	TramitePersistente result = new TramitePersistente();
            
        	TramitePersistenteBackup tramitePersistenteBackup = (TramitePersistenteBackup) query.uniqueResult();
        	Hibernate.initialize(tramitePersistenteBackup.getDocumentosBackup());
        	// Copiamos TramitePersistenteBackup a TramitePersistente
        	{
    	    	BeanUtils.copyProperties( result, tramitePersistenteBackup );
    			Set setDocumentos = tramitePersistenteBackup.getDocumentosBackup(); 
    			for ( Iterator itTP = setDocumentos.iterator(); itTP.hasNext(); )
    			{
    				DocumentoPersistenteBackup backup = ( DocumentoPersistenteBackup ) itTP.next();
    		    	DocumentoPersistente doc = new DocumentoPersistente();
    		    	BeanUtils.copyProperties( doc, backup );
    		    	result.addDocumento( doc );
    			}
        	}
//        	throw new EJBException("Error al copiar TramitePersitente desde Backup " + id,  e);

            return result;
        } catch (HibernateException he) {        	
        	throw new EJBException("No se puede obtener tramite con idPersistencia " + id,  he);
		} catch (IllegalAccessException e) {
			throw new EJBException("Error al copiar TramitePersitente desde Backup " + id,  e);
		} catch (InvocationTargetException e) {
			throw new EJBException("Error al copiar TramitePersitente desde Backup " + id,  e);
		} finally {
            close(session);
        }
    }
    
    
    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.auto}"
     * @ejb.permission role-name="${role.todos}"
     */
    public void borrarDocumentosTramitePersistente(String id) {
        Session session = getSession();
        try {
        	// Cargamos tramitePersistente 
        	TramitePersistente tramitePersistente = obtenerTramitePersistente(id);
        	
        	// Controlamos acceso a tramite (de forma adicional a obtenerTramitePersistente por si accede con role helpdesk)
        	controlAccesoTramite(tramitePersistente,false,null);
        	
        	// Borramos documentos
        	tramitePersistente.getDocumentos().removeAll(tramitePersistente.getDocumentos());        	
        	session.update(tramitePersistente);
        } catch (Exception he) {
            throw new EJBException(he);
        } finally {
            close(session);
        }
    }
    
        
	/**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.auto}"
     * @ejb.permission role-name="${role.todos}"
     */
    public String grabarTramitePersistente(TramitePersistente obj) {        
    	Session session = getSession();
        try {        	
        	if (obj.getCodigo() == null){
        		// Si es nuevo generamos id persistencia
        		String id = GeneradorId.generarId();         		        		        		
        		obj.setIdPersistencia(id);
        		session.save(obj);
        	}else{
        		// Controlamos acceso a tramite: solo usuario o helpdesk puede acceder al tramite
        		
        		// OBTENER USUARIO FLUJO ANTERIOR POR SI SE HA PRODUCIDO CAMBIO DE FLUJO
        		Query query = session.createQuery( "SELECT t.usuarioFlujoTramitacion FROM TramitePersistente t where t.codigo = :codigo" );
    			query.setParameter( "codigo", obj.getCodigo() );
    			String usuarioFlujoAnterior = (String) query.uniqueResult();
    			
        		controlAccesoTramite(obj,false,usuarioFlujoAnterior);        		
        		session.update(obj);
        	}
        	                    	
            return obj.getIdPersistencia();
        } catch (Exception he) {
            throw new EJBException(he);
        } finally {
        	
            close(session);
        }
    }
    
    /**
     * 
     * Obtiene lista de tramites persistentes que tiene pendientes por completar el usuario 
     * o bien ha remitido a otro usuario 
     * 
     * @ejb.interface-method
     * @ejb.permission role-name="${role.todos}"
     */
    public List listarTramitePersistentesUsuario() {
        Session session = getSession();
        try {       	
        	Principal sp = this.ctx.getCallerPrincipal(); 
        	PluginLoginIntf plgLogin = PluginFactory.getInstance().getPluginLogin();
        	if (plgLogin.getMetodoAutenticacion(sp) == CredentialUtil.NIVEL_AUTENTICACION_ANONIMO) throw new HibernateException("Debe estar autenticado");
        	
            Query query = session
            .createQuery("FROM TramitePersistente AS m WHERE (m.usuarioFlujoTramitacion = :usuario or m.usuario = :usuario) ORDER BY m.fechaModificacion DESC")
            .setParameter("usuario",sp.getName());
            //query.setCacheable(true);
            List tramites = query.list();
            
            // Cargamos documentos
            for (Iterator it=tramites.iterator();it.hasNext();){
            	TramitePersistente tramitePersistente = (TramitePersistente) it.next();
            	Hibernate.initialize(tramitePersistente.getDocumentos());
            }
            
            return tramites;
            
        } catch (Exception he) {
            throw new EJBException(he);
        } finally {
            close(session);
        }
    }         
    
    /**
     * 
     * Obtiene lista de tramites persistentes que tiene pendientes por completar la entidad
     * o bien ha remitido a otro usuario 
     * 
     * @ejb.interface-method
     * @ejb.permission role-name="${role.todos}"
     */
    public List listarTramitePersistentesEntidadDelegada(String nifEntidad) {
        Session session = getSession();
        try {       	
        	Principal sp = this.ctx.getCallerPrincipal(); 
        	PluginLoginIntf plgLogin = PluginFactory.getInstance().getPluginLogin();
        	if (plgLogin.getMetodoAutenticacion(sp) == CredentialUtil.NIVEL_AUTENTICACION_ANONIMO) throw new HibernateException("Debe estar autenticado");
        	
        	// Comprobamos que el usuario es delegado de la entidad
        	String permisos = DelegateUtil.getDelegacionDelegate().obtenerPermisosDelegacion(nifEntidad);
        	if (StringUtils.isEmpty(permisos)){
        		throw new Exception("El usuario no es delegado de la entidad");
        	}
        	
        	// Buscamos usuario asociada a la entidad
        	PersonaPAD entidad = DelegateUtil.getPadAplicacionDelegate().obtenerDatosPersonaPADporNif(nifEntidad);
        	if (entidad == null){
        		throw new Exception("No se encuentra entidad con nif/cif " + nifEntidad);
        	}
        	
        	// Buscamos tramites de la entidad
            Query query = session
            .createQuery("FROM TramitePersistente AS m WHERE (m.usuarioFlujoTramitacion = :usuario or m.usuario = :usuario) ORDER BY m.fechaModificacion DESC")
            .setParameter("usuario",entidad.getUsuarioSeycon());
            //query.setCacheable(true);
            List tramites = query.list();
            
            // Cargamos documentos
            for (Iterator it=tramites.iterator();it.hasNext();){
            	TramitePersistente tramitePersistente = (TramitePersistente) it.next();
            	Hibernate.initialize(tramitePersistente.getDocumentos());
            }
            
            return tramites;
            
        } catch (Exception he) {
            throw new EJBException(he);
        } finally {
            close(session);
        }
    }         
       
    
    /**
     * Obtiene lista de tramites persistentes (de un determinado tramite/version) que tiene pendientes por completar el usuario,
     * o bien ha remitido a otro usuario 
     * 
     * @ejb.interface-method
     * @ejb.permission role-name="${role.todos}"
     */
    public List listarTramitePersistentesUsuario(String tramite,int version) {
        Session session = getSession();
        try {       	
        	Principal sp = this.ctx.getCallerPrincipal(); 
        	PluginLoginIntf plgLogin = PluginFactory.getInstance().getPluginLogin();
        	if (plgLogin.getMetodoAutenticacion(sp) == CredentialUtil.NIVEL_AUTENTICACION_ANONIMO) throw new HibernateException("Debe estar autenticado");
        	
        	Query query = session
            .createQuery("FROM TramitePersistente AS m WHERE (m.usuarioFlujoTramitacion = :usuario or m.usuario = :usuario) and m.tramite = :tramite and m.version = :version ORDER BY m.fechaModificacion DESC")
            .setParameter("usuario",sp.getName())
            .setParameter("tramite",tramite)
            .setParameter("version",new Integer(version));
            //query.setCacheable(true);
            List tramites = query.list();
            
            // Cargamos documentos
            for (Iterator it=tramites.iterator();it.hasNext();){
            	TramitePersistente tramitePersistente = (TramitePersistente) it.next();
            	Hibernate.initialize(tramitePersistente.getDocumentos());
            }
            
            return tramites;
            
        } catch (Exception he) {
            throw new EJBException(he);
        } finally {
            close(session);
        }
    }
    
    /**
     * Obtiene lista de tramites en persistencia del usuario para los ue tiene pendientes por completar el usuario,
     * o bien ha remitido a otro usuario  
     * 
     * @ejb.interface-method
     * @ejb.permission role-name="${role.todos}"
     */
    public int numeroTramitesPersistentesUsuario()
    {
    	Session session = getSession();
        try 
        {       	
        	Principal sp = this.ctx.getCallerPrincipal(); 
        	PluginLoginIntf plgLogin = PluginFactory.getInstance().getPluginLogin();
        	if (plgLogin.getMetodoAutenticacion(sp) == CredentialUtil.NIVEL_AUTENTICACION_ANONIMO) throw new HibernateException("Debe estar autenticado");
        	
            Query query = session
            .createQuery("select count(*) FROM TramitePersistente AS m WHERE m.usuarioFlujoTramitacion = :usuario or m.usuario = :usuario")
            .setParameter("usuario",sp.getName());
            //query.setCacheable(true);
            return  ( (Integer) query.iterate().next() ).intValue();
            
        } catch (Exception he) {
            throw new EJBException(he);
        } finally {
            close(session);
        }
    }
    
    /**
     * Obtiene el numero de tramites en persistencia con nivel de autenticacion anonimo y 
     * que su fecha de ultima modificacion este comprendida en el rango pasado como paramtros
     * 
     * @ejb.interface-method
     * @ejb.permission role-name="${role.helpdesk}"
     */
    public int numeroTramitesPersistentesAnonimos(Date fechaInicial, Date fechaFinal, String modelo)
    {
    	Session session = getSession();
        try 
        {       	
            Query query = session
            .createQuery("select count(*) FROM TramitePersistente AS m WHERE m.nivelAutenticacion = '" + CredentialUtil.NIVEL_AUTENTICACION_ANONIMO + "' and m.fechaModificacion <= :fechaFinal and m.fechaModificacion >= :fechaInicial and m.tramite = :modelo");
            query.setParameter("fechaInicial",fechaInicial);
            query.setParameter("fechaFinal",fechaFinal);
            query.setParameter("modelo",modelo);
            int numTramitesPersistentes = ( (Integer) query.iterate().next() ).intValue();
            // Buscamos ahora en Backup
            query = session
            .createQuery("select count(*) FROM TramitePersistenteBackup AS m WHERE m.nivelAutenticacion = 'A' and m.fechaModificacion <= :fechaFinal and m.fechaModificacion >= :fechaInicial and m.tramite = :modelo");
            query.setParameter("fechaInicial",fechaInicial);
            query.setParameter("fechaFinal",fechaFinal);
            query.setParameter("modelo",modelo);
            numTramitesPersistentes += ( (Integer) query.iterate().next() ).intValue();
            //query.setCacheable(true);
            return  numTramitesPersistentes;
            
        } catch (HibernateException he) {
            throw new EJBException(he);
        } finally {
            close(session);
        }
    }

    /**
     * Obtiene la lista de tramites en persistencia pasando el nivel de autenticacion por parametro y 
     * que su fecha de ultima modificacion este comprendida en el rango pasado como parametro
     * 
     * @ejb.interface-method
     * @ejb.permission role-name="${role.helpdesk}"
     */
    public List listarTramitesPersistentes(Date fechaInicial, Date fechaFinal, String modelo, String nivelAutenticacion) {
        Session session = getSession();
        try {       	
            Query query = session
            .createQuery("FROM TramitePersistente AS m WHERE " +
            		     ((nivelAutenticacion != null) ? "m.nivelAutenticacion = :nivel and " : "") +
            		     "m.fechaModificacion <= :fechaFinal and m.fechaModificacion >= :fechaInicial" +
            		     ((modelo != null) ? " and m.tramite = :modelo" : ""));
            query.setParameter("fechaInicial",fechaInicial);
            query.setParameter("fechaFinal",fechaFinal);
            if(modelo != null) query.setParameter("modelo",modelo);
            if(nivelAutenticacion != null) query.setParameter("nivel",nivelAutenticacion);

            List tramites = query.list();
            
            // Cargamos documentos
            for (Iterator it=tramites.iterator();it.hasNext();){
            	TramitePersistente tramitePersistente = (TramitePersistente) it.next();
            	Hibernate.initialize(tramitePersistente.getDocumentos());
            }
            
            return tramites;
            
        } catch (HibernateException he) {
            throw new EJBException(he);
        }
    	catch( Exception exc )
    	{
    		throw new EJBException( exc );
    	}finally {
            close(session);
        }
    }

    /**
     * Obtiene la lista de tramites en persistencia en backup pasando el nivel de autenticacion como par�metro y 
     * que su fecha de ultima modificacion este comprendida en el rango pasado como paramtros
     * 
     * @ejb.interface-method
     * @ejb.permission role-name="${role.helpdesk}"
     */
    public List listarTramitesPersistentesBackup(Date fechaInicial, Date fechaFinal, String modelo, String nivelAutenticacion) {
        Session session = getSession();
        try {       	
            Query query = session
            .createQuery("FROM TramitePersistenteBackup AS m WHERE " +
       		     ((nivelAutenticacion != null) ? "m.nivelAutenticacion = :nivel and " : "") +
       		     "m.fechaModificacion <= :fechaFinal and m.fechaModificacion >= :fechaInicial" +
       		     ((modelo != null) ? " and m.tramite = :modelo" : ""));
            query.setParameter("fechaInicial",fechaInicial);
            query.setParameter("fechaFinal",fechaFinal);
            if(modelo != null) query.setParameter("modelo",modelo);
            if(nivelAutenticacion != null) query.setParameter("nivel",nivelAutenticacion);
            
            List tramites = query.list();
            
            List lstTramites = new ArrayList();
            
            // Cargamos documentos
            for (Iterator it=tramites.iterator();it.hasNext();){
            	TramitePersistenteBackup tramitePersistenteBackup = (TramitePersistenteBackup) it.next();
            	Hibernate.initialize(tramitePersistenteBackup.getDocumentosBackup());
            	// Copiamos TramitePersistenteBackup a TramitePersistente
            	{
                	TramitePersistente result = new TramitePersistente();
        	    	BeanUtils.copyProperties( result, tramitePersistenteBackup );
        			Set setDocumentos = tramitePersistenteBackup.getDocumentosBackup(); 
        			for ( Iterator itTP = setDocumentos.iterator(); itTP.hasNext(); )
        			{
        				DocumentoPersistenteBackup backup = ( DocumentoPersistenteBackup ) itTP.next();
        		    	DocumentoPersistente doc = new DocumentoPersistente();
        		    	BeanUtils.copyProperties( doc, backup );
        		    	result.addDocumento( doc );
        			}
        			lstTramites.add(result);
            	}

            }
            
            
            return lstTramites;
            
        } catch (HibernateException he) {
            throw new EJBException(he);
        }
    	catch( Exception exc )
    	{
    		throw new EJBException( exc );
    	}finally {
            close(session);
        }
    }

    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.auto}"
     * @ejb.permission role-name="${role.todos}"
     */
    public void borrarTramitePersistente(String id) {
    	
    	// Obtenemos tramite persistente (se realiza control de acceso)
    	TramitePersistente tramitePersistente =  this.obtenerTramitePersistente(id);
    	
    	// Borramos tramite persistente
        Session session = getSession();
        try {
            session.delete(tramitePersistente);
        } catch (HibernateException he) {
            throw new EJBException(he);
        } finally {
            close(session);
        }
    }
    
    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.auto}"
     */
    public List listarTramitePersistentesCaducados( Date fecha ) {
        Session session = getSession();
        try {       	
            Query query = session
            .createQuery("FROM TramitePersistente AS m WHERE m.fechaCaducidad < :fecha ORDER BY m.fechaCreacion ASC")
            .setParameter("fecha", fecha );
            //query.setCacheable(true);
            List tramites = query.list();
            
            // Cargamos documentos
            for (Iterator it=tramites.iterator();it.hasNext();){
            	TramitePersistente tramitePersistente = (TramitePersistente) it.next();
            	Hibernate.initialize(tramitePersistente.getDocumentos());
            }
            
            return tramites;
            
        } catch (HibernateException he) {
            throw new EJBException(he);
        } finally {
            close(session);
        }
    }
    
    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.auto}" 
     * @param tramitePersistente
     * @return
     */
    public void backupTramitePersistente( TramitePersistente tramitePersistente )
    {
    	try
    	{
        	TramitePersistenteBackup result = new TramitePersistenteBackup();
	    	BeanUtils.copyProperties( result, tramitePersistente );
			Set setDocumentos = tramitePersistente.getDocumentos(); 
			for ( Iterator it = setDocumentos.iterator(); it.hasNext(); )
			{
				DocumentoPersistente documento = ( DocumentoPersistente ) it.next();
		    	DocumentoPersistenteBackup backup = new DocumentoPersistenteBackup();
		    	BeanUtils.copyProperties( backup, documento );
		    	result.addDocumentoBackup( backup );
			}
			grabarBackupTramitePersistente ( result );
    	}
    	catch( Exception exc )
    	{
    		throw new EJBException( exc );
    	}
    }
    
    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.auto}" 
     * @param tramitePersistenteBackup
     * @return
     */
    public void borrarTramitePersistenteBackup( TramitePersistenteBackup tramitePersistenteBackup )
    {
    	Session session = getSession();
    	try
    	{
    		RdsDelegate rds = DelegateRDSUtil.getRdsDelegate();
    		if(tramitePersistenteBackup != null && tramitePersistenteBackup.getDocumentosBackup() != null){
    			for(Iterator it = tramitePersistenteBackup.getDocumentosBackup().iterator(); it.hasNext();){
    				boolean trobat = true;
    				DocumentoPersistenteBackup backup = ( DocumentoPersistenteBackup ) it.next();
    				ReferenciaRDS ref = new ReferenciaRDS();
    				if(backup.getRdsCodigo() != null){
    					ref.setCodigo(backup.getRdsCodigo().longValue());
    					ref.setClave(backup.getRdsClave());
    					List usos = rds.listarUsos(ref);
    					for(int i=0;i<usos.size();i++){
    						rds.eliminarUso((UsoRDS)usos.get(i));
    					}
    				}
    			}
//    			 Borramos documentos
            	tramitePersistenteBackup.getDocumentosBackup().removeAll(tramitePersistenteBackup.getDocumentosBackup());        	
    		}
    		session.delete(tramitePersistenteBackup);
    	}
    	catch( Exception exc )
    	{
    		throw new EJBException( exc );
        } finally {
            close(session);
        }
    	
    }
    
    
    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.auto}"
     */
    public List listarTramitePersistentesBackup( Date fecha ) {
        Session session = getSession();
        try {      
            Query query = session
            .createQuery("FROM TramitePersistenteBackup AS m WHERE m.fechaModificacion < :fecha")
            .setParameter("fecha", fecha );
            //query.setCacheable(true);
            List tramites = query.list();
            
            // Cargamos documentos
            for (Iterator it=tramites.iterator();it.hasNext();){
            	TramitePersistenteBackup tramitePersistenteBackup = (TramitePersistenteBackup) it.next();
            	Hibernate.initialize(tramitePersistenteBackup.getDocumentosBackup());
            }
            
            return tramites;
            
        } catch (HibernateException he) {
            throw new EJBException(he);
        } finally {
            close(session);
        }
    }
    
    
    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.todos}"
     */
    public DocumentoPersistente obtenerDocumentoTramitePersistente(Long codigo) {
        Session session = getSession();
        try {
        	// Recuperamos documento
        	DocumentoPersistente documento = (DocumentoPersistente) session.load(DocumentoPersistente.class, codigo);
        	// Controlamos acceso tramite            
            controlAccesoTramite(documento.getTramitePersistente(),false,null);
            // Devolvemos documento
            Hibernate.initialize(documento.getTramitePersistente());
            return documento;
        } catch (Exception he) {        	
        	throw new EJBException("No se puede obtener documento con codigo " + codigo,  he);
        } finally {
            close(session);
        }
    }
    
    
    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.todos}"
     */
    public void actualizarInfoDelegacionDocumentoTramitePersistente(Long codigo, String estadoDelegacion,
    		String firmantes, String firmantesPendientes) {
        
    	// Recuperamos documento (se valida control de acceso al recuperar el documento)
    	DocumentoPersistente doc = this.obtenerDocumentoTramitePersistente(codigo);
    	if (doc == null){
    		throw new EJBException("No existe documento");
    	}
    	
    	// Establecemos info delegacion
    	doc.setDelegacionEstado(estadoDelegacion);
    	doc.setDelegacionFirmantes(firmantes);
    	doc.setDelegacionFirmantesPendientes(firmantesPendientes);
    	
    	// Actualizamos documento
    	Session session = getSession();
        try {
        	session.update(doc);
        } catch (Exception he) {        	
        	throw new EJBException("No se puede actualizar documento con codigo " + codigo,  he);
        } finally {
            close(session);
        }
    }
    
    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.todos}"
     */
    public void actualizarInfoDelegacionTramitePersistente(String idPersistencia, String estadoDelegacion) {
        
    	// Recuperamos tramite (se valida control de acceso al recuperar el tramite)
    	TramitePersistente tramite = this.obtenerTramitePersistente(idPersistencia);
    	if (tramite == null){
    		throw new EJBException("No existe tramite");
    	}
    	
    	// Establecemos info delegacion
    	tramite.setEstadoDelegacion(estadoDelegacion);
    	
    	// Actualizamos tramite
    	Session session = getSession();
        try {
        	session.update(tramite);
        } catch (Exception he) {        	
        	throw new EJBException("No se puede actualizar tramite con idPersistencia " + idPersistencia,  he);
        } finally {
            close(session);
        }
    }
    
    // ------------------------------------------------------------------------------------------------------
    // 			FUNCIONES AUXILIARES
    // ------------------------------------------------------------------------------------------------------
    private void grabarBackupTramitePersistente( TramitePersistenteBackup tramitePersistenteBackup ) throws Exception
    {
    	Session session = getSession();
    	try 
        {
    		session.save( tramitePersistenteBackup );
        }
    	finally 
    	{
            close(session);
        }
    }
    
    /**
     * Realiza el control de acceso:
     * 	- si tiene role admin puede acceder
     *  - si el tramite es autenticado y el usuario logeado es el iniciador o el que tiene el flujo (o ten�a el flujo, si se ha realizado un cambio de flujo) 
     *  - si el tramite es anonimo y usuario anonimo puede acceder
     *   
     * @param tramitePersistente
     * @throws HibernateException 
     */
    private void controlAccesoTramite(TramitePersistente tramitePersistente,boolean helpdesk,String usuarioFlujoAnterior) throws Exception {
		Principal sp = this.ctx.getCallerPrincipal();
		PluginLoginIntf plgLogin = PluginFactory.getInstance().getPluginLogin();
    	String usuario = sp.getName();
    	if (this.ctx.isCallerInRole(this.roleAuto)) return;
    	if (helpdesk && this.ctx.isCallerInRole(this.roleHelpdesk)) return;
		if (tramitePersistente.getNivelAutenticacion() != CredentialUtil.NIVEL_AUTENTICACION_ANONIMO) {
			// Usuario es el propietario del tramite
			if (usuario.equals(tramitePersistente.getUsuario())) return;
			// Usuario es al que se le va a pasar el flujo de tramitacin
			if (usuario.equals(tramitePersistente.getUsuarioFlujoTramitacion())) return;
			//	Usuario es el que tenia antes el flujo de tramitacin
			if (usuarioFlujoAnterior != null && usuario.equals(usuarioFlujoAnterior)) return;
			// Usuario es delegado de la entidad
			PersonaPAD p = DelegateUtil.getConsultaPADDelegate().obtenerDatosPADporUsuarioSeycon(tramitePersistente.getUsuario());
			String permisos = DelegateUtil.getDelegacionDelegate().obtenerPermisosDelegacion(p.getNif());
			if (StringUtils.isNotEmpty(permisos)) return;
			
		}else{
			if (plgLogin.getMetodoAutenticacion(sp) == 'A') return;
		}
		
		throw new HibernateException("Acceso no permitido al tramite " + tramitePersistente.getIdPersistencia() + " - Usuario: " + usuario);
	}
    
}