package models;

import java.io.*;

public class Solicitud extends Usuario implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int idSolicitud;
    private int idCliente;
    private String idVeterinario;
    private int idMascota;
    private int idPrioridad;
    private int idEstado;
    private String fecha;
    private String descripcion;
    private String status;
    private String vNombre;

    public Solicitud() {

    }

    public Solicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Solicitud(int idCliente, String idVeterinario, int idMascota, int idPrioridad, int idEstado, String fecha,
            String descripcion) {
        this.idCliente = idCliente;
        this.idVeterinario = idVeterinario;
        this.idMascota = idMascota;
        this.idPrioridad = idPrioridad;
        this.idEstado = idEstado;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Solicitud(int idSolicitud, int idCliente, String idVeterinario, int idMascota, int idPrioridad, int idEstado,
            String fecha, String descripcion) {
        this.idSolicitud = idSolicitud;
        this.idCliente = idCliente;
        this.idVeterinario = idVeterinario;
        this.idMascota = idMascota;
        this.idPrioridad = idPrioridad;
        this.idEstado = idEstado;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(String idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(int idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getvNombre() {
        return vNombre;
    }

    public void setvNombre(String vNombre) {
        this.vNombre = vNombre;
    }

    @Override
    public String toString() {
        return "idSolicitud " + idSolicitud + "\n idCliente: " + idCliente;
    }

}
