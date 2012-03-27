package es.caib.mobtratel.modelInterfaz;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * Clase que modeliza el estado de un Mensaje Envio Sms.
 * 
 */
public class EstadoMensajeEnvioSms implements Serializable{
	/**
	 * Estado (ver constantes).
	 */
	private int estado;
	/**
	 * Fecha inicio envio.
	 */
	private Date fechaInicioEnvio;
	/**
	 * Fecha fin envio.
	 */
	private Date fechaFinEnvio;
	/**
	 * Lista de destinatarios (telefonos).
	 */
	private String[] destinatarios;
	/**
	 * Lista de destinatarios a los que se ha enviado (telefonos).
	 */
	private String[] destinatariosEnviados;
	/**
	 * Verificaci�n env�os habilitada.
	 */
	private boolean verificacionEnvio;
	/**
	 * Estado de verificaci�n.
	 */
	private boolean estadoVerificacionEnvio;
	/**
	 * Si existe error verificaci�n indica el mensaje.
	 */
	private String errorVerificacionEnvio;
	
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Date getFechaInicioEnvio() {
		return fechaInicioEnvio;
	}
	public void setFechaInicioEnvio(Date fechaInicioEnvio) {
		this.fechaInicioEnvio = fechaInicioEnvio;
	}
	public Date getFechaFinEnvio() {
		return fechaFinEnvio;
	}
	public void setFechaFinEnvio(Date fechaFinEnvio) {
		this.fechaFinEnvio = fechaFinEnvio;
	}
	public String[] getDestinatarios() {
		return destinatarios;
	}
	public void setDestinatarios(String[] destinatarios) {
		this.destinatarios = destinatarios;
	}
	public String[] getDestinatariosEnviados() {
		return destinatariosEnviados;
	}
	public void setDestinatariosEnviados(String[] destinatariosEnviados) {
		this.destinatariosEnviados = destinatariosEnviados;
	}
	public boolean isVerificacionEnvio() {
		return verificacionEnvio;
	}
	public void setVerificacionEnvio(boolean habilitarVerificacionEnvio) {
		this.verificacionEnvio = habilitarVerificacionEnvio;
	}
	public boolean isEstadoVerificacionEnvio() {
		return estadoVerificacionEnvio;
	}
	public void setEstadoVerificacionEnvio(boolean estadoVerificacionEnvio) {
		this.estadoVerificacionEnvio = estadoVerificacionEnvio;
	}
	public String getErrorVerificacionEnvio() {
		return errorVerificacionEnvio;
	}
	public void setErrorVerificacionEnvio(String errorVerificacionEnvio) {
		this.errorVerificacionEnvio = errorVerificacionEnvio;
	}
	
	
}