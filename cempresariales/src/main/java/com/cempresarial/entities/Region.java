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

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "region")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r")
    , @NamedQuery(name = "Region.findByIdRegion", query = "SELECT r FROM Region r WHERE r.idRegion = :idRegion")
    , @NamedQuery(name = "Region.findByActivoRegion", query = "SELECT r FROM Region r WHERE r.activoRegion = :activoRegion")
    , @NamedQuery(name = "Region.findByCreaRegion", query = "SELECT r FROM Region r WHERE r.creaRegion = :creaRegion")
    , @NamedQuery(name = "Region.findByNombreRegion", query = "SELECT r FROM Region r WHERE r.nombreRegion = :nombreRegion")})
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_region")
    private Long idRegion;
    @Column(name = "activo_region")
    private Boolean activoRegion;
    @Column(name = "crea_region")
    @Temporal(TemporalType.DATE)
    private Date creaRegion;
    @Column(name = "nombre_region")
    private String nombreRegion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region")
    private List<RegionHasZona> regionHasZonaList;
   

    public Region() {
    }

    public Region(Long idRegion) {
        this.idRegion = idRegion;
    }

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }

    public Boolean getActivoRegion() {
        return activoRegion;
    }

    public void setActivoRegion(Boolean activoRegion) {
        this.activoRegion = activoRegion;
    }

    public Date getCreaRegion() {
        return creaRegion;
    }

    public void setCreaRegion(Date creaRegion) {
        this.creaRegion = creaRegion;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    @XmlTransient
    public List<RegionHasZona> getRegionHasZonaList() {
        return regionHasZonaList;
    }

    public void setRegionHasZonaList(List<RegionHasZona> regionHasZonaList) {
        this.regionHasZonaList = regionHasZonaList;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegion != null ? idRegion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.idRegion == null && other.idRegion != null) || (this.idRegion != null && !this.idRegion.equals(other.idRegion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.Region[ idRegion=" + idRegion + " ]";
    }
    
}
