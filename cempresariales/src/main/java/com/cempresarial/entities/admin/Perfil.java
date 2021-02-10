/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.entities.admin;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name="perfil",catalog = "cempresariales_admin", schema = "")
@XmlRootElement
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perfil", nullable = false)
    private Long idPerfil;
    private Boolean activo;
    @Column(length = 255)
    private String descripcion;
    @Column(length = 255)
    private String nombre;
    @OneToMany(mappedBy = "perfil")
    private List<Autorizacion> autorizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<PerfilHasUsuario> perfilHasUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private List<PermisoAgencia> permisoAgenciaList;

    public Perfil() {
    }

    public Perfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Autorizacion> getAutorizacionList() {
        return autorizacionList;
    }

    public void setAutorizacionList(List<Autorizacion> autorizacionList) {
        this.autorizacionList = autorizacionList;
    }

    @XmlTransient
    public List<PerfilHasUsuario> getPerfilHasUsuarioList() {
        return perfilHasUsuarioList;
    }

    public void setPerfilHasUsuarioList(List<PerfilHasUsuario> perfilHasUsuarioList) {
        this.perfilHasUsuarioList = perfilHasUsuarioList;
    }

    @XmlTransient
    public List<PermisoAgencia> getPermisoAgenciaList() {
        return permisoAgenciaList;
    }

    public void setPermisoAgenciaList(List<PermisoAgencia> permisoAgenciaList) {
        this.permisoAgenciaList = permisoAgenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Perfil[ idPerfil=" + idPerfil + " ]";
    }
    
}
