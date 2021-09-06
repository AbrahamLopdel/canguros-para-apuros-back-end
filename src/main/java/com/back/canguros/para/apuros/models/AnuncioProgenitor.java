package com.back.canguros.para.apuros.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table (name = "anuncioprogenitores")
public class AnuncioProgenitor implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=3, max=150)
	private String titulo;
	
	@Column(nullable=false, columnDefinition = "Text")
	@NotEmpty
	private String descripcion;

	@Column(nullable=false)
	private Date fechaInicio;
	
	@Column(nullable=false)
	private Date fechaFinal;
	
	@Column(nullable=false)
	@NotEmpty
	@Size(min=3, max=150)
	private String horario;
	
	@ManyToOne()
	private Progenitor anunciante;
	
	private static final long serialVersionUID = 25L;
	
	public AnuncioProgenitor() {
		
	}
	
	public AnuncioProgenitor(String titulo, String descripcion,
			Date fechaInicio, Date fechaFinal, String horario) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.horario = horario;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "AnuncioProgenitor [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fechaInicio="
				+ fechaInicio + ", fechaFinal=" + fechaFinal + ", horario=" + horario + ", anunciante=" + anunciante
				+ "]";
	}
		
}