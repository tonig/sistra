package es.caib.zonaper.model;
//TODO: Cambiar PK para que no tire de secuencia (o bien generar PK que sea A�O + secuencia ciclica) 
public class DocumentoPersistente implements java.io.Serializable {

	public final static char ESTADO_CORRECTO = 'S';
	public final static char ESTADO_INCORRECTO = 'N';
	
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


    
	
	

}