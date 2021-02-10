/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.entities.admin;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "perfil_has_usuario", catalog = "cempresariales_admin", schema = "")
@XmlRootElement
public class PerfilHasUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilHasUsuarioPK perfilHasUsuarioPK;
    @Column(name = "activo_perfil_has_usuario")
    private Boolean activoPerfilHasUsuario;
    @JoinColumn(name = "perfil_id_perfil", referencedColumnName = "id_perfil", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Perfil perfil;
    @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Usuario usuario;

    public PerfilHasUsuario() {
    }

    public PerfilHasUsuario(PerfilHasUsuarioPK perfilHasUsuarioPK) {
        this.perfilHasUsuarioPK = perfilHasUsuarioPK;
    }

    public PerfilHasUsuario(long perfilIdPerfil, int usuarioIdUsuario) {
        this.perfilHasUsuarioPK = new PerfilHasUsuarioPK(perfilIdPerfil, usuarioIdUsuario);
    }

    public PerfilHasUsuarioPK getPerfilHasUsuarioPK() {
        return perfilHasUsuarioPK;
    }

    public void setPerfilHasUsuarioPK(PerfilHasUsuarioPK perfilHasUsuarioPK) {
        this.perfilHasUsuarioPK = perfilHasUsuarioPK;
    }

    public Boolean getActivoPerfilHasUsuario() {
        return activoPerfilHasUsuario;
    }

    public void setActivoPerfilHasUsuario(Boolean activoPerfilHasUsuario) {
        this.activoPerfilHasUsuario = activoPerfilHasUsuario;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilHasUsuarioPK != null ? perfilHasUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilHasUsuario)) {
            return false;
        }
        PerfilHasUsuario other = (PerfilHasUsuario) object;
        if ((this.perfilHasUsuarioPK == null && other.perfilHasUsuarioPK != null) || (this.perfilHasUsuarioPK != null && !this.perfilHasUsuarioPK.equals(other.perfilHasUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.PerfilHasUsuario[ perfilHasUsuarioPK=" + perfilHasUsuarioPK + " ]";
    }
    
}
