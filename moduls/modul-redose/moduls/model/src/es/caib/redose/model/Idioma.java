package es.caib.redose.model;
// Generated 07-mar-2006 18:19:33 by Hibernate Tools 3.1.0 beta3


/**
 * Idioma generated by hbm2java
 */

public class Idioma  implements java.io.Serializable 
{
	
    public static final String DEFAULT = "es";

    // Fields    

     private String codigo;
     private String nombre;


    // Constructors

    /** default constructor */
    public Idioma() {
    }

   
    // Property accessors

    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String idiCodigo) {
        this.codigo = idiCodigo;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String idiNombre) {
        this.nombre = idiNombre;
    }

}
