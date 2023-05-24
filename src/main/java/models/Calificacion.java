package models;

import java.io.*;

public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idVeterinario;
    private int idCliente;
    private int idPrivacidad;
    private int calificacion;
    private String comentario;

    public Calificacion() {

    }

    public Calificacion(String idVeterinario, int idCliente, int idPrivacidad, int calificacion, String comentario) {
        this.idVeterinario = idVeterinario;
        this.idCliente = idCliente;
        this.idPrivacidad = idPrivacidad;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public String getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(String idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPrivacidad() {
        return idPrivacidad;
    }

    public void setIdPrivacidad(int idPrivacidad) {
        this.idPrivacidad = idPrivacidad;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "idVeterinario: " + idVeterinario + "\nComentario: " + comentario;
    }

}
