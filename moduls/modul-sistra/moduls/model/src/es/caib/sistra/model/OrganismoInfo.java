package es.caib.sistra.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que modela la info de un organismo y permite 
 * customizar la presentación de los módulos
 *
 */
public class OrganismoInfo {

	private String nombre;
	private String urlLogo;
	private String urlLoginLogo;
	private String urlPortal;
	private String pieContactoHTML;
	private String telefonoIncidencias;
	private String urlSoporteIncidencias;
	private String emailSoporteIncidencias;
	private String urlCssCustom;
	private String urlLoginCssCustom;
	private Map tituloPortal = new HashMap(); // Titulos portal con el key como idioma
	private Map referenciaPortal = new HashMap(); // Referencias portal con el key como idioma
	
	
	public String getUrlCssCustom() {
		return urlCssCustom;
	}
	public void setUrlCssCustom(String urlCssCustom) {
		this.urlCssCustom = urlCssCustom;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPieContactoHTML() {
		return pieContactoHTML;
	}
	public void setPieContactoHTML(String pieContactoHTML) {
		this.pieContactoHTML = pieContactoHTML;
	}
	public String getTelefonoIncidencias() {
		return telefonoIncidencias;
	}
	public void setTelefonoIncidencias(String telefonoIncidencias) {
		this.telefonoIncidencias = telefonoIncidencias;
	}
	public String getUrlLogo() {
		return urlLogo;
	}
	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}
	public String getUrlPortal() {
		return urlPortal;
	}
	public void setUrlPortal(String urlPortal) {
		this.urlPortal = urlPortal;
	}
	public String getUrlSoporteIncidencias() {
		return urlSoporteIncidencias;
	}
	public void setUrlSoporteIncidencias(String urlTramiteIncidencias) {
		this.urlSoporteIncidencias = urlTramiteIncidencias;
	}
	public Map getReferenciaPortal() {
		return referenciaPortal;
	}
	public void setReferenciaPortal(Map referenciasPortal) {
		this.referenciaPortal = referenciasPortal;
	}
	public Map getTituloPortal() {
		return tituloPortal;
	}
	public void setTituloPortal(Map tituloPortal) {
		this.tituloPortal = tituloPortal;
	}
	public String getEmailSoporteIncidencias() {
		return emailSoporteIncidencias;
	}
	public void setEmailSoporteIncidencias(String emailSoporteIncidencias) {
		this.emailSoporteIncidencias = emailSoporteIncidencias;
	}
	public String getUrlLoginLogo() {
		return urlLoginLogo;
	}
	public void setUrlLoginLogo(String urlLoginLogo) {
		this.urlLoginLogo = urlLoginLogo;
	}
	public String getUrlLoginCssCustom() {
		return urlLoginCssCustom;
	}
	public void setUrlLoginCssCustom(String urlLoginCssCustom) {
		this.urlLoginCssCustom = urlLoginCssCustom;
	}
	
}
