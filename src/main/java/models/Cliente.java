package models;

import java.io.*;

public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCliente;
	private int idUser;
	
	public Cliente() {
		
	}
	
	public Cliente(int idUser) {
		this.idUser = idUser;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	@Override
	public String toString() {
		return "Cliente con idUser: "+idUser;
	}
	
}
