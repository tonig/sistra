package es.caib.zonaper.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import es.caib.zonaper.modelInterfaz.ConstantesZPE;

public class Expediente implements Serializable 
{
	
	// TIPO EXPEDIENTE
	public final static String TIPO_EXPEDIENTE_VIRTUAL = "V";
	public final static String TIPO_EXPEDIENTE_REAL = "E";
	
	private Long codigo;
	private String tipoExpediente;
	private String idExpediente;
	private String claveExpediente;
	private String idProcedimiento;
	private String idioma;
	private Timestamp fecha;
	private Timestamp fechaConsulta;
	private String descripcion;
	private String seyconCiudadano;
	private String nifRepresentante;
	private String nifRepresentado;
	private String nombreRepresentado;
	private String usuarioSeycon;
	private Long unidadAdministrativa;
	private String numeroEntradaBTE;	
	
	// Opciones de aviso movilidad
	private String habilitarAvisos;
	private String avisoSMS;
	private String avisoEmail;
	
	// Campos calculados a partir de los elementos
	private Date fechaInicio;
	private Date fechaFin;
	private String estado;
	
	private Set elementos = new HashSet(0);
	
	public Long getCodigo()
	{
		return codigo;
	}
	public void setCodigo(Long codigo)
	{
		this.codigo = codigo;
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	public String getIdExpediente()
	{
		return idExpediente;
	}
	public void setIdExpediente(String idExpediente)
	{
		this.idExpediente = idExpediente;
	}
	public String getSeyconCiudadano()
	{
		return seyconCiudadano;
	}
	public void setSeyconCiudadano(String seyconCiudadano)
	{
		this.seyconCiudadano = seyconCiudadano;
	}
	public Timestamp getFecha()
	{
		return fecha;
	}
	public void setFecha(Timestamp fecha)
	{
		this.fecha = fecha;
	}	
	public String getUsuarioSeycon()
	{
		return usuarioSeycon;
	}
	public void setUsuarioSeycon(String usuarioSeycon)
	{
		this.usuarioSeycon = usuarioSeycon;
	}
	public Long getUnidadAdministrativa()
	{
		return unidadAdministrativa;
	}
	public void setUnidadAdministrativa(Long unidadAdministrativa)
	{
		this.unidadAdministrativa = unidadAdministrativa;
	}
	public Timestamp getFechaConsulta()
	{
		return fechaConsulta;
	}
	public void setFechaConsulta(Timestamp fechaConsulta)
	{
		this.fechaConsulta = fechaConsulta;
	}
	public String getClaveExpediente() {
		return claveExpediente;
	}
	public void setClaveExpediente(String claveExpediente) {
		this.claveExpediente = claveExpediente;
	}
	public String getNumeroEntradaBTE() {
		return numeroEntradaBTE;
	}
	public void setNumeroEntradaBTE(String numeroEntradaBTE) {
		this.numeroEntradaBTE = numeroEntradaBTE;
	}

	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public Set getElementos() {
		return elementos;
	}
	public void setElementos(Set elementos) {
		this.elementos = elementos;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public void addElementoExpediente(ElementoExpediente e, ElementoExpedienteItf obj){
		// A�adimos a lista de elementos
		e.setExpediente(this);
		getElementos().add(e);
		
		// Actualizamos expediente: estado y fecha inicio/fin
		if (e.getTipoElemento().equals(ElementoExpediente.TIPO_ENTRADA_TELEMATICA)){
			setEstado(ConstantesZPE.ESTADO_SOLICITUD_ENVIADA);
		}else if (e.getTipoElemento().equals(ElementoExpediente.TIPO_ENTRADA_PREREGISTRO)){
			if ( ((EntradaPreregistro) obj).getFechaConfirmacion() != null){ 
			setEstado(ConstantesZPE.ESTADO_SOLICITUD_ENVIADA);
			}else{
				setEstado(ConstantesZPE.ESTADO_SOLICITUD_ENVIADA_PENDIENTE_DOCUMENTACION_PRESENCIAL);
			}
		}else if (e.getTipoElemento().equals(ElementoExpediente.TIPO_AVISO_EXPEDIENTE)){			
			setEstado(ConstantesZPE.ESTADO_AVISO_PENDIENTE);
		}else if (e.getTipoElemento().equals(ElementoExpediente.TIPO_NOTIFICACION)){
			setEstado(ConstantesZPE.ESTADO_NOTIFICACION_PENDIENTE);							
		}
		if (getElementos().size() == 1) this.setFechaInicio(e.getFecha());
		setFechaFin(e.getFecha());
		
		// Ponemos fecha expediente a fecha fin
		setFecha(new Timestamp(getFechaFin().getTime()));
	}
	
	public String getNifRepresentado() {
		return nifRepresentado;
	}
	public void setNifRepresentado(String nifRepresentado) {
		this.nifRepresentado = nifRepresentado;
	}
	public String getNombreRepresentado() {
		return nombreRepresentado;
	}
	public void setNombreRepresentado(String nombreRepresentado) {
		this.nombreRepresentado = nombreRepresentado;
	}
	public String getAvisoEmail() {
		return avisoEmail;
	}
	public void setAvisoEmail(String avisoEmail) {
		this.avisoEmail = avisoEmail;
	}
	public String getAvisoSMS() {
		return avisoSMS;
	}
	public void setAvisoSMS(String avisoSMS) {
		this.avisoSMS = avisoSMS;
	}
	public String getHabilitarAvisos() {
		return habilitarAvisos;
	}
	public void setHabilitarAvisos(String habilitarAvisos) {
		this.habilitarAvisos = habilitarAvisos;
	}
	public String getNifRepresentante() {
		return nifRepresentante;
	}
	public void setNifRepresentante(String nifRepresentante) {
		this.nifRepresentante = nifRepresentante;
	}
	public String getIdProcedimiento() {
		return idProcedimiento;
	}
	public void setIdProcedimiento(String idProcedimiento) {
		this.idProcedimiento = idProcedimiento;
	}
	public String getTipoExpediente() {
		return tipoExpediente;
	}
	public void setTipoExpediente(String tipoExpediente) {
		this.tipoExpediente = tipoExpediente;
	}
		
	/**
	 * Obtiene elemento expediente.
	 * @param tipo Tipo
	 * @param codigo Codigo
	 * @return elemento
	 */
	public ElementoExpediente obtenerElementoExpediente(String tipo, Long codigo) {
		ElementoExpediente res = null;
		for (Iterator it = getElementos().iterator(); it.hasNext();) {
			ElementoExpediente e = (ElementoExpediente) it.next();
			if (e.getTipoElemento().equals(tipo) && e.getCodigoElemento().longValue() == codigo.longValue()) {
				res = e;
				break;
			}
		}
		return res;
	}
}
