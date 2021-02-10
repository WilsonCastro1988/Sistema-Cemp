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
@Table(name = "rol_has_empleado")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "RolHasEmpleado.findAll", query = "SELECT r FROM RolHasEmpleado r"),
		@NamedQuery(name = "RolHasEmpleado.findByRolIdRol", query = "SELECT r FROM RolHasEmpleado r WHERE r.rolHasEmpleadoPK.rolIdRol = :rolIdRol"),
		@NamedQuery(name = "RolHasEmpleado.findByEmpleadoIdEmpleado", query = "SELECT r FROM RolHasEmpleado r WHERE r.rolHasEmpleadoPK.empleadoIdEmpleado = :empleadoIdEmpleado"),
		@NamedQuery(name = "RolHasEmpleado.findByActivo", query = "SELECT r FROM RolHasEmpleado r WHERE r.activo = :activo") })
public class RolHasEmpleado implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected RolHasEmpleadoPK rolHasEmpleadoPK;
	@Column(name = "activo")
	private Boolean activo;
	@JoinColumn(name = "empleado_id_empleado", referencedColumnName = "id_empleado", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	@JsonIgnore
	private Empleado empleado;
	@JoinColumn(name = "rol_id_rol", referencedColumnName = "id_rol", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	@JsonIgnore
	private Rol rol;

	public RolHasEmpleado() {
	}

	public RolHasEmpleado(RolHasEmpleadoPK rolHasEmpleadoPK) {
		this.rolHasEmpleadoPK = rolHasEmpleadoPK;
	}

	public RolHasEmpleado(long rolIdRol, long empleadoIdEmpleado) {
		this.rolHasEmpleadoPK = new RolHasEmpleadoPK(rolIdRol, empleadoIdEmpleado);
	}

	public RolHasEmpleadoPK getRolHasEmpleadoPK() {
		return rolHasEmpleadoPK;
	}

	public void setRolHasEmpleadoPK(RolHasEmpleadoPK rolHasEmpleadoPK) {
		this.rolHasEmpleadoPK = rolHasEmpleadoPK;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (rolHasEmpleadoPK != null ? rolHasEmpleadoPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof RolHasEmpleado)) {
			return false;
		}
		RolHasEmpleado other = (RolHasEmpleado) object;
		if ((this.rolHasEmpleadoPK == null && other.rolHasEmpleadoPK != null)
				|| (this.rolHasEmpleadoPK != null && !this.rolHasEmpleadoPK.equals(other.rolHasEmpleadoPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.cempresariales.servicio.commons.model.entity.RolHasEmpleado[ rolHasEmpleadoPK=" + rolHasEmpleadoPK
				+ " ]";
	}

}
