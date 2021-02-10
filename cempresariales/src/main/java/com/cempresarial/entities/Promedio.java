/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "promedio")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Promedio.findAll", query = "SELECT p FROM Promedio p"),
		@NamedQuery(name = "Promedio.findByIdPromedio", query = "SELECT p FROM Promedio p WHERE p.idPromedio = :idPromedio"),
		@NamedQuery(name = "Promedio.findByCategoriaPromedio", query = "SELECT p FROM Promedio p WHERE p.categoriaPromedio = :categoriaPromedio"),
		@NamedQuery(name = "Promedio.findByEvaluacionPromedio", query = "SELECT p FROM Promedio p WHERE p.evaluacionPromedio = :evaluacionPromedio"),
		@NamedQuery(name = "Promedio.findByFechaFinalPromedio", query = "SELECT p FROM Promedio p WHERE p.fechaFinalPromedio = :fechaFinalPromedio"),
		@NamedQuery(name = "Promedio.findByFechaInicialPromedio", query = "SELECT p FROM Promedio p WHERE p.fechaInicialPromedio = :fechaInicialPromedio"),
		@NamedQuery(name = "Promedio.findByIdEvaluacionPromedio", query = "SELECT p FROM Promedio p WHERE p.idEvaluacionPromedio = :idEvaluacionPromedio"),
		@NamedQuery(name = "Promedio.findByPreguntaPromedio", query = "SELECT p FROM Promedio p WHERE p.preguntaPromedio = :preguntaPromedio") })
public class Promedio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_promedio")
	private Long idPromedio;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "categoria_promedio")
	private Float categoriaPromedio;
	@Column(name = "evaluacion_promedio")
	private Float evaluacionPromedio;
	@Column(name = "fecha_final_promedio")
	@Temporal(TemporalType.DATE)
	private Date fechaFinalPromedio;
	@Column(name = "fecha_inicial_promedio")
	@Temporal(TemporalType.DATE)
	private Date fechaInicialPromedio;
	@Column(name = "id_evaluacion_promedio")
	private Integer idEvaluacionPromedio;
	@Column(name = "pregunta_promedio")
	private Float preguntaPromedio;
	@JoinColumn(name = "empresa_id_empresa", referencedColumnName = "id_empresa")
	@ManyToOne(optional = false)
	@JsonBackReference
	private Empresa empresaIdEmpresa;

	public Promedio() {
	}

	public Promedio(Long idPromedio) {
		this.idPromedio = idPromedio;
	}

	public Long getIdPromedio() {
		return idPromedio;
	}

	public void setIdPromedio(Long idPromedio) {
		this.idPromedio = idPromedio;
	}

	public Float getCategoriaPromedio() {
		return categoriaPromedio;
	}

	public void setCategoriaPromedio(Float categoriaPromedio) {
		this.categoriaPromedio = categoriaPromedio;
	}

	public Float getEvaluacionPromedio() {
		return evaluacionPromedio;
	}

	public void setEvaluacionPromedio(Float evaluacionPromedio) {
		this.evaluacionPromedio = evaluacionPromedio;
	}

	public Date getFechaFinalPromedio() {
		return fechaFinalPromedio;
	}

	public void setFechaFinalPromedio(Date fechaFinalPromedio) {
		this.fechaFinalPromedio = fechaFinalPromedio;
	}

	public Date getFechaInicialPromedio() {
		return fechaInicialPromedio;
	}

	public void setFechaInicialPromedio(Date fechaInicialPromedio) {
		this.fechaInicialPromedio = fechaInicialPromedio;
	}

	public Integer getIdEvaluacionPromedio() {
		return idEvaluacionPromedio;
	}

	public void setIdEvaluacionPromedio(Integer idEvaluacionPromedio) {
		this.idEvaluacionPromedio = idEvaluacionPromedio;
	}

	public Float getPreguntaPromedio() {
		return preguntaPromedio;
	}

	public void setPreguntaPromedio(Float preguntaPromedio) {
		this.preguntaPromedio = preguntaPromedio;
	}

	public Empresa getEmpresaIdEmpresa() {
		return empresaIdEmpresa;
	}

	public void setEmpresaIdEmpresa(Empresa empresaIdEmpresa) {
		this.empresaIdEmpresa = empresaIdEmpresa;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idPromedio != null ? idPromedio.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Promedio)) {
			return false;
		}
		Promedio other = (Promedio) object;
		if ((this.idPromedio == null && other.idPromedio != null)
				|| (this.idPromedio != null && !this.idPromedio.equals(other.idPromedio))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.cempresariales.servicio.commons.model.entity.Promedio[ idPromedio=" + idPromedio + " ]";
	}

}
