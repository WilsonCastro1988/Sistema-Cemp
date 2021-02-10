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
@Table(name = "empresa_has_region")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "EmpresaHasRegion.findAll", query = "SELECT e FROM EmpresaHasRegion e"),
		@NamedQuery(name = "EmpresaHasRegion.findByEmpresaIdEmpresa", query = "SELECT e FROM EmpresaHasRegion e WHERE e.empresaHasRegionPK.empresaIdEmpresa = :empresaIdEmpresa"),
		@NamedQuery(name = "EmpresaHasRegion.findByRegionIdRegion", query = "SELECT e FROM EmpresaHasRegion e WHERE e.empresaHasRegionPK.regionIdRegion = :regionIdRegion"),
		@NamedQuery(name = "EmpresaHasRegion.findByActivo", query = "SELECT e FROM EmpresaHasRegion e WHERE e.activo = :activo") })
public class EmpresaHasRegion implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected EmpresaHasRegionPK empresaHasRegionPK;
	@Column(name = "activo")
	private Short activo;
	@JoinColumn(name = "empresa_id_empresa", referencedColumnName = "id_empresa", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	@JsonIgnore
	private Empresa empresa;
	@JoinColumn(name = "region_id_region", referencedColumnName = "id_region", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	@JsonIgnore
	private Region region;

	public EmpresaHasRegion() {
	}

	public EmpresaHasRegion(EmpresaHasRegionPK empresaHasRegionPK) {
		this.empresaHasRegionPK = empresaHasRegionPK;
	}

	public EmpresaHasRegion(long empresaIdEmpresa, long regionIdRegion) {
		this.empresaHasRegionPK = new EmpresaHasRegionPK(empresaIdEmpresa, regionIdRegion);
	}

	public EmpresaHasRegionPK getEmpresaHasRegionPK() {
		return empresaHasRegionPK;
	}

	public void setEmpresaHasRegionPK(EmpresaHasRegionPK empresaHasRegionPK) {
		this.empresaHasRegionPK = empresaHasRegionPK;
	}

	public Short getActivo() {
		return activo;
	}

	public void setActivo(Short activo) {
		this.activo = activo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (empresaHasRegionPK != null ? empresaHasRegionPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof EmpresaHasRegion)) {
			return false;
		}
		EmpresaHasRegion other = (EmpresaHasRegion) object;
		if ((this.empresaHasRegionPK == null && other.empresaHasRegionPK != null)
				|| (this.empresaHasRegionPK != null && !this.empresaHasRegionPK.equals(other.empresaHasRegionPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.cempresariales.servicio.commons.model.entity.EmpresaHasRegion[ empresaHasRegionPK="
				+ empresaHasRegionPK + " ]";
	}

}
