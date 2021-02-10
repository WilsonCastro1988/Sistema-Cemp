/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.entities.admin;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ADM-DGIP
 */
@Embeddable
public class PerfilHasUsuarioPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "perfil_id_perfil", nullable = false)
    private long perfilIdPerfil;
    @Basic(optional = false)
    @Column(name = "usuario_id_usuario", nullable = false)
    private long usuarioIdUsuario;

    public PerfilHasUsuarioPK() {
    }

    public PerfilHasUsuarioPK(long perfilIdPerfil, long usuarioIdUsuario) {
        this.perfilIdPerfil = perfilIdPerfil;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public long getPerfilIdPerfil() {
        return perfilIdPerfil;
    }

    public void setPerfilIdPerfil(long perfilIdPerfil) {
        this.perfilIdPerfil = perfilIdPerfil;
    }

    public long getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(long usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) perfilIdPerfil;
        hash += (int) usuarioIdUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilHasUsuarioPK)) {
            return false;
        }
        PerfilHasUsuarioPK other = (PerfilHasUsuarioPK) object;
        if (this.perfilIdPerfil != other.perfilIdPerfil) {
            return false;
        }
        if (this.usuarioIdUsuario != other.usuarioIdUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.PerfilHasUsuarioPK[ perfilIdPerfil=" + perfilIdPerfil + ", usuarioIdUsuario=" + usuarioIdUsuario + " ]";
    }
    
}
