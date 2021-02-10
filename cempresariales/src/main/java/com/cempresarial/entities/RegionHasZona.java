/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "region_has_zona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegionHasZona.findAll", query = "SELECT r FROM RegionHasZona r")
    , @NamedQuery(name = "RegionHasZona.findByRegionIdRegion", query = "SELECT r FROM RegionHasZona r WHERE r.regionHasZonaPK.regionIdRegion = :regionIdRegion")
    , @NamedQuery(name = "RegionHasZona.findByZonaIdZona", query = "SELECT r FROM RegionHasZona r WHERE r.regionHasZonaPK.zonaIdZona = :zonaIdZona")
    , @NamedQuery(name = "RegionHasZona.findByActivo", query = "SELECT r FROM RegionHasZona r WHERE r.activo = :activo")})
public class RegionHasZona implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RegionHasZonaPK regionHasZonaPK;
    @Column(name = "activo")
    private Short activo;
    @JoinColumn(name = "region_id_region", referencedColumnName = "id_region", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Region region;
    @JoinColumn(name = "zona_id_zona", referencedColumnName = "id_zona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Zona zona;

    public RegionHasZona() {
    }

    public RegionHasZona(RegionHasZonaPK regionHasZonaPK) {
        this.regionHasZonaPK = regionHasZonaPK;
    }

    public RegionHasZona(long regionIdRegion, long zonaIdZona) {
        this.regionHasZonaPK = new RegionHasZonaPK(regionIdRegion, zonaIdZona);
    }

    public RegionHasZonaPK getRegionHasZonaPK() {
        return regionHasZonaPK;
    }

    public void setRegionHasZonaPK(RegionHasZonaPK regionHasZonaPK) {
        this.regionHasZonaPK = regionHasZonaPK;
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regionHasZonaPK != null ? regionHasZonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegionHasZona)) {
            return false;
        }
        RegionHasZona other = (RegionHasZona) object;
        if ((this.regionHasZonaPK == null && other.regionHasZonaPK != null) || (this.regionHasZonaPK != null && !this.regionHasZonaPK.equals(other.regionHasZonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.RegionHasZona[ regionHasZonaPK=" + regionHasZonaPK + " ]";
    }
    
}
