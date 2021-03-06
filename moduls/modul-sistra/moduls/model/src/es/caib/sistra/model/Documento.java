package es.caib.sistra.model;
// Generated 21-mar-2006 11:41:40 by Hibernate Tools 3.1.0 beta3

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * StrDocum generated by hbm2java
 */

public class Documento  extends Traducible {
	
	public final static char TIPO_FORMULARIO = 'F';
	 public final static char TIPO_ANEXO = 'A';
	 public final static char TIPO_PAGO = 'P';

    // Fields    
     private Long codigo;
     private TramiteVersion tramiteVersion;
     private String identificador;
     private Long idPad;
     private String modelo;
     private char generico='N';
     private int maxGenericos;     
     private char tipo='F';
     private int orden;
     private char formularioPreregistro='N';
     private char formularioJustificante='N';   
     private char formularioAnexarJustificante='S';     
     private char anexoPresentarTelematicamente='S';
     private String anexoExtensiones;
     private Integer anexoTamanyoMax;
     private String anexoUrlPlantilla;
     private char anexoDescargarPlantilla='N';
     private char anexoCompulsarPreregistro='N';
     private char anexoFotocopia='N';
     private char anexoConversionPDF='N';
     
     private Set niveles = new HashSet(0);
     // private Map niveles = new HashMap(0);
     

    // Constructors
    /** default constructor */
    public Documento() {
    }


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public char getGenerico() {
		return generico;
	}


	public void setGenerico(char generico) {
		this.generico = generico;
	}


	public String getIdentificador() {
		return identificador;
	}


	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}


	public Long getIdPad() {
		return idPad;
	}


	public void setIdPad(Long idPad) {
		this.idPad = idPad;
	}


	public int getMaxGenericos() {
		return maxGenericos;
	}


	public void setMaxGenericos(int maxGenericos) {
		this.maxGenericos = maxGenericos;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public TramiteVersion getTramiteVersion() {
		return tramiteVersion;
	}


	public void setTramiteVersion(TramiteVersion tramiteVersion) {
		this.tramiteVersion = tramiteVersion;
	}


    public void addTraduccion(String lang, TraDocumento traduccion) {
        setTraduccion(lang, traduccion);
    }


	public static char getTIPO_ANEXO() {
		return TIPO_ANEXO;
	}


	public static char getTIPO_FORMULARIO() {
		return TIPO_FORMULARIO;
	}


	public static char getTIPO_PAGO() {
		return TIPO_PAGO;
	}


	public char getAnexoCompulsarPreregistro() {
		return anexoCompulsarPreregistro;
	}


	public void setAnexoCompulsarPreregistro(char anexoCompulsarPreregistro) {
		this.anexoCompulsarPreregistro = anexoCompulsarPreregistro;
	}


	public char getAnexoDescargarPlantilla() {
		return anexoDescargarPlantilla;
	}


	public void setAnexoDescargarPlantilla(char anexoDescargarPlantilla) {
		this.anexoDescargarPlantilla = anexoDescargarPlantilla;
	}


	public String getAnexoExtensiones() {
		return anexoExtensiones;
	}


	public void setAnexoExtensiones(String anexoExtensiones) {
		this.anexoExtensiones = anexoExtensiones;
	}


	public char getAnexoFotocopia() {
		return anexoFotocopia;
	}


	public void setAnexoFotocopia(char anexoFotocopia) {
		this.anexoFotocopia = anexoFotocopia;
	}


	public Integer getAnexoTamanyoMax() {
		return anexoTamanyoMax;
	}


	public void setAnexoTamanyoMax(Integer anexoTamanyoMax) {
		this.anexoTamanyoMax = anexoTamanyoMax;
	}


	public String getAnexoUrlPlantilla() {
		return anexoUrlPlantilla;
	}


	public void setAnexoUrlPlantilla(String anexoUrlPlantilla) {
		this.anexoUrlPlantilla = anexoUrlPlantilla;
	}


	public char getFormularioPreregistro() {
		return formularioPreregistro;
	}


	public void setFormularioPreregistro(char formularioPreregistro) {
		this.formularioPreregistro = formularioPreregistro;
	}


	public char getTipo() {
		return tipo;
	}


	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	public DocumentoNivel getDocumentoNivel(char nivel) {
		// Buscamos documento que tenga especificado el nivel
		for (Iterator it=niveles.iterator();it.hasNext();){
			DocumentoNivel dn = (DocumentoNivel) it.next();
			if (dn.getNivelAutenticacion().indexOf(nivel) != -1) return dn;
		}		
		return null;
 	}


	public Set getNiveles() {
		return niveles;
	}


	public void setNiveles(Set niveles) {
		this.niveles = niveles;
	}
    
	/**
	 * Por compatibilidad con betwixt
	 * @param doc
	 */
	
	public void addNivele(DocumentoNivel doc) { 
		addDocumentoNivel( doc );
    }
		
	public void addDocumentoNivel(DocumentoNivel doc) { 
		doc.setDocumento(this);		
    	niveles.add(doc);
    }

    public void removeDocumentoNivel(DocumentoNivel doc) {    	
    	niveles.remove(doc);    	
    }	
	        
	public void setCurrentLang(String currentLang) {
        super.setCurrentLang(currentLang);        
        for (Iterator iterator = niveles.iterator();iterator.hasNext();) {        	        
        	DocumentoNivel documentoNivel = (DocumentoNivel) iterator.next();
        	documentoNivel.setCurrentLang(currentLang);
        }        
    }


	public int getOrden() {
		return orden;
	}


	public void setOrden(int orden) {
		this.orden = orden;
	}


	public char getAnexoPresentarTelematicamente() {
		return anexoPresentarTelematicamente;
	}


	public void setAnexoPresentarTelematicamente(char anexoPresentarTelematicamente) {
		this.anexoPresentarTelematicamente = anexoPresentarTelematicamente;
	}


	public char getFormularioJustificante() {
		return formularioJustificante;
	}


	public void setFormularioJustificante(char formularioJustificante) {
		this.formularioJustificante = formularioJustificante;
	}
	

	public char getAnexoConversionPDF() {
		return anexoConversionPDF;
	}


	public void setAnexoConversionPDF(char anexoConversionPDF) {
		this.anexoConversionPDF = anexoConversionPDF;
	}
	
	public char getFormularioAnexarJustificante() {
		return formularioAnexarJustificante;
	}


	public void setFormularioAnexarJustificante(char formularioAnexarJustificante) {
		this.formularioAnexarJustificante = formularioAnexarJustificante;
	}
	
	/*
	 
	public Set getNiveles() {
		return niveles;
	}

	public void setNiveles(Set niveles) {
		this.niveles = niveles;
	}

	
	public void addDocumentoNivel(DocumentoNivel doc) {    	
    	doc.setDocumento(this);
    	niveles.add(doc);
    }

    public void removeDocumentoNivel(DocumentoNivel doc) {    	
    	niveles.remove(doc);    	
    }	
	        
	public void setCurrentLang(String currentLang) {
        super.setCurrentLang(currentLang);        
        for (Iterator iterator = niveles.iterator();iterator.hasNext();) {
        	DocumentoNivel documentoNivel = (DocumentoNivel) iterator.next();
        	documentoNivel.setCurrentLang(currentLang);
        }        
    }
	 */
}
