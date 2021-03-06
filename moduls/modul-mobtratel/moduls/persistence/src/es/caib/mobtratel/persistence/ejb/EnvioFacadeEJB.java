package es.caib.mobtratel.persistence.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.EJBException;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.Order;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.caib.mobtratel.model.CriteriosBusquedaEnvio;
import es.caib.mobtratel.model.Cuenta;
import es.caib.mobtratel.model.Envio;
import es.caib.mobtratel.model.EstadisticaSMS;
import es.caib.mobtratel.model.MensajeEmail;
import es.caib.mobtratel.model.MensajeSms;
import es.caib.mobtratel.model.Page;
import es.caib.mobtratel.model.Permiso;
import es.caib.mobtratel.modelInterfaz.ConstantesMobtratel;
import es.caib.mobtratel.persistence.delegate.DelegateUtil;
import es.caib.mobtratel.persistence.delegate.PermisoDelegate;
import es.caib.mobtratel.persistence.util.CacheProcesamiento;

/**
 * SessionBean para mantener y consultar Envios en la BBDD.
 *
 * @ejb.bean
 *  name="mobtratel/persistence/EnvioFacade"
 *  jndi-name="es.caib.mobtratel.persistence.EnvioFacade"
 *  type="Stateless"
 *  view-type="remote"
 *  transaction-type="Container"
 *
 * @ejb.transaction type="Required"
 */
public abstract class EnvioFacadeEJB extends HibernateEJB {

	protected static Log log = LogFactory.getLog(EnvioFacadeEJB.class);
	
