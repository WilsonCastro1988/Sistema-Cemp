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
public class ZonaEstructuralHasCiudadPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "zona_estructural_id_zona_estructural")
    private long zonaEstructuralIdZonaEstructural;
    @Basic(optional = false)
    @Column(name = "zona_estructural_id_ciudad")
    private long zonaEstructuralIdCiudad;

    public ZonaEstructuralHasCiudadPK() {
    }

    public ZonaEstructuralHasCiudadPK(int zonaEstructuralIdZonaEstructural, long zonaEstructuralIdCiudad) {
        this.zonaEstructuralIdZonaEstructural = zonaEstructuralIdZonaEstructural;
        this.zonaEstructuralIdCiudad = zonaEstructuralIdCiudad;
    }

    public long getZonaEstructuralIdZonaEstructural() {
        return zonaEstructuralIdZonaEstructural;
    }

    public void setZonaEstructuralIdZonaEstructural(long zonaEstructuralIdZonaEstructural) {
        this.zonaEstructuralIdZonaEstructural = zonaEstructuralIdZonaEstructural;
    }

    public long getZonaEstructuralIdCiudad() {
        return zonaEstructuralIdCiudad;
    }

    public void setZonaEstructuralIdCiudad(long zonaEstructuralIdCiudad) {
        this.zonaEstructuralIdCiudad = zonaEstructuralIdCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) zonaEstructuralIdZonaEstructural;
        hash += (int) zonaEstructuralIdCiudad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonaEstructuralHasCiudadPK)) {
            return false;
        }
        ZonaEstructuralHasCiudadPK other = (ZonaEstructuralHasCiudadPK) object;
        if (this.zonaEstructuralIdZonaEstructural != other.zonaEstructuralIdZonaEstructural) {
            return false;
        }
        if (this.zonaEstructuralIdCiudad != other.zonaEstructuralIdCiudad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.ZonaEstructuralHasCiudadPK[ zonaEstructuralIdZonaEstructural=" + zonaEstructuralIdZonaEstructural + ", ciudadIdCiudad=" + zonaEstructuralIdCiudad + " ]";
    }
    
}
