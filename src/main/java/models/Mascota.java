package models;

import java.io.*;

public class Mascota implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idMascota;
	private int idCliente;
	private String nombre;
	private int edad;
	private String fechaNac;
	private String raza;
	private int idEspecie;
	
	public Mascota() {
		
	}

	public Mascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public Mascota(int idCliente, String nombre, int edad, String fechaNac, String raza, int idEspecie) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNac = fechaNac;
		this.raza = raza;
		this.idEspecie = idEspecie;
	}

	public Mascota(int idMascota, int idCliente, String nombre, int edad, String fechaNac, String raza, int idEspecie) {
		this.idMascota = idMascota;
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNac = fechaNac;
		this.raza = raza;
		this.idEspecie = idEspecie;
	}

	public int getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}
	
	@Override
	public String toString() {
		return "idMascota: "+idMascota+"\n Mascota: "+nombre;
	}
	
}
