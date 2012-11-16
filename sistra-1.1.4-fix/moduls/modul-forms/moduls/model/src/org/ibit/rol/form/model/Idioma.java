package org.ibit.rol.form.model;

import java.io.Serializable;

/**
 * Representaci&oacute; d'un idioma.
 */
public class Idioma implements Serializable {

    public static final String DEFAULT = "es";

    private String lang;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    private int orden;

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
}