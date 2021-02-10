/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.entities.admin;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "usuario", catalog = "cempresariales_admin", schema = "")
@XmlRootElement
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_usuario", nullable = false)
	private Long idUsuario;
	private Boolean activo;
	@Column(length = 255)
	private String cedula;
	@Column(length = 255)
	private String clave;
	@Column(length = 255)
	private String email;
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	@Lob
	private String foto;
	@Column(name = "nombre_usuario", length = 255)
	private String nombreUsuario;
	@Column(length = 255)
	private String nombres;
	@Column(length = 255)
	private String usercambio;
	@Column(name = "id_empleado")
	private Long idEmpleado;
	@Column(name = "id_empresa")
	private Long idEmpresa;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<PerfilHasUsuario> perfilHasUsuarioList;
	@JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
	@ManyToOne
	private Cuenta cuenta;

	public Usuario() {
	}

	public Usuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getUsercambio() {
		return usercambio;
	}

	public void setUsercambio(String usercambio) {
		this.usercambio = usercambio;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	@XmlTransient
	public List<PerfilHasUsuario> getPerfilHasUsuarioList() {
		return perfilHasUsuarioList;
	}

	public void setPerfilHasUsuarioList(List<PerfilHasUsuario> perfilHasUsuarioList) {
		this.perfilHasUsuarioList = perfilHasUsuarioList;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idUsuario != null ? idUsuario.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) object;
		if ((this.idUsuario == null && other.idUsuario != null)
				|| (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication2.Usuario[ idUsuario=" + idUsuario + " ]";
	}

}
