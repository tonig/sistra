package es.caib.redose.model;
// Generated 07-mar-2006 18:19:33 by Hibernate Tools 3.1.0 beta3


/**
 * Ubicacion generated by hbm2java
 */

public class Ubicacion  implements java.io.Serializable {


    // Fields    

     private Long codigo;
     private String codigoUbicacion;
     private String nombre;
     private String pluginAlmacenamiento;


    // Constructors

    /** default constructor */
    public Ubicacion() {
    }

   
    // Property accessors

    public Long getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Long ubiCodigo) {
        this.codigo = ubiCodigo;
    }

    public String getCodigoUbicacion() {
        return this.codigoUbicacion;
    }
    
    public void setCodigoUbicacion(String ubiIdent) {
        this.codigoUbicacion = ubiIdent;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String ubiNombre) {
        this.nombre = ubiNombre;
    }

    public String getPluginAlmacenamiento() {
        return this.pluginAlmacenamiento;
    }
    
    public void setPluginAlmacenamiento(String ubiPlugin) {
        this.pluginAlmacenamiento = ubiPlugin;
    }
   








}
