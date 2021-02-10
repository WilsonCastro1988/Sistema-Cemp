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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name="cuenta",catalog = "cempresariales_admin", schema = "")
@XmlRootElement
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta", nullable = false)
    private Long idCuenta;
    @Column(name = "direccion_cuenta", length = 255)
    private String direccionCuenta;
    @Column(name = "email_cuenta", length = 255)
    private String emailCuenta;
    @Column(name = "nombre_cuenta", length = 255)
    private String nombreCuenta;
    @Column(name = "ruc_cuenta", length = 255)
    private String rucCuenta;
    @Column(name = "telefono_cuenta", length = 255)
    private String telefonoCuenta;
    @Column(name = "activo_cuenta")
    private Boolean activoCuenta;
    @JoinColumn(name = "id_tipo_cuenta", referencedColumnName = "id_tipo")
    @ManyToOne
    private TipoCuenta tipoCuenta;
    @OneToMany(mappedBy = "cuenta")
    @JsonBackReference
    private List<Usuario> usuarioList;

    public Cuenta() {
    }

    public Cuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getDireccionCuenta() {
        return direccionCuenta;
    }

    public void setDireccionCuenta(String direccionCuenta) {
        this.direccionCuenta = direccionCuenta;
    }

    public String getEmailCuenta() {
        return emailCuenta;
    }

    public void setEmailCuenta(String emailCuenta) {
        this.emailCuenta = emailCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getRucCuenta() {
        return rucCuenta;
    }

    public void setRucCuenta(String rucCuenta) {
        this.rucCuenta = rucCuenta;
    }

    public String getTelefonoCuenta() {
        return telefonoCuenta;
    }

    public void setTelefonoCuenta(String telefonoCuenta) {
        this.telefonoCuenta = telefonoCuenta;
    }

    public Boolean getActivoCuenta() {
        return activoCuenta;
    }

    public void setActivoCuenta(Boolean activoCuenta) {
        this.activoCuenta = activoCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Cuenta[ idCuenta=" + idCuenta + " ]";
    }
    
}
