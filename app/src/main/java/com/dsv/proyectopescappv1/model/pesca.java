package com.dsv.proyectopescappv1.model;

public class pesca {
    String Pez, Lugar , Fecha;
    public pesca(){}

    public pesca(String pez, String lugar, String fecha) {
        this.Pez = pez;
        this.Lugar = lugar;
        this.Fecha = fecha;
    }

    public String getPez() {
        return Pez;
    }

    public void setPez(String pez) {
        this.Pez = pez;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        this.Lugar = lugar;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        this.Fecha = fecha;
    }
}
