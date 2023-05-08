package models;

import java.io.*;

public class Conexion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idConexion;
	private int idUser;
	private String fechaConexion;
	private String fechaDesconexion;
	private int idSesion;
	
	public Conexion() {
	}

	public Conexion(int idUser, String fechaConexion, String fechaDesconexion, int idSesion) {
		this.idUser = idUser;
		this.fechaConexion = fechaConexion;
		this.fechaDesconexion = fechaDesconexion;
		this.idSesion = idSesion;
	}

	public Conexion(int idConexion, int idUser, String fechaConexion, String fechaDesconexion, int idSesion) {
		this.idConexion = idConexion;
		this.idUser = idUser;
		this.fechaConexion = fechaConexion;
		this.fechaDesconexion = fechaDesconexion;
		this.idSesion = idSesion;
	}

	public int getIdConexion() {
		return idConexion;
	}

	public void setIdConexion(int idConexion) {
		this.idConexion = idConexion;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFechaConexion() {
		return fechaConexion;
	}

	public void setFechaConexion(String fechaConexion) {
		this.fechaConexion = fechaConexion;
	}

	public String getFechaDesconexion() {
		return fechaDesconexion;
	}

	public void setFechaDesconexion(String fechaDesconexion) {
		this.fechaDesconexion = fechaDesconexion;
	}

	public int getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}
	
	
}
