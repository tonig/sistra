package es.caib.zonaper.model;
//TODO: Cambiar PK para que no tire de secuencia (o bien generar PK que sea A�O + secuencia ciclica) 
public class DocumentoPersistente implements java.io.Serializable {

	// Fields    	
     private Long codigo;
     private TramitePersistente tramitePersistente;
     private String identificador;
     private int numeroInstancia=1;
     private char estado;
     private Long rdsCodigo;
     private String rdsClave;
     private String nombreFicheroAnexo;
     private String descripcionGenerico;
     private String delegacionEstado;
     private String delegacionFirmantes;
     private String delegacionFirmantesPendientes; 
     
     private String tipoDocumento;
     private String esPagoTelematico;

    // Constructors
    /** default constructor */
    public DocumentoPersistente() {
    }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombreFicheroAnexo() {
		return nombreFicheroAnexo;
	}

	public void setNombreFicheroAnexo(String nombreFicheroAnexo) {
		this.nombreFicheroAnexo = nombreFicheroAnexo;
	}

	public int getNumeroInstancia() {
		return numeroInstancia;
	}

	public void setNumeroInstancia(int numeroInstancia) {
		this.numeroInstancia = numeroInstancia;
	}

	public String getRdsClave() {
		return rdsClave;
	}

	public void setRdsClave(String rdsClave) {
		this.rdsClave = rdsClave;
	}

	public Long getRdsCodigo() {
		return rdsCodigo;
	}

	public void setRdsCodigo(Long rdsCodigo) {
		this.rdsCodigo = rdsCodigo;
	}

	public TramitePersistente getTramitePersistente() {
		return tramitePersistente;
	}

	public void setTramitePersistente(TramitePersistente tramitePersistente) {
		this.tramitePersistente = tramitePersistente;
	}

	public String getDescripcionGenerico() {
		return descripcionGenerico;
	}

	public void setDescripcionGenerico(String descripcionGenerico) {
		this.descripcionGenerico = descripcionGenerico;
	}

	public String getDelegacionEstado() {
		return delegacionEstado;
	}

	public void setDelegacionEstado(String delegacionEstado) {
		this.delegacionEstado = delegacionEstado;
	}

	public String getDelegacionFirmantes() {
		return delegacionFirmantes;
	}

	public void setDelegacionFirmantes(String delegacionFirmantes) {
		this.delegacionFirmantes = delegacionFirmantes;
	}

	public String getDelegacionFirmantesPendientes() {
		return delegacionFirmantesPendientes;
	}

	public void setDelegacionFirmantesPendientes(
			String delegacionFirmantesPendientes) {
		this.delegacionFirmantesPendientes = delegacionFirmantesPendientes;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getEsPagoTelematico() {
		return esPagoTelematico;
	}

	public void setEsPagoTelematico(String esPagoTelematico) {
		this.esPagoTelematico = esPagoTelematico;
	}


    
	
	

}
