package es.caib.zonaper.helpdesk.front.form;

import org.apache.struts.validator.ValidatorForm;

public class EstadoTramiteForm extends ValidatorForm
{
	private static final char TODOS = 'T';
		
	private String fecha;
	private String horaInicial;
	private String minInicial;
	private String horaFinal;
	private String minFinal;
	private String usuarioNif;
	private String clavePersistencia;
	private char nivelAutenticacion = TODOS;
	
	public String getClavePersistencia() {
		return clavePersistencia;
	}
	public void setClavePersistencia(String clavePersistencia) {
		this.clavePersistencia = clavePersistencia;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	public String getHoraInicial() {
		return horaInicial;
	}
	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}
	public char getNivelAutenticacion() {
		return nivelAutenticacion;
	}
	public void setNivelAutenticacion(char nivelAutenticacion) {
		this.nivelAutenticacion = nivelAutenticacion;
	}
	public String getUsuarioNif() {
		return usuarioNif;
	}
	public void setUsuarioNif(String usuarioNif) {
		this.usuarioNif = usuarioNif;
	}
	public String getMinFinal() {
		return minFinal;
	}
	public void setMinFinal(String minFinal) {
		this.minFinal = minFinal;
	}
	public String getMinInicial() {
		return minInicial;
	}
	public void setMinInicial(String minInicial) {
		this.minInicial = minInicial;
	}
	

}
