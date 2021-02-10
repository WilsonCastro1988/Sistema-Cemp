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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
		@NamedQuery(name = "Categoria.findByIdCategoria", query = "SELECT c FROM Categoria c WHERE c.idCategoria = :idCategoria"),
		@NamedQuery(name = "Categoria.findByActivoCategoria", query = "SELECT c FROM Categoria c WHERE c.activoCategoria = :activoCategoria"),
		@NamedQuery(name = "Categoria.findByCreaCategoria", query = "SELECT c FROM Categoria c WHERE c.creaCategoria = :creaCategoria"),
		@NamedQuery(name = "Categoria.findByNombreCategoria", query = "SELECT c FROM Categoria c WHERE c.nombreCategoria = :nombreCategoria") })
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_categoria")
	private Long idCategoria;
	@Column(name = "activo_categoria")
	private boolean activoCategoria;
	@Column(name = "crea_categoria")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creaCategoria;
	@Column(name = "nombre_categoria")
	private String nombreCategoria;
	@OneToMany(mappedBy = "categoriaIdCategoria")
	@JsonBackReference
	private List<Categoria> categoriaList;
	@JoinColumn(name = "categoria_id_categoria", referencedColumnName = "id_categoria")
	@ManyToOne
	private Categoria categoriaIdCategoria;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
	@JsonIgnore
	private List<CatalogoPregunta> catalogoPreguntaList;

	public Categoria() {
	}

	public Categoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public boolean getActivoCategoria() {
		return activoCategoria;
	}

	public void setActivoCategoria(boolean activoCategoria) {
		this.activoCategoria = activoCategoria;
	}

	public Date getCreaCategoria() {
		return creaCategoria;
	}

	public void setCreaCategoria(Date creaCategoria) {
		this.creaCategoria = creaCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@XmlTransient
	public List<Categoria> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(List<Categoria> categoriaList) {
		this.categoriaList = categoriaList;
	}

	public Categoria getCategoriaIdCategoria() {
		return categoriaIdCategoria;
	}

	public void setCategoriaIdCategoria(Categoria categoriaIdCategoria) {
		this.categoriaIdCategoria = categoriaIdCategoria;
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
		hash += (idCategoria != null ? idCategoria.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Categoria)) {
			return false;
		}
		Categoria other = (Categoria) object;
		if ((this.idCategoria == null && other.idCategoria != null)
				|| (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.cempresariales.servicio.commons.model.entity.Categoria[ idCategoria=" + idCategoria + " ]";
	}

}