    /**
     * @ejb.create-method
     * @ejb.permission role-name="${role.gestor},${role.admin},${role.auto}"
     */
    public void ejbCreate() throws CreateException {
        super.ejbCreate();
    }

    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.auto}"
     */
    public List listarPendientes() {
        Session session = getSession();
        Date now = new Date();
        try {
        	Query query = session.createQuery("FROM Envio AS e where ((e.fechaProgramacionEnvio <= :fechaActual) or e.fechaProgramacionEnvio is null) and e.fechaEnvio is null  " +
        			" and ((e.estado = " + ConstantesMobtratel.ESTADOENVIO_PENDIENTE + ") or (e.estado = " + ConstantesMobtratel.ESTADOENVIO_ERROR + ")  or (e.estado = " + ConstantesMobtratel.ESTADOENVIO_PROCESANDO + "))  " +
        			" ORDER BY e.fechaProgramacionEnvio DESC,e.codigo DESC");
            query.setParameter("fechaActual", now);            
            return query.list();
        } catch (HibernateException he) {
            throw new EJBException(he);
        } 
        finally 
        {
            close(session);
        }
    }
    
    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.auto}"
     */
    public List listarEmailsPendientesVerificar() {
        Session session = getSession();
        try {
        	Query query = session.createQuery("FROM MensajeEmail AS me " + 
        			" where me.estado = " + ConstantesMobtratel.ESTADOENVIO_ENVIADO + " and me.verificarEnvio = true and me.estadoVerificarEnvio is null");        			                      
            return query.list();
        } catch (HibernateException he) {
            throw new EJBException(he);
        } 
        finally 
        {
            close(session);
        }
    }
    
    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.auto}"
     */
    public List listarSmssPendientesVerificar() {
        Session session = getSession();
        try {
        	Query query = session.createQuery("FROM MensajeSms AS me " + 
        			" where me.estado = " + ConstantesMobtratel.ESTADOENVIO_ENVIADO + " and me.verificarEnvio = true and me.estadoVerificarEnvio is null");        			                      
            return query.list();
        } catch (HibernateException he) {
            throw new EJBException(he);
        } 
        finally 
        {
            close(session);
        }
    }
       
    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.auto}"
     */
    public List listarInmediatosPendientes() {
    	Session session = getSession();
        Date now = new Date();
        try {
        	Query query = session.createQuery("FROM Envio AS e where (e.inmediato = 1) and e.fechaEnvio is null " + 
        			" and ((e.estado = " + ConstantesMobtratel.ESTADOENVIO_PENDIENTE + ") or (e.estado = " + ConstantesMobtratel.ESTADOENVIO_ERROR + ")  or (e.estado = " + ConstantesMobtratel.ESTADOENVIO_PROCESANDO + "))  " +
        			" ORDER BY e.fechaProgramacionEnvio DESC");
            query.setParameter("fechaActual", now);            
            return query.list();
        } catch (HibernateException he) {
            throw new EJBException(he);
        } 
        finally 
        {
            close(session);
        }
    }
    
    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.gestor},${role.admin},${role.auto}"
     */
    public Envio obtenerEnvio(Long codigo) {
        Session session = getSession();
        try {
        	// Cargamos envio        	
        	Envio envio = (Envio) session.load(Envio.class, codigo);
        	return envio;
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
    public MensajeEmail obtenerMensajeEmail(Long codigo) {
        Session session = getSession();
        try {
        	// Cargamos envio        	
        	MensajeEmail envio = (MensajeEmail) session.load(MensajeEmail.class, codigo);
        	return envio;
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
    public MensajeSms obtenerMensajeSms(Long codigo) {
        Session session = getSession();
        try {
        	// Cargamos envio        	
        	MensajeSms envio = (MensajeSms) session.load(MensajeSms.class, codigo);
        	return envio;
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
    public void establecerEstadoVerificarMensajeEmail(Long codigo, String estado, String descError) {
        Session session = getSession();
        try {        	   
        	MensajeEmail envio = (MensajeEmail) session.load(MensajeEmail.class, codigo);
        	if (envio != null) { 
        		envio.setEstadoVerificarEnvio(estado);
        		envio.setErrorVerificarEnvio(descError);
        		session.update(envio);    
        	}        	
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
    public void establecerEstadoVerificarMensajeSms(Long codigo, String estado, String descError) {
        Session session = getSession();
        try {
        	MensajeSms envio = (MensajeSms) session.load(MensajeSms.class, codigo);
        	if (envio != null) { 
        		envio.setEstadoVerificarEnvio(estado);
        		envio.setErrorVerificarEnvio(descError);
        		session.update(envio);    
        	}        	
        } catch (HibernateException he) {
            throw new EJBException(he);
        } finally {
            close(session);
        }
    }
    
    
	/**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.gestor},${role.admin},${role.auto}"
     */
    public Long grabarEnvio(Envio obj) {        
    	Session session = getSession();
    	try {
    		if (obj.getCodigo() == null)
    			session.save(obj);
    		else
    			session.update(obj);        	
        	return obj.getCodigo();            
        } catch (HibernateException he) {
            throw new EJBException(he);
        } finally {
        	close(session);
        }
    }  
    
    /**
     * Cancelar envio desde el front. Comprueba que el envio no este bloqueado por proceso de envio.
     * 
     * @ejb.interface-method
     * @ejb.permission role-name="${role.gestor},${role.admin}"
     */
    public boolean cancelarEnvio(Long idEnvio) {        
    	Session session = getSession();
    	boolean locked=false;
    	try {
        	
    		if (!CacheProcesamiento.guardar(idEnvio.toString())){
    			return false;
    		}
    		locked = true;
    		
    		Envio envio = (Envio) session.load(Envio.class, idEnvio);
    		
    		// El envio no puede cancelarse si ya esta enviado o esta cancelado
    		if (envio.getEstado() == ConstantesMobtratel.ESTADOENVIO_ENVIADO || envio.getEstado() == ConstantesMobtratel.ESTADOENVIO_CANCELADO ){
    			throw new HibernateException("El envio esta en estado " + envio.getEstado() + ". No puede cancelarse.");
    		}
    		
    		envio.setEstado(ConstantesMobtratel.ESTADOENVIO_CANCELADO);
    		session.update(envio);
        	return true;            
        } catch (HibernateException he) {
            throw new EJBException(he);
        } finally {
        	if (locked) CacheProcesamiento.borrar(idEnvio.toString());
        	close(session);
        }
    }  

    
	/**
	 * Comprueba si un envio se esta enviando
	 * 
     * @ejb.interface-method
     * @ejb.permission role-name="${role.gestor},${role.admin}"
     */
	public boolean isEnviando(Long idEnvio){
		return CacheProcesamiento.existe(idEnvio.toString());
	}
	
    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.gestor},${role.admin}"
     */
    public Page busquedaPaginadaEnvios( CriteriosBusquedaEnvio criteriosBusqueda, int pagina, int longitudPagina )
    {
    	
    	try{
	    	// Obtenemos datos gestor por Usuario Seycon
	    	PermisoDelegate gd = DelegateUtil.getPermisoDelegate();
	    	List permisos = gd.listarPermisos(this.ctx.getCallerPrincipal().getName());
	    	if (permisos.size() == 0) throw new Exception("No se encuentra gestor para usuario seycon " + this.ctx.getCallerPrincipal().getName());
    	}catch (Exception he) 
		{
	        throw new EJBException(he);
	    } 

    	    	
    	// Es posible que haya que sustituir Criteria por Query, con la from clause construida de forma dinámica
    	// Seria necesario si en la paginacion se necesita saber el numero maximo de paginas para 
		Session session = getSession();
		try 
		{			
			Criteria criteria =createCriteriaFromCriteriosBusquedaEnvio(criteriosBusqueda,session);	
			Page page = new Page( criteria, pagina, longitudPagina );
			
			/*
			Query q =createQueryFromCriteriosBusquedaTramite(criteriosBusqueda,session);			
			Page page = new Page( q, pagina, longitudPagina );					
			*/
			
			if(page.getList().size() == 0) return null;
			
			return page;
			
	    } 
		catch (Exception he) 
		{
	        throw new EJBException(he);
	    } 
		finally 
	    {
	        close(session);
	    }
    }     
    
    
    /**
     * @ejb.interface-method
     * @ejb.permission role-name="${role.gestor}"
     */
    public List obtenerEstadisticasSMS(int anyo, String cuentaId) {
    	Session session = getSession();
        try {
        	
        	boolean filtroCuenta = StringUtils.isNotBlank(cuentaId) && !"T".equals(cuentaId);
        	
        	String sqlSelect = "SELECT to_char(s.envio.fechaRegistro,'MM'), s.envio.cuenta.codigo, s.envio.idProcedimiento, sum(s.numeroDestinatariosEnviados) ";
        	String sqlFrom = " FROM MensajeSms s ";
        	String sqlWhere = " WHERE s.envio.fechaRegistro is not null and to_char(s.envio.fechaRegistro,'YYYY') = :anyo ";	        	
        	String sqlGroupBy = " GROUP BY to_char(s.envio.fechaRegistro,'MM'), s.envio.cuenta.codigo, s.envio.idProcedimiento ";
        	String sqlOrderBy = " ORDER BY 1";
        	
        	if (filtroCuenta) {
        		sqlWhere += " and s.envio.cuenta.codigo = :cuenta";
        	}
        	
        	Query query = session.createQuery(sqlSelect + sqlFrom + sqlWhere + sqlGroupBy + sqlOrderBy) ;
            query.setParameter("anyo", ""+ anyo);
            
            if (filtroCuenta) {
            	query.setParameter("cuenta", cuentaId);
        	}
            
            List result = query.list();
            List estadisticas = new ArrayList();
            for (Iterator it = result.iterator(); it.hasNext();) {
            	Object[] row = (Object[]) it.next();
            	EstadisticaSMS e = new EstadisticaSMS();
            	e.setAnyo(anyo);
            	e.setMes(Integer.parseInt( (String) row[0]));
            	e.setCuenta((String) row[1]);
            	e.setIdProcedimiento((String) row[2]);
            	e.setSms(Integer.parseInt(row[3].toString()));
            	estadisticas.add(e);
            }            
            return estadisticas;
        } catch (HibernateException he) {
            throw new EJBException(he);
        } 
        finally 
        {
            close(session);
        }
    }

	
    private Criteria createCriteriaFromCriteriosBusquedaEnvio(CriteriosBusquedaEnvio criteriosBusqueda,Session session) throws Exception{
    	    	    
    	// Obtenemos cuentas accesibles por gestor
    	List cuentasAccesibles = new ArrayList();
    	try{	    	
    		PermisoDelegate gd = DelegateUtil.getPermisoDelegate();
	    	List permisos = gd.listarPermisos(this.ctx.getCallerPrincipal().getName());
	    	if (permisos.size() == 0) throw new Exception("No se encuentra gestor para usuario seycon " + this.ctx.getCallerPrincipal().getName());
	    	
	    	
	    	for (Iterator it = permisos.iterator();it.hasNext();){
	    		Permiso per =  (Permiso) it.next();
	    		cuentasAccesibles.add(per.getCuenta());
	    	}
	    	
    	}catch (Exception he) 
		{
	        throw new EJBException(he);
	    }
    	
    	Criteria criteria = session.createCriteria( Envio.class );
    	criteria.setCacheable( false );
 
		 //Especificamos estado procesamiento entrada
		 if ( !criteriosBusqueda.getEnviado().equals(CriteriosBusquedaEnvio.TODOS)  )
		 {
			 if (criteriosBusqueda.getEnviado().equals(String.valueOf(ConstantesMobtratel.ESTADOENVIO_ENVIADO))  )
				 criteria.add( Expression.eq( "estado" , new Integer(ConstantesMobtratel.ESTADOENVIO_ENVIADO) ) );
			 if (criteriosBusqueda.getEnviado().equals(String.valueOf(ConstantesMobtratel.ESTADOENVIO_CANCELADO))  )
				 criteria.add( Expression.eq( "estado" , new Integer(ConstantesMobtratel.ESTADOENVIO_CANCELADO)) );
			 if (criteriosBusqueda.getEnviado().equals(String.valueOf(ConstantesMobtratel.ESTADOENVIO_ERROR))  )
				 criteria.add( Expression.eq( "estado", new Integer(ConstantesMobtratel.ESTADOENVIO_ERROR) ) );
			 if (criteriosBusqueda.getEnviado().equals(String.valueOf(ConstantesMobtratel.ESTADOENVIO_PENDIENTE))  )
				 criteria.add( Expression.eq( "estado", new Integer(ConstantesMobtratel.ESTADOENVIO_PENDIENTE) ) );				 
		 }
		
		 // Especificamos cuenta particular 
		 if ( !criteriosBusqueda.getCuenta().equals(CriteriosBusquedaEnvio.TODOS)) 
		 {
			 Cuenta cuenta = (Cuenta) session.load(Cuenta.class,criteriosBusqueda.getCuenta());
			 criteria.add( Expression.eq("cuenta", cuenta ) );
		 }else{
		 // Especificamos cuentas a las que tiene acceso
			criteria.add(Expression.in("cuenta",cuentasAccesibles)); 
		 }
		 
		 // Especificamos fecha
		 if ( criteriosBusqueda.getAnyo() != 0 )
		 {
			 GregorianCalendar gregorianCalendar1 = null;
			 GregorianCalendar gregorianCalendar2 = null;
			 if ( criteriosBusqueda.getMes() == -1 )
			 {
			 	 gregorianCalendar1 = new GregorianCalendar( criteriosBusqueda.getAnyo(), 0, 1 );
			 	 gregorianCalendar2 = new GregorianCalendar( criteriosBusqueda.getAnyo(), 11, 31 );
			 }
			 else
			 {
				 gregorianCalendar1 = new GregorianCalendar( criteriosBusqueda.getAnyo(), criteriosBusqueda.getMes(), 1 );
				 int year =  criteriosBusqueda.getAnyo();
				 int month = criteriosBusqueda.getMes();
				 gregorianCalendar2 = new GregorianCalendar( year, month, gregorianCalendar1.getMaximum( GregorianCalendar.DAY_OF_MONTH ) );
			 }
			 criteria.add( Expression.between( "fechaRegistro", new java.sql.Date(gregorianCalendar1.getTime().getTime()), new java.sql.Date( gregorianCalendar2.getTime().getTime() )) );
		 }
		
		 // Ordenación
		 criteria.addOrder( Order.desc("fechaRegistro") );
		 return criteria;
    }    
    
}