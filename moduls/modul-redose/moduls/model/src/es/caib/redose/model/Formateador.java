package es.caib.redose.model;
// Generated 07-mar-2006 18:19:34 by Hibernate Tools 3.1.0 beta3

import java.util.Set;


/**
 * PlantillaTraducible generated by hbm2java
 */

public class Formateador  implements java.io.Serializable {

    // Fields    

     private Long identificador;
     private String clase;
     private String descripcion;

     // Constructors

    /** default constructor */
    public Formateador() {
    }

    public Formateador(Long identificador, String clase, String descripcion) {
		this.identificador = identificador;
		this.clase = clase;
		this.descripcion = descripcion;
	}

	
	public Formateador(Long identificador, String clase, String descripcion, Set plantillas) {
		this.identificador = identificador;
		this.clase = clase;
		this.descripcion = descripcion;
	}

	/** Getter and Setters**/

	public String getClase() {
		return clase;
	}



	public void setClase(String clase) {
		this.clase = clase;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Long getIdentificador() {
		return identificador;
	}



	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}



}
