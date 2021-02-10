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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "area")
@XmlRootElement
public class Area implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_area")
	private Long idArea;
	@Column(name = "actualiza_area")
	@Temporal(TemporalType.DATE)
	private Date actualizaArea;
	@Column(name = "crea_area")
	@Temporal(TemporalType.DATE)
	private Date creaArea;
	@Column(name = "activo_area")
	private Boolean activoArea;
	@Column(name = "descripcion_Area")
	private String descripcionArea;
	@Column(name = "nombre_area")
	private String nombreArea;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "areaIdArea")
	@JsonBackReference
	private List<Rol> rolList;

	public Area() {
	}

	public Long getIdArea() {
		return idArea;
	}

	public void setIdArea(Long idArea) {
		this.idArea = idArea;
	}

	public Date getActualizaArea() {
		return actualizaArea;
	}

	public void setActualizaArea(Date actualizaArea) {
		this.actualizaArea = actualizaArea;
	}

	public Date getCreaArea() {
		return creaArea;
	}

	public void setCreaArea(Date creaArea) {
		this.creaArea = creaArea;
	}

	public Boolean getActivoArea() {
		return activoArea;
	}

	public void setActivoArea(Boolean activoArea) {
		this.activoArea = activoArea;
	}

	public String getDescripcionArea() {
		return descripcionArea;
	}

	public void setDescripcionArea(String descripcionArea) {
		this.descripcionArea = descripcionArea;
	}

	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	@XmlTransient
	public List<Rol> getRolList() {
		return rolList;
	}

	public void setRolList(List<Rol> rolList) {
		this.rolList = rolList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idArea != null ? idArea.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Area)) {
			return false;
		}
		Area other = (Area) object;
		if ((this.idArea == null && other.idArea != null)
				|| (this.idArea != null && !this.idArea.equals(other.idArea))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.cempresariales.servicio.commons.model.entity.Area[ idArea=" + idArea + " ]";
	}

}
