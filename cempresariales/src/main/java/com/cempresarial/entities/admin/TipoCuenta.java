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

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "tipo_cuenta", catalog = "cempresariales_admin", schema = "")
@XmlRootElement
public class TipoCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo", nullable = false)
    private Long idTipo;
    @Column(name = "nombre_tipo", length = 255)
    private String nombreTipo;
    @Column(name = "activo_tipo_cuenta")
    private Boolean activoTipoCuenta;
    @JoinColumn(name = "id_paquete", referencedColumnName = "id_paquete")
    @ManyToOne
    private Paquetes paquete;
    @OneToMany(mappedBy = "tipoCuenta")
    @JsonBackReference
    private List<Cuenta> cuentaList;

    public TipoCuenta() {
    }

    public TipoCuenta(Long idTipo) {
        this.idTipo = idTipo;
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public Boolean getActivoTipoCuenta() {
        return activoTipoCuenta;
    }

    public void setActivoTipoCuenta(Boolean activoTipoCuenta) {
        this.activoTipoCuenta = activoTipoCuenta;
    }

    public Paquetes getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquetes paquete) {
        this.paquete = paquete;
    }

    @XmlTransient
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuenta)) {
            return false;
        }
        TipoCuenta other = (TipoCuenta) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.TipoCuenta[ idTipo=" + idTipo + " ]";
    }
    
}
