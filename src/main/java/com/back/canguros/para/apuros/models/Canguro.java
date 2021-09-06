package com.back.canguros.para.apuros.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table (name = "canguros")
public class Canguro implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=3, max=130)
	private String nombre;
	
	@Column(nullable=false)
	@NotEmpty
	private String apellidos;
	
	private String imagen;
	
	@Column(nullable=false, columnDefinition = "Text")
	@NotEmpty
	private String descripcion;

	@Column(nullable=false)
	@NotEmpty
	@Size(min=3, max=130)
	private String email;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=3, max=130)
	private String telefono;
	
	@Column(nullable=false)
	@NotEmpty
	private String password;
	
	private static final long serialVersionUID = 21L;
	
	public Canguro() {
		
	}
	
	public Canguro(String nombre, String apellidos, String imagen, String descripcion,  String email, String telefono, String password) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.email = email;
		this.telefono = telefono;
		if(password.length() >= 8) {
			this.password = password;
		}
	}
	
	public Canguro(String nombre, String apellidos, String descripcion,  String email, String telefono, String password) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.descripcion = descripcion;
		this.email = email;
		this.telefono = telefono;
		if(password.length() >= 8) {
			this.password = password;
		}
	}
	

	/**
	 * @return the id
	 */
	public long getId() {
		return this.id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		if(password.length() >= 8) {
			this.password = password;
		}
	}

	@Override
	public String toString() {
		return "Progenitor [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", imagen=" + imagen
				+ ", descripcion=" + descripcion + ", email=" + email + ", telefono=" + telefono + "]";
	}
		
}