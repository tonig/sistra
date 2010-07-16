package es.caib.sistra.plugins.firma;

import java.io.Serializable;

/**
 *  Datos de una firma digital 
 */
public interface FirmaIntf extends Serializable{
	
	/**
	 * Obtiene el nif/cif del firmante
	 * @return nif/cif del firmante
	 */
	public String getNif();
	
	/**
	 * Obtiene el nombre y apellidos del firmante
	 * @return nombre y apellidos del firmante
	 */
	public String getNombreApellidos();
	
	/**
	 * Obtiene el formato de la firma (dependerá del proveedor de firma)
	 * @return formato de la firma
	 */
	public String getFormatoFirma();
	
}
