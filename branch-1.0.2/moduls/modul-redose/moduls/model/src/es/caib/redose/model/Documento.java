package es.caib.redose.model;
// Generated 07-mar-2006 18:19:34 by Hibernate Tools 3.1.0 beta3

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Documento generated by hbm2java
 */

public class Documento  implements java.io.Serializable {


    // Fields    

     private Long codigo;
     private Ubicacion ubicacion;
     private Version version;
     private String clave;
     private String titulo;     
     private Timestamp fecha;
     private String nif;
     private String usuarioSeycon;
     private Long unidadAdministrativa;
     private String nombreFichero;
     private String extensionFichero;
     private String hashFichero;
     private Set usos = new HashSet(0);
     private Set firmas = new HashSet(0);
     private Plantilla plantilla;
     private String borrado;


    // Constructors

    /** default constructor */
    public Documento() {
    }

	    
   
    // Property accessors

    public Long getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Long docCodi) {
        this.codigo = docCodi;
    }

    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(Ubicacion redoseUbica) {
        this.ubicacion = redoseUbica;
    }

    public Version getVersion() {
        return this.version;
    }
    
    public void setVersion(Version redoseVers) {
        this.version = redoseVers;
    }

    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String docClave) {
        this.clave = docClave;
    }

    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String docTitulo) {
        this.titulo = docTitulo;
    }

    public Timestamp getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Timestamp docFecha) {
        this.fecha = docFecha;
    }

    public String getNif() {
        return this.nif;
    }
    
    public void setNif(String docNif) {
        this.nif = docNif;
    }

    public Long getUnidadAdministrativa() {
        return this.unidadAdministrativa;
    }
    
    public void setUnidadAdministrativa(Long docUniadm) {
        this.unidadAdministrativa = docUniadm;
    }

    public String getNombreFichero() {
        return this.nombreFichero;
    }
    
    public void setNombreFichero(String docFicher) {
        this.nombreFichero = docFicher;
    }

    public String getExtensionFichero() {
        return this.extensionFichero;
    }
    
    public void setExtensionFichero(String docExt) {
        this.extensionFichero = docExt;
    }

    public String getHashFichero() {
        return this.hashFichero;
    }
    
    public void setHashFichero(String docHash) {
        this.hashFichero = docHash;
    }

    public Set getUsos() {
        return this.usos;
    }
    
    public void setUsos(Set redoseUsoses) {
        this.usos = redoseUsoses;
    }

    public Set getFirmas() {
        return this.firmas;
    }
    
    public void setFirmas(Set redoseFirmases) {
        this.firmas = redoseFirmases;
    }



	public String getUsuarioSeycon() {
		return usuarioSeycon;
	}

	public void setUsuarioSeycon(String usuarioSeycon) {
		this.usuarioSeycon = usuarioSeycon;
	}
	
	 public void addFirma(Firma firma){
    	firma.setDocumento(this);
    	firmas.add(firma);
    }
    
    public void removeFirma(Firma firma){    	
    	firmas.remove(firma);    	    
    }



	public Plantilla getPlantilla() {
		return plantilla;
	}



	public void setPlantilla(Plantilla plantilla) {
		this.plantilla = plantilla;
	}



	public String getBorrado() {
		return borrado;
	}



	public void setBorrado(String borrado) {
		this.borrado = borrado;
	}
   

}
