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
@Table(name = "zona_has_provincia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZonaHasProvincia.findAll", query = "SELECT z FROM ZonaHasProvincia z")
    , @NamedQuery(name = "ZonaHasProvincia.findByZonaIdZona", query = "SELECT z FROM ZonaHasProvincia z WHERE z.zonaHasProvinciaPK.zonaIdZona = :zonaIdZona")
    , @NamedQuery(name = "ZonaHasProvincia.findByProvinciaIdProvincia", query = "SELECT z FROM ZonaHasProvincia z WHERE z.zonaHasProvinciaPK.provinciaIdProvincia = :provinciaIdProvincia")
    , @NamedQuery(name = "ZonaHasProvincia.findByActivo", query = "SELECT z FROM ZonaHasProvincia z WHERE z.activo = :activo")})
public class ZonaHasProvincia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ZonaHasProvinciaPK zonaHasProvinciaPK;
    @Column(name = "activo")
    private Short activo;
    @JoinColumn(name = "zona_id_zona", referencedColumnName = "id_zona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Zona zona;
    @JoinColumn(name = "provincia_id_provincia", referencedColumnName = "id_provincia", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Provincia provincia;

    public ZonaHasProvincia() {
    }

    public ZonaHasProvincia(ZonaHasProvinciaPK zonaHasProvinciaPK) {
        this.zonaHasProvinciaPK = zonaHasProvinciaPK;
    }

    public ZonaHasProvincia(long zonaIdZona, long provinciaIdProvincia) {
        this.zonaHasProvinciaPK = new ZonaHasProvinciaPK(zonaIdZona, provinciaIdProvincia);
    }

    public ZonaHasProvinciaPK getZonaHasProvinciaPK() {
        return zonaHasProvinciaPK;
    }

    public void setZonaHasProvinciaPK(ZonaHasProvinciaPK zonaHasProvinciaPK) {
        this.zonaHasProvinciaPK = zonaHasProvinciaPK;
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zonaHasProvinciaPK != null ? zonaHasProvinciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonaHasProvincia)) {
            return false;
        }
        ZonaHasProvincia other = (ZonaHasProvincia) object;
        if ((this.zonaHasProvinciaPK == null && other.zonaHasProvinciaPK != null) || (this.zonaHasProvinciaPK != null && !this.zonaHasProvinciaPK.equals(other.zonaHasProvinciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.ZonaHasProvincia[ zonaHasProvinciaPK=" + zonaHasProvinciaPK + " ]";
    }
    
}
