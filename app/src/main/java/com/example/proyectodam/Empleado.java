package com.example.proyectodam;

public class Empleado {
    private  String HORA;
    private  String DIA;
    private  String TIPO;

    public Empleado(){

    }

    public Empleado(String HORA, String DIA, String TIPO) {
        this.HORA = HORA;
        this.DIA = DIA;
        this.TIPO = TIPO;
    }

    public String getHORA() {
        return HORA;
    }

    public void setHORA(String HORA) {
        this.HORA = HORA;
    }

    public String getDIA() {
        return DIA;
    }

    public void setDIA(String DIA) {
        this.DIA = DIA;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }
}
