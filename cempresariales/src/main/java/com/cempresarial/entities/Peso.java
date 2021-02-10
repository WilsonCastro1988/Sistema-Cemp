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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "peso")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Peso.findAll", query = "SELECT p FROM Peso p"),
		@NamedQuery(name = "Peso.findByIdPeso", query = "SELECT p FROM Peso p WHERE p.idPeso = :idPeso"),
		@NamedQuery(name = "Peso.findByCreaPeso", query = "SELECT p FROM Peso p WHERE p.creaPeso = :creaPeso"),
		@NamedQuery(name = "Peso.findByPeso", query = "SELECT p FROM Peso p WHERE p.peso = :peso"),
		@NamedQuery(name = "Peso.findByPorcentaje", query = "SELECT p FROM Peso p WHERE p.porcentaje = :porcentaje"),
		@NamedQuery(name = "Peso.findByValor", query = "SELECT p FROM Peso p WHERE p.valor = :valor") })
public class Peso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_peso")
	private Long idPeso;
	@Column(name = "crea_peso")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creaPeso;
	@Column(name = "peso")
	private String peso;
	@Column(name = "porcentaje")
	private String porcentaje;
	@Column(name = "valor")
	private String valor;
	@Column(name = "activo_peso")
	private boolean activoPeso;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "peso")
	@JsonIgnore
	private List<CatalogoPregunta> catalogoPreguntaList;

	public Peso() {
	}

	public Peso(Long idPeso) {
		this.idPeso = idPeso;
	}

	public boolean isActivoPeso() {
		return activoPeso;
	}

	public void setActivoPeso(boolean activoPeso) {
		this.activoPeso = activoPeso;
	}

	public Long getIdPeso() {
		return idPeso;
	}

	public void setIdPeso(Long idPeso) {
		this.idPeso = idPeso;
	}

	public Date getCreaPeso() {
		return creaPeso;
	}

	public void setCreaPeso(Date creaPeso) {
		this.creaPeso = creaPeso;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@XmlTransient
	public List<CatalogoPregunta> getCatalogoPreguntaList() {
		return catalogoPreguntaList;
	}

	public void setCatalogoPreguntaList(List<CatalogoPregunta> catalogoPreguntaList) {
		this.catalogoPreguntaList = catalogoPreguntaList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idPeso != null ? idPeso.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Peso)) {
			return false;
		}
		Peso other = (Peso) object;
		if ((this.idPeso == null && other.idPeso != null)
				|| (this.idPeso != null && !this.idPeso.equals(other.idPeso))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.cempresariales.servicio.commons.model.entity.Peso[ idPeso=" + idPeso + " ]";
	}

}
