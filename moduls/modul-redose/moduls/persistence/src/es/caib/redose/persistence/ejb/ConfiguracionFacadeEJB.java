package es.caib.redose.persistence.ejb;

import java.util.Properties;

import javax.ejb.CreateException;
import javax.ejb.EJBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.caib.redose.persistence.util.ConfigurationUtil;
import es.caib.redose.model.OrganismoInfo;

/**
 * EJB que sirve para obtener la configuracion del modulo
 *
 * @ejb.bean
 *  name="redose/persistence/ConfiguracionFacade"
 *  local-jndi-name = "es.caib.redose.persistence.ConfiguracionFacade"
 *  type="Stateless"
 *  view-type="local"
 */
public abstract class ConfiguracionFacadeEJB extends HibernateEJB  {
	
	protected static Log log = LogFactory.getLog(ConfiguracionFacadeEJB.class);
	
	/**
     * @ejb.create-method
     * @ejb.permission unchecked = "true"
     */
	public void ejbCreate() throws CreateException {
		super.ejbCreate();
	}
	
	
	/**
	 * 
	 * Recibe formularios y obtiene lista de documentos
	 * 
     * @ejb.interface-method
     * @ejb.permission unchecked = "true"
     */
    public Properties obtenerPropiedades() {
    	try{
    		return ConfigurationUtil.getInstance().obtenerPropiedades();
    	}catch(Exception ex){
    		throw new EJBException(ex);
    	}         
    }
    
    /**
	 * 
	 * Obtiene las propiedades de configuracion referentes al organismo y las empaqueta en 
	 * una clase de modelo
	 * 
     * @ejb.interface-method
     * @ejb.permission unchecked = "true"
     */
    public OrganismoInfo obtenerOrganismoInfo() {
    	try{
    		Properties props = ConfigurationUtil.getInstance().obtenerPropiedades();
    		OrganismoInfo oi = new  OrganismoInfo();
    		oi.setNombre(props.getProperty("organismo.nombre"));
    		oi.setUrlLogo(props.getProperty("organismo.logo"));
    		oi.setUrlPortal(props.getProperty("organismo.portal.url"));
    		oi.setPieContactoHTML(props.getProperty("organismo.footer.contacto"));
    		oi.setTelefonoIncidencias(props.getProperty("organismo.soporteTecnico.telefono"));
    		oi.setUrlSoporteIncidencias(props.getProperty("organismo.soporteTecnico.url"));
    		oi.setEmailSoporteIncidencias(props.getProperty("organismo.soporteTecnico.email")); 
    		oi.setUrlCssCustom(props.getProperty("organismo.cssCustom"));
    		return oi;
    	}catch(Exception ex){
    		throw new EJBException(ex);
    	}         
    }

}
