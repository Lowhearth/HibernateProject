package com.netmind.dao;

public class Cliente {
	
	private int idCliente;
	private String nombre;
	private String apelidos;
	private String dni;
	
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
	public String getApellidos() {
		return apelidos;
	}
	public void setApellidos(String appelidos) {
		this.apelidos = appelidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Cliente(int idCliente, String nombre, String appelidos, String dni) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apelidos = appelidos;
		this.dni = dni;
	}
	
	public Cliente() {
		
	}
	

}
