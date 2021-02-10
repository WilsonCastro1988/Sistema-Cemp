/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "evaluacion_has_encabezado")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "EvaluacionHasEncabezado.findAll", query = "SELECT e FROM EvaluacionHasEncabezado e"),
		@NamedQuery(name = "EvaluacionHasEncabezado.findByEvaluacionIdEvaluacion", query = "SELECT e FROM EvaluacionHasEncabezado e WHERE e.evaluacionHasEncabezadoPK.evaluacionIdEvaluacion = :evaluacionIdEvaluacion"),
		@NamedQuery(name = "EvaluacionHasEncabezado.findByEncabezadoIdEncabezado", query = "SELECT e FROM EvaluacionHasEncabezado e WHERE e.evaluacionHasEncabezadoPK.encabezadoIdEncabezado = :encabezadoIdEncabezado"),
		@NamedQuery(name = "EvaluacionHasEncabezado.findByValorEncabezado", query = "SELECT e FROM EvaluacionHasEncabezado e WHERE e.valorEncabezado = :valorEncabezado"),
		@NamedQuery(name = "EvaluacionHasEncabezado.findByActivo", query = "SELECT e FROM EvaluacionHasEncabezado e WHERE e.activo = :activo") })
public class EvaluacionHasEncabezado implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected EvaluacionHasEncabezadoPK evaluacionHasEncabezadoPK;
	@Column(name = "valor_encabezado")
	private String valorEncabezado;
	@Column(name = "activo")
	private boolean activo;
	@JoinColumn(name = "encabezado_id_encabezado", referencedColumnName = "id_encabezado", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	@JsonIgnore
	private Encabezado encabezado;
	@JoinColumn(name = "evaluacion_id_evaluacion", referencedColumnName = "id_evaluacion", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	@JsonIgnore
	private Evaluacion evaluacion;

	public EvaluacionHasEncabezado() {
	}

	public EvaluacionHasEncabezado(EvaluacionHasEncabezadoPK evaluacionHasEncabezadoPK) {
		this.evaluacionHasEncabezadoPK = evaluacionHasEncabezadoPK;
	}

	public EvaluacionHasEncabezado(long evaluacionIdEvaluacion, int encabezadoIdEncabezado) {
		this.evaluacionHasEncabezadoPK = new EvaluacionHasEncabezadoPK(evaluacionIdEvaluacion, encabezadoIdEncabezado);
	}

	public EvaluacionHasEncabezadoPK getEvaluacionHasEncabezadoPK() {
		return evaluacionHasEncabezadoPK;
	}

	public void setEvaluacionHasEncabezadoPK(EvaluacionHasEncabezadoPK evaluacionHasEncabezadoPK) {
		this.evaluacionHasEncabezadoPK = evaluacionHasEncabezadoPK;
	}

	public String getValorEncabezado() {
		return valorEncabezado;
	}

	public void setValorEncabezado(String valorEncabezado) {
		this.valorEncabezado = valorEncabezado;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Encabezado getEncabezado() {
		return encabezado;
	}

	public void setEncabezado(Encabezado encabezado) {
		this.encabezado = encabezado;
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (evaluacionHasEncabezadoPK != null ? evaluacionHasEncabezadoPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof EvaluacionHasEncabezado)) {
			return false;
		}
		EvaluacionHasEncabezado other = (EvaluacionHasEncabezado) object;
		if ((this.evaluacionHasEncabezadoPK == null && other.evaluacionHasEncabezadoPK != null)
				|| (this.evaluacionHasEncabezadoPK != null
						&& !this.evaluacionHasEncabezadoPK.equals(other.evaluacionHasEncabezadoPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.cempresariales.servicio.commons.model.entity.EvaluacionHasEncabezado[ evaluacionHasEncabezadoPK="
				+ evaluacionHasEncabezadoPK + " ]";
	}

}
