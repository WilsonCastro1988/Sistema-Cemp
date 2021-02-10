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
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
		@NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa"),
		@NamedQuery(name = "Empresa.findByActivoEmpresa", query = "SELECT e FROM Empresa e WHERE e.activoEmpresa = :activoEmpresa"),
		@NamedQuery(name = "Empresa.findByCreaEmpresa", query = "SELECT e FROM Empresa e WHERE e.creaEmpresa = :creaEmpresa"),
		@NamedQuery(name = "Empresa.findByDireccionEmpresa", query = "SELECT e FROM Empresa e WHERE e.direccionEmpresa = :direccionEmpresa"),
		@NamedQuery(name = "Empresa.findByImagenEmpresa", query = "SELECT e FROM Empresa e WHERE e.imagenEmpresa = :imagenEmpresa"),
		@NamedQuery(name = "Empresa.findByNombreEmpresa", query = "SELECT e FROM Empresa e WHERE e.nombreEmpresa = :nombreEmpresa"),
		@NamedQuery(name = "Empresa.findByTelefonoEmpresa", query = "SELECT e FROM Empresa e WHERE e.telefonoEmpresa = :telefonoEmpresa") })
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_empresa")
	private Long idEmpresa;
	@Column(name = "activo_empresa")
	private Boolean activoEmpresa;
	@Column(name = "crea_empresa")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creaEmpresa;
	@Column(name = "direccion_empresa")
	private String direccionEmpresa;
	@Column(name = "imagen_empresa")
	private String imagenEmpresa;
	@Column(name = "nombre_empresa")
	private String nombreEmpresa;
	@Column(name = "telefono_empresa")
	private String telefonoEmpresa;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaIdEmpresa")
	private List<Promedio> promedioList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaIdEmpresa")
	@JsonIgnore
	private List<Agencia> agenciaList;
	@JoinColumn(name = "cliente_id_cliente", referencedColumnName = "id_cliente")
	@ManyToOne(optional = false)
	private Cliente clienteIdCliente;
	@JoinColumn(name = "sector_id_sector", referencedColumnName = "id_sector")
	@ManyToOne(optional = false)
	private Sector sectorIdSector;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	@JsonIgnore
	private List<RangoDesempenio> rangoDesempenioList;

	public Empresa() {
	}

	public Empresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Boolean getActivoEmpresa() {
		return activoEmpresa;
	}

	public void setActivoEmpresa(Boolean activoEmpresa) {
		this.activoEmpresa = activoEmpresa;
	}

	public Date getCreaEmpresa() {
		return creaEmpresa;
	}

	public void setCreaEmpresa(Date creaEmpresa) {
		this.creaEmpresa = creaEmpresa;
	}

	public String getDireccionEmpresa() {
		return direccionEmpresa;
	}

	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}

	public String getImagenEmpresa() {
		return imagenEmpresa;
	}

	public void setImagenEmpresa(String imagenEmpresa) {
		this.imagenEmpresa = imagenEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getTelefonoEmpresa() {
		return telefonoEmpresa;
	}

	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}

	@XmlTransient
	public List<RangoDesempenio> getRangoDesempenioList() {
		return rangoDesempenioList;
	}

	public void setRangoDesempenioList(List<RangoDesempenio> rangoDesempenioList) {
		this.rangoDesempenioList = rangoDesempenioList;
	}

	@XmlTransient
	public List<Promedio> getPromedioList() {
		return promedioList;
	}

	public void setPromedioList(List<Promedio> promedioList) {
		this.promedioList = promedioList;
	}

	public Cliente getClienteIdCliente() {
		return clienteIdCliente;
	}

	@XmlTransient
	public List<Agencia> getAgenciaList() {
		return agenciaList;
	}

	public void setAgenciaList(List<Agencia> agenciaList) {
		this.agenciaList = agenciaList;
	}

	public void setClienteIdCliente(Cliente clienteIdCliente) {
		this.clienteIdCliente = clienteIdCliente;
	}

	public Sector getSectorIdSector() {
		return sectorIdSector;
	}

	public void setSectorIdSector(Sector sectorIdSector) {
		this.sectorIdSector = sectorIdSector;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Empresa)) {
			return false;
		}
		Empresa other = (Empresa) object;
		if ((this.idEmpresa == null && other.idEmpresa != null)
				|| (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.cempresariales.servicio.commons.model.entity.Empresa[ idEmpresa=" + idEmpresa + " ]";
	}

}
