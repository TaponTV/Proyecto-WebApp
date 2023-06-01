package models;

import java.io.*;

public class Especie implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int idEspecie;
    private String especie;

    public Especie() {

    }

    public Especie(String especie) {
        this.especie = especie;
    }

    public Especie(int idEspecie, String especie) {
        this.idEspecie = idEspecie;
        this.especie = especie;
    }

    public int getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

}
