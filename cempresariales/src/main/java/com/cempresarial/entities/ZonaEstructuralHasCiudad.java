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
@Table(name = "zona_estructural_has_ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZonaEstructuralHasCiudad.findAll", query = "SELECT z FROM ZonaEstructuralHasCiudad z")
    , @NamedQuery(name = "ZonaEstructuralHasCiudad.findByZonaEstructuralIdZonaEstructural", query = "SELECT z FROM ZonaEstructuralHasCiudad z WHERE z.zonaEstructuralHasCiudadPK.zonaEstructuralIdZonaEstructural = :zonaEstructuralIdZonaEstructural")
    , @NamedQuery(name = "ZonaEstructuralHasCiudad.findByZonaEstructuralIdCiudad", query = "SELECT z FROM ZonaEstructuralHasCiudad z WHERE z.zonaEstructuralHasCiudadPK.zonaEstructuralIdCiudad = :zonaEstructuralIdCiudad")
    , @NamedQuery(name = "ZonaEstructuralHasCiudad.findByActivoZonaEstructuralHasCiudad", query = "SELECT z FROM ZonaEstructuralHasCiudad z WHERE z.activoZonaEstructuralHasCiudad = :activoZonaEstructuralHasCiudad")})
public class ZonaEstructuralHasCiudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ZonaEstructuralHasCiudadPK zonaEstructuralHasCiudadPK;
    @Column(name = "activo_zona_estructural_has_ciudad")
    private Boolean activoZonaEstructuralHasCiudad;
    @JoinColumn(name = "zona_estructural_id_ciudad", referencedColumnName = "id_ciudad", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Ciudad ciudad;
    @JoinColumn(name = "zona_estructural_id_zona_estructural", referencedColumnName = "id_zona_estructural", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private ZonaEstructural zonaEstructural;

    public ZonaEstructuralHasCiudad() {
    }

    public ZonaEstructuralHasCiudad(ZonaEstructuralHasCiudadPK zonaEstructuralHasCiudadPK) {
        this.zonaEstructuralHasCiudadPK = zonaEstructuralHasCiudadPK;
    }

    public ZonaEstructuralHasCiudad(int zonaEstructuralIdZonaEstructural, long ciudadIdCiudad) {
        this.zonaEstructuralHasCiudadPK = new ZonaEstructuralHasCiudadPK(zonaEstructuralIdZonaEstructural, ciudadIdCiudad);
    }

    public ZonaEstructuralHasCiudadPK getZonaEstructuralHasCiudadPK() {
        return zonaEstructuralHasCiudadPK;
    }

    public void setZonaEstructuralHasCiudadPK(ZonaEstructuralHasCiudadPK zonaEstructuralHasCiudadPK) {
        this.zonaEstructuralHasCiudadPK = zonaEstructuralHasCiudadPK;
    }

    public Boolean getActivoZonaEstructuralHasCiudad() {
        return activoZonaEstructuralHasCiudad;
    }

    public void setActivoZonaEstructuralHasCiudad(Boolean activoZonaEstructuralHasCiudad) {
        this.activoZonaEstructuralHasCiudad = activoZonaEstructuralHasCiudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public ZonaEstructural getZonaEstructural() {
        return zonaEstructural;
    }

    public void setZonaEstructural(ZonaEstructural zonaEstructural) {
        this.zonaEstructural = zonaEstructural;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zonaEstructuralHasCiudadPK != null ? zonaEstructuralHasCiudadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonaEstructuralHasCiudad)) {
            return false;
        }
        ZonaEstructuralHasCiudad other = (ZonaEstructuralHasCiudad) object;
        if ((this.zonaEstructuralHasCiudadPK == null && other.zonaEstructuralHasCiudadPK != null) || (this.zonaEstructuralHasCiudadPK != null && !this.zonaEstructuralHasCiudadPK.equals(other.zonaEstructuralHasCiudadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.ZonaEstructuralHasCiudad[ zonaEstructuralHasCiudadPK=" + zonaEstructuralHasCiudadPK + " ]";
    }
    
}
