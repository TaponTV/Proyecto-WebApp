package models;

import java.io.*;

public class Usuario implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int idUser;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private int idGenero;
    private int edad;
    private String pais;
    private String estado;
    private String ciudad;
    private String calle;
    private String celular;
    private String telefono;
    private String email;
    private String pswrd;
    private String rol;
    private int idRol;

    public Usuario() {

    }

    public Usuario(int idUser) {
        this.idUser = idUser;
    }

    public Usuario(String nombre, String apPaterno, String apMaterno, int idGenero, int edad, String pais,
            String estado, String ciudad, String calle, String celular, String telefono, String email, String pswrd,
            int idRol) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.idGenero = idGenero;
        this.edad = edad;
        this.pais = pais;
        this.estado = estado;
        this.ciudad = ciudad;
        this.calle = calle;
        this.celular = celular;
        this.telefono = telefono;
        this.email = email;
        this.pswrd = pswrd;
        this.idRol = idRol;
    }

    public Usuario(int idUser, String nombre, String apPaterno, String apMaterno, int idGenero, int edad, String pais,
            String estado, String ciudad, String calle, String celular, String telefono, String email, String pswrd,
            int idRol) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.idGenero = idGenero;
        this.edad = edad;
        this.pais = pais;
        this.estado = estado;
        this.ciudad = ciudad;
        this.calle = calle;
        this.celular = celular;
        this.telefono = telefono;
        this.email = email;
        this.pswrd = pswrd;
        this.idRol = idRol;
    }

    public Usuario(int idUser, String nombre, String apPaterno, String apMaterno, int edad, String pais, String estado, String email, String rol) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.edad = edad;
        this.pais = pais;
        this.estado = estado;
        this.email = email;
        this.rol = rol;
    }

    public Usuario(int idUser, String nombre, String apPaterno, String apMaterno, int edad, String pais, String estado, String ciudad, String calle, String celular, String telefono, String email, String rol, int idRol) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.edad = edad;
        this.pais = pais;
        this.estado = estado;
        this.ciudad = ciudad;
        this.calle = calle;
        this.celular = celular;
        this.telefono = telefono;
        this.email = email;
        this.rol = rol;
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswrd() {
        return pswrd;
    }

    public void setPswrd(String pswrd) {
        this.pswrd = pswrd;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

}
