package com.jcuevash.contacto.app.vo;

import java.io.Serializable;



public class ContactosVO implements Serializable {
	
	private static final long serialVersionUID = -3988849658023121088L;

	private Long idContacto;
	private String nombre;
	private Integer edad;
	private String email;
	
	public ContactosVO() {
		super();
	}
	
	public ContactosVO(Long idContacto, String nombre, Integer edad, String email) {
		super();
		this.idContacto = idContacto;
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
	}

	public Long getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(Long idContacto) {
		this.idContacto = idContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
