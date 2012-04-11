package es.caib.bantel.front.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import es.caib.bantel.front.util.Dominios;
import es.caib.bantel.front.util.MensajesUtil;
import es.caib.util.ValidacionesUtil;



public class DetalleExpedienteForm extends ValidatorForm
{
	private String numeroEntrada;
	private String identificadorExp;
	private String unidadAdm;
	private String claveExp;
	private String descripcion;
	private String idioma;
	private String usuarioSeycon;
	private String habilitarAvisos;
	private String email;
	private String movil;
	private String nombre;
	private String nif;
	private String nombreUnidad;
	/*tipo si el valor es A significa alta expediente, 
	 * si el valor es E alta expediente desde entrada*/
	private String tipo;
	private String flagValidacion;
	
	public String getClaveExp() {
		return claveExp;
	}

	public void setClaveExp(String claveExp) {
		this.claveExp = claveExp;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHabilitarAvisos() {
		return habilitarAvisos;
	}

	public void setHabilitarAvisos(String habilitarAvisos) {
		this.habilitarAvisos = habilitarAvisos;
	}

	public String getIdentificadorExp() {
		return identificadorExp;
	}

	public void setIdentificadorExp(String identificadorExp) {
		this.identificadorExp = identificadorExp;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidadAdm() {
		return unidadAdm;
	}

	public void setUnidadAdm(String unidadAdm) {
		this.unidadAdm = unidadAdm;
	}

	public String getUsuarioSeycon() {
		return usuarioSeycon;
	}

	public void setUsuarioSeycon(String usuarioSeycon) {
		this.usuarioSeycon = usuarioSeycon;
	}

	public String getNumeroEntrada() {
		return numeroEntrada;
	}

	public void setNumeroEntrada(String numeroEntrada) {
		this.numeroEntrada = numeroEntrada;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getFlagValidacion() {
		return flagValidacion;
	}

	public void setFlagValidacion(String flagValidacion) {
		this.flagValidacion = flagValidacion;
	}
	
	

	public String getNombreUnidad() {
		return nombreUnidad;
	}

	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}

	/**
	 * M�todo que valida el formulario. Solo se comprueban los casos en caso de la alta de expediente o cuando se selecciona que tipo de alta 
	 * se realizar�
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = super.validate(mapping, request);
        boolean error = false;
        if (errors == null) 
        {
            errors = new ActionErrors();
        }
        
        
        if("E".equals(tipo)){
        	if(StringUtils.isEmpty(numeroEntrada)){
        		errors.add("altaExpediente", new ActionError("errors.numeroEntrada.vacio"));
        	}
        }
        if(StringUtils.isNotEmpty(flagValidacion) && flagValidacion.equals("altaExpedient")){
        	if(StringUtils.isEmpty(identificadorExp)){
        		errors.add("altaExpediente", new ActionError("errors.required", MensajesUtil.getValue("confirmacion.identificadorExpediente")));
        		error = true;
        	}
        	if(StringUtils.isEmpty(unidadAdm)){
        		errors.add("altaExpediente", new ActionError("errors.required", MensajesUtil.getValue("confirmacion.unidadAdministrativa")));
        		error = true;
        	}
        	if(StringUtils.isEmpty(claveExp)){
        		errors.add("altaExpediente", new ActionError("errors.required", MensajesUtil.getValue("confirmacion.claveExpediente")));
        		error = true;
        	}
        	if(StringUtils.isEmpty(nif)){
    			errors.add("altaExpediente", new ActionError("errors.required", MensajesUtil.getValue("expediente.nif")));
        		error = true;
    		}
    		if(StringUtils.isEmpty(nombre)){
    			errors.add("altaExpediente", new ActionError("errors.required", MensajesUtil.getValue("expediente.nombre")));
        		error = true;
    		}
    		if(StringUtils.isEmpty(descripcion)){
        		errors.add("altaExpediente", new ActionError("errors.required", MensajesUtil.getValue("expediente.descripcion")));
        		error = true;
        	}
        	if(StringUtils.isNotEmpty(email) && !ValidacionesUtil.validarEmail(email)){
        		errors.add("altaExpediente", new ActionError("error.expediente.emailNOK"));
        		error = true;
        	}
        	if(StringUtils.isNotEmpty(movil) && !ValidacionesUtil.validarMovil(movil)){
        		errors.add("altaExpediente", new ActionError("error.expediente.movilNOK"));
        		error = true;
        	}
        }
        
        if(StringUtils.isNotEmpty(flagValidacion) && flagValidacion.equals("consulta")){
        	if(StringUtils.isEmpty(identificadorExp)){
        		errors.add("altaExpediente", new ActionError("errors.required", MensajesUtil.getValue("confirmacion.identificadorExpediente")));
        		error = true;
        	}
        	if(StringUtils.isEmpty(unidadAdm)){
        		errors.add("altaExpediente", new ActionError("errors.required", MensajesUtil.getValue("confirmacion.unidadAdministrativa")));
        		error = true;
        	}
        }
        if(error){
    		List unidades = new ArrayList();
			try {
				unidades = Dominios.listarUnidadesAdministrativas();
				
			} catch (Exception e) {}
			request.setAttribute("unidades",unidades);
    	}
        return errors;
    }

}