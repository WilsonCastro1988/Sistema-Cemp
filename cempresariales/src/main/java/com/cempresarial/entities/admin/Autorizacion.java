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
@Table(name="autorizacion",catalog = "cempresariales_admin", schema = "")
@XmlRootElement
public class Autorizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_autorizacion", nullable = false)
    private Long idAutorizacion;
    private Boolean activo;
    @Column(length = 255)
    private String permisos;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil")
    @ManyToOne
    @JsonBackReference
    private Perfil perfil;
    @JoinColumn(name = "id_menu", referencedColumnName = "id_menu")
    @ManyToOne
    private Menu menu;

    public Autorizacion() {
    }

    public Autorizacion(Long idAutorizacion) {
        this.idAutorizacion = idAutorizacion;
    }

    public Long getIdAutorizacion() {
        return idAutorizacion;
    }

    public void setIdAutorizacion(Long idAutorizacion) {
        this.idAutorizacion = idAutorizacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutorizacion != null ? idAutorizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autorizacion)) {
            return false;
        }
        Autorizacion other = (Autorizacion) object;
        if ((this.idAutorizacion == null && other.idAutorizacion != null) || (this.idAutorizacion != null && !this.idAutorizacion.equals(other.idAutorizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Autorizacion[ idAutorizacion=" + idAutorizacion + " ]";
    }
    
}
