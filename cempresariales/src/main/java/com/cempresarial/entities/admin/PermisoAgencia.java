/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.entities.admin;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "permiso_agencia", catalog = "cempresariales_admin", schema = "")
@XmlRootElement
public class PermisoAgencia implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_permiso_agencia", nullable = false)
	private Long idPermisoAgencia;
	@Column(name = "id_agencia")
	private Long idAgencia;
	@Column(name = "activo_permiso_agencia")
	private Boolean activoPermisoAgencia;
	@JoinColumn(name = "perfil_id_perfil", referencedColumnName = "id_perfil", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false)
	@JsonBackReference
	private Perfil perfil;

	public PermisoAgencia() {
	}

	public Boolean getActivoPermisoAgencia() {
		return activoPermisoAgencia;
	}

	public void setActivoPermisoAgencia(Boolean activoPermisoAgencia) {
		this.activoPermisoAgencia = activoPermisoAgencia;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Long getIdPermisoAgencia() {
		return idPermisoAgencia;
	}

	public void setIdPermisoAgencia(Long idPermisoAgencia) {
		this.idPermisoAgencia = idPermisoAgencia;
	}

	public Long getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}

}
