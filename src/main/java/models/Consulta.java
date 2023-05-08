package models;

import java.io.*;

public class Consulta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idConsulta;
	private int idSolicitud;
	private String fechaConsulta;
	private String detalle;
	
	public Consulta() {
		
	}

	public Consulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Consulta(int idSolicitud, String fechaConsulta, String detalle) {
		this.idSolicitud = idSolicitud;
		this.fechaConsulta = fechaConsulta;
		this.detalle = detalle;
	}

	public Consulta(int idConsulta, int idSolicitud, String fechaConsulta, String detalle) {
		this.idConsulta = idConsulta;
		this.idSolicitud = idSolicitud;
		this.fechaConsulta = fechaConsulta;
		this.detalle = detalle;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(String fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	@Override
	public String toString() {
		return "idConsulta: "+idConsulta+"\nidSolicitud: "+idSolicitud;
	}
	
}
