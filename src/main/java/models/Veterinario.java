package models;

import java.io.*;

public class Veterinario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idVeterinario;
	private String cedula;
	private int idUser;
	private String especialidad;
	private String universidad;
	private String fechaTitulacion;
	
	public Veterinario() {
	}

	public Veterinario(String cedula, int idUser, String especialidad, String universidad,
			String fechaTitulacion) {
		this.idVeterinario = cedula;
		this.cedula = cedula;
		this.idUser = idUser;
		this.especialidad = especialidad;
		this.universidad = universidad;
		this.fechaTitulacion = fechaTitulacion;
	}

	public String getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(String idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public String getFechaTitulacion() {
		return fechaTitulacion;
	}

	public void setFechaTitulacion(String fechaTitulacion) {
		this.fechaTitulacion = fechaTitulacion;
	}	
	
	@Override
	public String toString() {
		return "Cedula: "+cedula+"\nID Usuario: "+idUser;
	}
	
}
