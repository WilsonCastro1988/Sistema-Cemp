/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ADM-DGIP
 */
@Embeddable
public class RegionHasZonaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "region_id_region")
    private long regionIdRegion;
    @Basic(optional = false)
    @Column(name = "zona_id_zona")
    private long zonaIdZona;

    public RegionHasZonaPK() {
    }

    public RegionHasZonaPK(long regionIdRegion, long zonaIdZona) {
        this.regionIdRegion = regionIdRegion;
        this.zonaIdZona = zonaIdZona;
    }

    public long getRegionIdRegion() {
        return regionIdRegion;
    }

    public void setRegionIdRegion(long regionIdRegion) {
        this.regionIdRegion = regionIdRegion;
    }

    public long getZonaIdZona() {
        return zonaIdZona;
    }

    public void setZonaIdZona(long zonaIdZona) {
        this.zonaIdZona = zonaIdZona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) regionIdRegion;
        hash += (int) zonaIdZona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegionHasZonaPK)) {
            return false;
        }
        RegionHasZonaPK other = (RegionHasZonaPK) object;
        if (this.regionIdRegion != other.regionIdRegion) {
            return false;
        }
        if (this.zonaIdZona != other.zonaIdZona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.RegionHasZonaPK[ regionIdRegion=" + regionIdRegion + ", zonaIdZona=" + zonaIdZona + " ]";
    }
    
}
