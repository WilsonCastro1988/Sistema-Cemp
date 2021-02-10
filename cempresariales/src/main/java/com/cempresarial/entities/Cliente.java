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
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
		@NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
		@NamedQuery(name = "Cliente.findByActivoCliente", query = "SELECT c FROM Cliente c WHERE c.activoCliente = :activoCliente"),
		@NamedQuery(name = "Cliente.findByActualizaCliente", query = "SELECT c FROM Cliente c WHERE c.actualizaCliente = :actualizaCliente"),
		@NamedQuery(name = "Cliente.findByCeoCliente", query = "SELECT c FROM Cliente c WHERE c.ceoCliente = :ceoCliente"),
		@NamedQuery(name = "Cliente.findByCiCliente", query = "SELECT c FROM Cliente c WHERE c.ciCliente = :ciCliente"),
		@NamedQuery(name = "Cliente.findByCreaCliente", query = "SELECT c FROM Cliente c WHERE c.creaCliente = :creaCliente"),
		@NamedQuery(name = "Cliente.findByDireccionCliente", query = "SELECT c FROM Cliente c WHERE c.direccionCliente = :direccionCliente"),
		@NamedQuery(name = "Cliente.findByFotoCliente", query = "SELECT c FROM Cliente c WHERE c.fotoCliente = :fotoCliente"),
		@NamedQuery(name = "Cliente.findByMailCliente", query = "SELECT c FROM Cliente c WHERE c.mailCliente = :mailCliente"),
		@NamedQuery(name = "Cliente.findByNombreCliente", query = "SELECT c FROM Cliente c WHERE c.nombreCliente = :nombreCliente"),
		@NamedQuery(name = "Cliente.findByTelefonoCliente", query = "SELECT c FROM Cliente c WHERE c.telefonoCliente = :telefonoCliente"),
		@NamedQuery(name = "Cliente.findByUrlCliente", query = "SELECT c FROM Cliente c WHERE c.urlCliente = :urlCliente") })
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_cliente")
	private Long idCliente;
	@Column(name = "activo_cliente")
	private Boolean activoCliente;
	@Column(name = "actualiza_cliente")
	@Temporal(TemporalType.DATE)
	private Date actualizaCliente;
	@Column(name = "ceo_cliente")
	private String ceoCliente;
	@Column(name = "ci_cliente")
	private String ciCliente;
	@Column(name = "crea_cliente")
	@Temporal(TemporalType.DATE)
	private Date creaCliente;
	@Column(name = "direccion_cliente")
	private String direccionCliente;
	@Column(name = "foto_cliente")
	private String fotoCliente;
	@Column(name = "mail_cliente")
	private String mailCliente;
	@Column(name = "nombre_cliente")
	private String nombreCliente;
	@Column(name = "telefono_cliente")
	private String telefonoCliente;
	@Column(name = "url_cliente")
	private String urlCliente;
	@OneToMany(mappedBy = "clienteIdCliente")
	@JsonIgnore
	private List<Empresa> empresaList;

	public Cliente() {
	}

	public Cliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Boolean getActivoCliente() {
		return activoCliente;
	}

	public void setActivoCliente(Boolean activoCliente) {
		this.activoCliente = activoCliente;
	}

	public Date getActualizaCliente() {
		return actualizaCliente;
	}

	public void setActualizaCliente(Date actualizaCliente) {
		this.actualizaCliente = actualizaCliente;
	}

	public String getCeoCliente() {
		return ceoCliente;
	}

	public void setCeoCliente(String ceoCliente) {
		this.ceoCliente = ceoCliente;
	}

	public String getCiCliente() {
		return ciCliente;
	}

	public void setCiCliente(String ciCliente) {
		this.ciCliente = ciCliente;
	}

	public Date getCreaCliente() {
		return creaCliente;
	}

	public void setCreaCliente(Date creaCliente) {
		this.creaCliente = creaCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getFotoCliente() {
		return fotoCliente;
	}

	public void setFotoCliente(String fotoCliente) {
		this.fotoCliente = fotoCliente;
	}

	public String getMailCliente() {
		return mailCliente;
	}

	public void setMailCliente(String mailCliente) {
		this.mailCliente = mailCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getUrlCliente() {
		return urlCliente;
	}

	public void setUrlCliente(String urlCliente) {
		this.urlCliente = urlCliente;
	}

	@XmlTransient
	public List<Empresa> getEmpresaList() {
		return empresaList;
	}

	public void setEmpresaList(List<Empresa> empresaList) {
		this.empresaList = empresaList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idCliente != null ? idCliente.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Cliente)) {
			return false;
		}
		Cliente other = (Cliente) object;
		if ((this.idCliente == null && other.idCliente != null)
				|| (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.cempresariales.servicio.commons.model.entity.Cliente[ idCliente=" + idCliente + " ]";
	}

}
