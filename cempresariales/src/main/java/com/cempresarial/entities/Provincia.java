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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "provincia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p")
    , @NamedQuery(name = "Provincia.findByIdProvincia", query = "SELECT p FROM Provincia p WHERE p.idProvincia = :idProvincia")
    , @NamedQuery(name = "Provincia.findByActivoProvincia", query = "SELECT p FROM Provincia p WHERE p.activoProvincia = :activoProvincia")
    , @NamedQuery(name = "Provincia.findByCreaProvincia", query = "SELECT p FROM Provincia p WHERE p.creaProvincia = :creaProvincia")
    , @NamedQuery(name = "Provincia.findByNombreProvincia", query = "SELECT p FROM Provincia p WHERE p.nombreProvincia = :nombreProvincia")})
public class Provincia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_provincia")
    private Long idProvincia;
    @Column(name = "activo_provincia")
    private Boolean activoProvincia;
    @Column(name = "crea_provincia")
    @Temporal(TemporalType.DATE)
    private Date creaProvincia;
    @Column(name = "nombre_provincia")
    private String nombreProvincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provincia")
    private List<ZonaHasProvincia> zonaHasProvinciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provinciaIdProvincia")
    @JsonBackReference
    private List<Ciudad> ciudadList;

    public Provincia() {
    }

    public Provincia(Long idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Long getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Long idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Boolean getActivoProvincia() {
        return activoProvincia;
    }

    public void setActivoProvincia(Boolean activoProvincia) {
        this.activoProvincia = activoProvincia;
    }

    public Date getCreaProvincia() {
        return creaProvincia;
    }

    public void setCreaProvincia(Date creaProvincia) {
        this.creaProvincia = creaProvincia;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    @XmlTransient
    public List<ZonaHasProvincia> getZonaHasProvinciaList() {
        return zonaHasProvinciaList;
    }

    public void setZonaHasProvinciaList(List<ZonaHasProvincia> zonaHasProvinciaList) {
        this.zonaHasProvinciaList = zonaHasProvinciaList;
    }

    @XmlTransient
    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProvincia != null ? idProvincia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.idProvincia == null && other.idProvincia != null) || (this.idProvincia != null && !this.idProvincia.equals(other.idProvincia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.Provincia[ idProvincia=" + idProvincia + " ]";
    }
    
}
