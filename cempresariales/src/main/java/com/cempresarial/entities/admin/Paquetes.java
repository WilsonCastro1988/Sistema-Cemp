/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.entities.admin;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name="paquetes",catalog = "cempresariales_admin", schema = "")
@XmlRootElement
public class Paquetes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paquete", nullable = false)
    private Long idPaquete;
    @Column(name = "numero_aplicacion")
    private Integer numeroAplicacion;
    @Column(name = "numero_incidentes")
    private Integer numeroIncidentes;
    @Column(name = "numero_menus")
    private Integer numeroMenus;
    @Column(name = "numero_ordenes_trabajo")
    private Integer numeroOrdenesTrabajo;
    @Column(name = "numero_perfil_usuario")
    private Integer numeroPerfilUsuario;
    @Column(name = "numero_perfiles")
    private Integer numeroPerfiles;
    @Column(name = "numero_permisos")
    private Integer numeroPermisos;
    @Column(name = "numero_tecnicos")
    private Integer numeroTecnicos;
    @Column(name = "numero_usuarios")
    private Integer numeroUsuarios;
    @OneToMany(mappedBy = "paquete")
    @JsonBackReference
    private List<TipoCuenta> tipoCuentaList;

    public Paquetes() {
    }

    public Paquetes(Long idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Long getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Long idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Integer getNumeroAplicacion() {
        return numeroAplicacion;
    }

    public void setNumeroAplicacion(Integer numeroAplicacion) {
        this.numeroAplicacion = numeroAplicacion;
    }

    public Integer getNumeroIncidentes() {
        return numeroIncidentes;
    }

    public void setNumeroIncidentes(Integer numeroIncidentes) {
        this.numeroIncidentes = numeroIncidentes;
    }

    public Integer getNumeroMenus() {
        return numeroMenus;
    }

    public void setNumeroMenus(Integer numeroMenus) {
        this.numeroMenus = numeroMenus;
    }

    public Integer getNumeroOrdenesTrabajo() {
        return numeroOrdenesTrabajo;
    }

    public void setNumeroOrdenesTrabajo(Integer numeroOrdenesTrabajo) {
        this.numeroOrdenesTrabajo = numeroOrdenesTrabajo;
    }

    public Integer getNumeroPerfilUsuario() {
        return numeroPerfilUsuario;
    }

    public void setNumeroPerfilUsuario(Integer numeroPerfilUsuario) {
        this.numeroPerfilUsuario = numeroPerfilUsuario;
    }

    public Integer getNumeroPerfiles() {
        return numeroPerfiles;
    }

    public void setNumeroPerfiles(Integer numeroPerfiles) {
        this.numeroPerfiles = numeroPerfiles;
    }

    public Integer getNumeroPermisos() {
        return numeroPermisos;
    }

    public void setNumeroPermisos(Integer numeroPermisos) {
        this.numeroPermisos = numeroPermisos;
    }

    public Integer getNumeroTecnicos() {
        return numeroTecnicos;
    }

    public void setNumeroTecnicos(Integer numeroTecnicos) {
        this.numeroTecnicos = numeroTecnicos;
    }

    public Integer getNumeroUsuarios() {
        return numeroUsuarios;
    }

    public void setNumeroUsuarios(Integer numeroUsuarios) {
        this.numeroUsuarios = numeroUsuarios;
    }

    @XmlTransient
    public List<TipoCuenta> getTipoCuentaList() {
        return tipoCuentaList;
    }

    public void setTipoCuentaList(List<TipoCuenta> tipoCuentaList) {
        this.tipoCuentaList = tipoCuentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaquete != null ? idPaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paquetes)) {
            return false;
        }
        Paquetes other = (Paquetes) object;
        if ((this.idPaquete == null && other.idPaquete != null) || (this.idPaquete != null && !this.idPaquete.equals(other.idPaquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Paquetes[ idPaquete=" + idPaquete + " ]";
    }
    
}
