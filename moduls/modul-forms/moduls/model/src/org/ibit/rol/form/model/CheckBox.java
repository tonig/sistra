package org.ibit.rol.form.model;

public class CheckBox extends Campo {

    public CheckBox() {
        tipoValor = "java.lang.Boolean";
        this.setColSpan(6); // Maximo colspan
    }

    public boolean isIndexed() {
        return false;
    }

    public boolean valorDefecto;

    public boolean isValorDefecto() {
        return valorDefecto;
    }

    public void setValorDefecto(boolean valorDefecto) {
        this.valorDefecto = valorDefecto;
    }
}
