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

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByIdCiudad", query = "SELECT c FROM Ciudad c WHERE c.idCiudad = :idCiudad")
    , @NamedQuery(name = "Ciudad.findByActivoCiudad", query = "SELECT c FROM Ciudad c WHERE c.activoCiudad = :activoCiudad")
    , @NamedQuery(name = "Ciudad.findByCreaCiudad", query = "SELECT c FROM Ciudad c WHERE c.creaCiudad = :creaCiudad")
    , @NamedQuery(name = "Ciudad.findByNombreCiudad", query = "SELECT c FROM Ciudad c WHERE c.nombreCiudad = :nombreCiudad")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ciudad")
    private Long idCiudad;
    @Column(name = "activo_ciudad")
    private Boolean activoCiudad;
    @Column(name = "crea_ciudad")
    @Temporal(TemporalType.DATE)
    private Date creaCiudad;
    @Column(name = "nombre_ciudad")
    private String nombreCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadIdCiudad")
    @JsonBackReference
    private List<Agencia> agenciaList;
    @JoinColumn(name = "provincia_id_provincia", referencedColumnName = "id_provincia")
    @ManyToOne(optional = false)
    private Provincia provinciaIdProvincia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private List<ZonaEstructuralHasCiudad> zonaEstructuralHasCiudadList;

    public Ciudad() {
    }

    public Ciudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Boolean getActivoCiudad() {
        return activoCiudad;
    }

    public void setActivoCiudad(Boolean activoCiudad) {
        this.activoCiudad = activoCiudad;
    }

    public Date getCreaCiudad() {
        return creaCiudad;
    }

    public void setCreaCiudad(Date creaCiudad) {
        this.creaCiudad = creaCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @XmlTransient
    public List<Agencia> getAgenciaList() {
        return agenciaList;
    }

    public void setAgenciaList(List<Agencia> agenciaList) {
        this.agenciaList = agenciaList;
    }

    public Provincia getProvinciaIdProvincia() {
        return provinciaIdProvincia;
    }

    public void setProvinciaIdProvincia(Provincia provinciaIdProvincia) {
        this.provinciaIdProvincia = provinciaIdProvincia;
    }
    
    @XmlTransient
    public List<ZonaEstructuralHasCiudad> getZonaEstructuralHasCiudadList() {
        return zonaEstructuralHasCiudadList;
    }

    public void setZonaEstructuralHasCiudadList(List<ZonaEstructuralHasCiudad> zonaEstructuralHasCiudadList) {
        this.zonaEstructuralHasCiudadList = zonaEstructuralHasCiudadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiudad != null ? idCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.idCiudad == null && other.idCiudad != null) || (this.idCiudad != null && !this.idCiudad.equals(other.idCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.Ciudad[ idCiudad=" + idCiudad + " ]";
    }
    
}
