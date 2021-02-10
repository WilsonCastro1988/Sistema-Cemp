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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByIdRol", query = "SELECT r FROM Rol r WHERE r.idRol = :idRol")
    , @NamedQuery(name = "Rol.findByActivoRol", query = "SELECT r FROM Rol r WHERE r.activoRol = :activoRol")
    , @NamedQuery(name = "Rol.findByCreaRol", query = "SELECT r FROM Rol r WHERE r.creaRol = :creaRol")
    , @NamedQuery(name = "Rol.findByNombreRol", query = "SELECT r FROM Rol r WHERE r.nombreRol = :nombreRol")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rol")
    private Long idRol;
    @Column(name = "activo_rol")
    private Boolean activoRol;
    @Column(name = "crea_rol")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creaRol;
    @Column(name = "nombre_rol")
    private String nombreRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private List<RolHasEmpleado> rolHasEmpleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolIdRol")
    @JsonIgnore
    private List<Checklist> checklistList;
    @JoinColumn(name = "area_id_area", referencedColumnName = "id_area")
	@ManyToOne(optional = false)
	private Area areaIdArea;
    
    

    public Rol() {
    }

    public Rol(Long idRol) {
        this.idRol = idRol;
    }
    
    
    

    public Area getAreaIdArea() {
		return areaIdArea;
	}

	public void setAreaIdArea(Area areaIdArea) {
		this.areaIdArea = areaIdArea;
	}

	public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public Boolean getActivoRol() {
        return activoRol;
    }

    public void setActivoRol(Boolean activoRol) {
        this.activoRol = activoRol;
    }

    public Date getCreaRol() {
        return creaRol;
    }

    public void setCreaRol(Date creaRol) {
        this.creaRol = creaRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @XmlTransient
    public List<RolHasEmpleado> getRolHasEmpleadoList() {
        return rolHasEmpleadoList;
    }

    public void setRolHasEmpleadoList(List<RolHasEmpleado> rolHasEmpleadoList) {
        this.rolHasEmpleadoList = rolHasEmpleadoList;
    }

    @XmlTransient
    public List<Checklist> getChecklistList() {
        return checklistList;
    }

    public void setChecklistList(List<Checklist> checklistList) {
        this.checklistList = checklistList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.Rol[ idRol=" + idRol + " ]";
    }
    
}
