package models;

import java.io.*;

public class Conexion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idConexion;
	private int idUser;
	private String fechaConexion;
	private String fechaDesconexion;
	
	public Conexion() {
	}

	public Conexion(int idUser, String fechaConexion, String fechaDesconexion) {
		this.idUser = idUser;
		this.fechaConexion = fechaConexion;
		this.fechaDesconexion = fechaDesconexion;
	}

	public Conexion(int idConexion, int idUser, String fechaConexion, String fechaDesconexion) {
		this.idConexion = idConexion;
		this.idUser = idUser;
		this.fechaConexion = fechaConexion;
		this.fechaDesconexion = fechaDesconexion;
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
	
	
}
