package es.caib.bantel.back.action;

import org.apache.struts.action.ActionFormBean;

/**
 * Extensi�n de la clase de configuraci�n de forms de Struts para
 * permitir indicar propiedades adicionales para formularios de
 * entidades traducidas.
 */
public class TraFormBeanConfig extends ActionFormBean {

    protected String valuesClassName;

    public String getValuesClassName() {
        return valuesClassName;
    }

    public void setValuesClassName(String valuesClassName) {
        if (configured) {
            throw new IllegalStateException("Configuration is frozen");
        }
        this.valuesClassName = valuesClassName;
    }
    
}