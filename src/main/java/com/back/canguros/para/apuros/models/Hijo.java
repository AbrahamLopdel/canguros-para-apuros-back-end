package com.back.canguros.para.apuros.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table (name = "hijos")
public class Hijo implements Serializable{

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
	private int edad;
	
	@OneToOne()
	private Progenitor progenitor;
	
	private static final long serialVersionUID = 23L;
	
	public Hijo() {
		
	}
	
	public Hijo(String nombre, String apellidos, String imagen,
			String descripcion, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.edad = edad;
	}
	
	public Hijo(String nombre, String apellidos,
			String descripcion, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.descripcion = descripcion;
		this.edad = edad;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Hijo [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", imagen=" + imagen
				+ ", descripcion=" + descripcion + ", edad=" + edad + "]";
	}

	
}