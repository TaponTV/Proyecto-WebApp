package models;

import java.io.*;

public class Vacunas implements Serializable{
    
    private int idMascota;
    private String vacuna;
    private String fecha;

    public Vacunas() {
        
    }

    public Vacunas(int idMascota, String vacuna, String fecha) {
        this.idMascota = idMascota;
        this.vacuna = vacuna;
        this.fecha = fecha;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
    
}
