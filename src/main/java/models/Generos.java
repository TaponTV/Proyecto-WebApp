package models;

import java.io.Serializable;

public class Generos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idGenero;
	private String genero;
	
	public Generos() {	
	}
	
	public Generos(int idGenero) {
		this.idGenero = idGenero;
	}
	
	public Generos(String genero) {
		this.genero = genero;
	}
	
	public Generos(int idGenero, String genero) {
		this.idGenero = idGenero;
		this.genero = genero;
	}

	public int getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return "ID: "+idGenero+"\nGenero: "+genero;
	}
	
	
	

}
