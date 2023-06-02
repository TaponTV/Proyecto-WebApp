package models;

import java.io.*;

public class Receta implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int idConsulta;
    private String medicamento;
    private String tipoAdministracion;
    private String horario;
    private String detalles;

    public Receta() {

    }

    public Receta(int idConsulta, String medicamento, String tipoAdministracion, String horario, String detalles) {
        this.idConsulta = idConsulta;
        this.medicamento = medicamento;
        this.tipoAdministracion = tipoAdministracion;
        this.horario = horario;
        this.detalles = detalles;
    }

    public Receta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getTipoAdministracion() {
        return tipoAdministracion;
    }

    public void setTipoAdministracion(String tipoAdministracion) {
        this.tipoAdministracion = tipoAdministracion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "idConsulta: " + idConsulta + "\nMedicamento: " + medicamento;
    }

}
