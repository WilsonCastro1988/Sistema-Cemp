/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "rango_desempenio")
@XmlRootElement
public class RangoDesempenio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_rango")
	private Long idRango;
	@Column(name = "nombre_rango")
	private String nombreRango;

	@Column(name = "color_rango")
	private String colorRango;

	@Column(name = "rating_rango")
	private Integer ratingRango;

	@Column(name = "descripcion_Rango")
	private String descripcionRango;
	@Column(name = "minimo_rango")
	private Double minimoRango;
	@Column(name = "maximo_rango")
	private Double maximoRango;

	@Column(name = "actualiza_rango")
	@Temporal(TemporalType.DATE)
	private Date actualizaRango;
	@Column(name = "crea_rango")
	@Temporal(TemporalType.DATE)
	private Date crearango;
	@Column(name = "activo_Rango")
	private Boolean activoRango;

	@JoinColumn(name = "empresa_id_empresa", referencedColumnName = "id_empresa")
	@ManyToOne(optional = false)
	private Empresa empresa;

	public RangoDesempenio() {
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getColorRango() {
		return colorRango;
	}

	public void setColorRango(String colorRango) {
		this.colorRango = colorRango;
	}

	public Integer getRatingRango() {
		return ratingRango;
	}

	public void setRatingRango(Integer ratingRango) {
		this.ratingRango = ratingRango;
	}

	public Long getIdRango() {
		return idRango;
	}

	public void setIdRango(Long idRango) {
		this.idRango = idRango;
	}

	public String getNombreRango() {
		return nombreRango;
	}

	public void setNombreRango(String nombreRango) {
		this.nombreRango = nombreRango;
	}

	public String getDescripcionRango() {
		return descripcionRango;
	}

	public void setDescripcionRango(String descripcionRango) {
		this.descripcionRango = descripcionRango;
	}

	public Double getMinimoRango() {
		return minimoRango;
	}

	public void setMinimoRango(Double minimoRango) {
		this.minimoRango = minimoRango;
	}

	public Double getMaximoRango() {
		return maximoRango;
	}

	public void setMaximoRango(Double maximoRango) {
		this.maximoRango = maximoRango;
	}

	public Date getActualizaRango() {
		return actualizaRango;
	}

	public void setActualizaRango(Date actualizaRango) {
		this.actualizaRango = actualizaRango;
	}

	public Date getCrearango() {
		return crearango;
	}

	public void setCrearango(Date crearango) {
		this.crearango = crearango;
	}

	public Boolean getActivoRango() {
		return activoRango;
	}

	public void setActivoRango(Boolean activoRango) {
		this.activoRango = activoRango;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idRango != null ? idRango.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof RangoDesempenio)) {
			return false;
		}
		RangoDesempenio other = (RangoDesempenio) object;
		if ((this.idRango == null && other.idRango != null)
				|| (this.idRango != null && !this.idRango.equals(other.idRango))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.cempresariales.servicio.commons.model.entity.Rango[ idRango=" + idRango + " ]";
	}

}
