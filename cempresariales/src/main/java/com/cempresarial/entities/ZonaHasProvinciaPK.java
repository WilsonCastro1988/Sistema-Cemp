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
public class ZonaHasProvinciaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "zona_id_zona")
    private long zonaIdZona;
    @Basic(optional = false)
    @Column(name = "provincia_id_provincia")
    private long provinciaIdProvincia;

    public ZonaHasProvinciaPK() {
    }

    public ZonaHasProvinciaPK(long zonaIdZona, long provinciaIdProvincia) {
        this.zonaIdZona = zonaIdZona;
        this.provinciaIdProvincia = provinciaIdProvincia;
    }

    public long getZonaIdZona() {
        return zonaIdZona;
    }

    public void setZonaIdZona(long zonaIdZona) {
        this.zonaIdZona = zonaIdZona;
    }

    public long getProvinciaIdProvincia() {
        return provinciaIdProvincia;
    }

    public void setProvinciaIdProvincia(long provinciaIdProvincia) {
        this.provinciaIdProvincia = provinciaIdProvincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) zonaIdZona;
        hash += (int) provinciaIdProvincia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonaHasProvinciaPK)) {
            return false;
        }
        ZonaHasProvinciaPK other = (ZonaHasProvinciaPK) object;
        if (this.zonaIdZona != other.zonaIdZona) {
            return false;
        }
        if (this.provinciaIdProvincia != other.provinciaIdProvincia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.ZonaHasProvinciaPK[ zonaIdZona=" + zonaIdZona + ", provinciaIdProvincia=" + provinciaIdProvincia + " ]";
    }
    
}
