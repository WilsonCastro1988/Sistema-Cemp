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
@Table(name = "zona_estructural")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZonaEstructural.findAll", query = "SELECT z FROM ZonaEstructural z")
    , @NamedQuery(name = "ZonaEstructural.findByIdZonaEstructural", query = "SELECT z FROM ZonaEstructural z WHERE z.idZonaEstructural = :idZonaEstructural")
    , @NamedQuery(name = "ZonaEstructural.findByNombreZonaEstructural", query = "SELECT z FROM ZonaEstructural z WHERE z.nombreZonaEstructural = :nombreZonaEstructural")
    , @NamedQuery(name = "ZonaEstructural.findByFechaCreacionZonaEstructural", query = "SELECT z FROM ZonaEstructural z WHERE z.fechaCreacionZonaEstructural = :fechaCreacionZonaEstructural")
    , @NamedQuery(name = "ZonaEstructural.findByFechaActualizaZonaEstructural", query = "SELECT z FROM ZonaEstructural z WHERE z.fechaActualizaZonaEstructural = :fechaActualizaZonaEstructural")
    , @NamedQuery(name = "ZonaEstructural.findByActivoZonaEstructural", query = "SELECT z FROM ZonaEstructural z WHERE z.activoZonaEstructural = :activoZonaEstructural")})
public class ZonaEstructural implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_zona_estructural")
    private Long idZonaEstructural;
    @Column(name = "nombre_zona_estructural")
    private String nombreZonaEstructural;
    @Column(name = "fecha_creacion_zona_estructural")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionZonaEstructural;
    @Column(name = "fecha_actualiza_zona_estructural")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizaZonaEstructural;
    @Column(name = "activo_zona_estructural")
    private Boolean activoZonaEstructural;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zonaEstructural")
    private List<ZonaEstructuralHasCiudad> zonaEstructuralHasCiudadList;

    public ZonaEstructural() {
    }

    public ZonaEstructural(Long idZonaEstructural) {
        this.idZonaEstructural = idZonaEstructural;
    }

    public Long getIdZonaEstructural() {
        return idZonaEstructural;
    }

    public void setIdZonaEstructural(Long idZonaEstructural) {
        this.idZonaEstructural = idZonaEstructural;
    }

    public String getNombreZonaEstructural() {
        return nombreZonaEstructural;
    }

    public void setNombreZonaEstructural(String nombreZonaEstructural) {
        this.nombreZonaEstructural = nombreZonaEstructural;
    }

    public Date getFechaCreacionZonaEstructural() {
        return fechaCreacionZonaEstructural;
    }

    public void setFechaCreacionZonaEstructural(Date fechaCreacionZonaEstructural) {
        this.fechaCreacionZonaEstructural = fechaCreacionZonaEstructural;
    }

    public Date getFechaActualizaZonaEstructural() {
        return fechaActualizaZonaEstructural;
    }

    public void setFechaActualizaZonaEstructural(Date fechaActualizaZonaEstructural) {
        this.fechaActualizaZonaEstructural = fechaActualizaZonaEstructural;
    }

    public Boolean getActivoZonaEstructural() {
        return activoZonaEstructural;
    }

    public void setActivoZonaEstructural(Boolean activoZonaEstructural) {
        this.activoZonaEstructural = activoZonaEstructural;
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
        hash += (idZonaEstructural != null ? idZonaEstructural.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonaEstructural)) {
            return false;
        }
        ZonaEstructural other = (ZonaEstructural) object;
        if ((this.idZonaEstructural == null && other.idZonaEstructural != null) || (this.idZonaEstructural != null && !this.idZonaEstructural.equals(other.idZonaEstructural))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.ZonaEstructural[ idZonaEstructural=" + idZonaEstructural + " ]";
    }
    
}
