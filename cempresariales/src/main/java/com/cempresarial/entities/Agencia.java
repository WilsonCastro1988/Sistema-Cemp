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

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "agencia")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Agencia.findAll", query = "SELECT a FROM Agencia a"),
		@NamedQuery(name = "Agencia.findByIdAgencia", query = "SELECT a FROM Agencia a WHERE a.idAgencia = :idAgencia"),
		@NamedQuery(name = "Agencia.findByActivoAgencia", query = "SELECT a FROM Agencia a WHERE a.activoAgencia = :activoAgencia"),
		@NamedQuery(name = "Agencia.findByCreaAgencia", query = "SELECT a FROM Agencia a WHERE a.creaAgencia = :creaAgencia"),
		@NamedQuery(name = "Agencia.findByNombreAgencia", query = "SELECT a FROM Agencia a WHERE a.nombreAgencia = :nombreAgencia") })
public class Agencia implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_agencia")
	private Long idAgencia;
	@Column(name = "activo_agencia")
	private Boolean activoAgencia;
	@Column(name = "crea_agencia")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creaAgencia;
	@Column(name = "nombre_agencia")
	private String nombreAgencia;
	@Column(name = "direccion_agencia")
	private String direccionAgencia;
	@Column(name = "email_agencia")
	private String emailAgencia;
	@Column(name = "telefono_agencia")
	private String telefonoAgencia;
	@Column(name = "ceo_agencia")
	private String ceoAgencia;
	@JoinColumn(name = "ciudad_id_ciudad", referencedColumnName = "id_ciudad")
	@ManyToOne(optional = false)
	private Ciudad ciudadIdCiudad;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "agenciaIdAgencia")
	@JsonBackReference
	private List<Empleado> empleadoList;
	@JoinColumn(name = "empresa_id_empresa", referencedColumnName = "id_empresa")
	@ManyToOne(optional = false)
	private Empresa empresaIdEmpresa;
	@Column(name = "id_zona_estructural")
	private Long idZonaEstructural;

	public Agencia() {
	}

	public Agencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}
	
	

	public Long getIdZonaEstructural() {
		return idZonaEstructural;
	}

	public void setIdZonaEstructural(Long idZonaEstructural) {
		this.idZonaEstructural = idZonaEstructural;
	}

	public String getDireccionAgencia() {
		return direccionAgencia;
	}

	public void setDireccionAgencia(String direccionAgencia) {
		this.direccionAgencia = direccionAgencia;
	}

	public String getEmailAgencia() {
		return emailAgencia;
	}

	public void setEmailAgencia(String emailAgencia) {
		this.emailAgencia = emailAgencia;
	}

	public String getTelefonoAgencia() {
		return telefonoAgencia;
	}

	public void setTelefonoAgencia(String telefonoAgencia) {
		this.telefonoAgencia = telefonoAgencia;
	}

	public String getCeoAgencia() {
		return ceoAgencia;
	}

	public void setCeoAgencia(String ceoAgencia) {
		this.ceoAgencia = ceoAgencia;
	}

	public Empresa getEmpresaIdEmpresa() {
		return empresaIdEmpresa;
	}

	public void setEmpresaIdEmpresa(Empresa empresaIdEmpresa) {
		this.empresaIdEmpresa = empresaIdEmpresa;
	}

	public Long getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}

	public Boolean getActivoAgencia() {
		return activoAgencia;
	}

	public void setActivoAgencia(Boolean activoAgencia) {
		this.activoAgencia = activoAgencia;
	}

	public Date getCreaAgencia() {
		return creaAgencia;
	}

	public void setCreaAgencia(Date creaAgencia) {
		this.creaAgencia = creaAgencia;
	}

	public String getNombreAgencia() {
		return nombreAgencia;
	}

	public void setNombreAgencia(String nombreAgencia) {
		this.nombreAgencia = nombreAgencia;
	}

	public Ciudad getCiudadIdCiudad() {
		return ciudadIdCiudad;
	}

	public void setCiudadIdCiudad(Ciudad ciudadIdCiudad) {
		this.ciudadIdCiudad = ciudadIdCiudad;
	}

	@XmlTransient
	public List<Empleado> getEmpleadoList() {
		return empleadoList;
	}

	public void setEmpleadoList(List<Empleado> empleadoList) {
		this.empleadoList = empleadoList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idAgencia != null ? idAgencia.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Agencia)) {
			return false;
		}
		Agencia other = (Agencia) object;
		if ((this.idAgencia == null && other.idAgencia != null)
				|| (this.idAgencia != null && !this.idAgencia.equals(other.idAgencia))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.cempresariales.servicio.commons.model.entity.Agencia[ idAgencia=" + idAgencia + " ]";
	}

}
