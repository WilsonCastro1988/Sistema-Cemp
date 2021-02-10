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

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "estado_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoEvaluacion.findAll", query = "SELECT e FROM EstadoEvaluacion e")
    , @NamedQuery(name = "EstadoEvaluacion.findByIdEstado", query = "SELECT e FROM EstadoEvaluacion e WHERE e.idEstado = :idEstado")
    , @NamedQuery(name = "EstadoEvaluacion.findByActivoEstado", query = "SELECT e FROM EstadoEvaluacion e WHERE e.activoEstado = :activoEstado")
    , @NamedQuery(name = "EstadoEvaluacion.findByCreaEstado", query = "SELECT e FROM EstadoEvaluacion e WHERE e.creaEstado = :creaEstado")
    , @NamedQuery(name = "EstadoEvaluacion.findByNombreEstado", query = "SELECT e FROM EstadoEvaluacion e WHERE e.nombreEstado = :nombreEstado")})
public class EstadoEvaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado")
    private Long idEstado;
    @Column(name = "activo_estado")
    private Boolean activoEstado;
    @Column(name = "crea_estado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creaEstado;
    @Column(name = "nombre_estado")
    private String nombreEstado;
    @OneToMany(mappedBy = "estadoEvaluacionIdEstado")
    @JsonBackReference
    private List<Evaluacion> evaluacionList;

    public EstadoEvaluacion() {
    }

    public EstadoEvaluacion(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Boolean getActivoEstado() {
        return activoEstado;
    }

    public void setActivoEstado(Boolean activoEstado) {
        this.activoEstado = activoEstado;
    }

    public Date getCreaEstado() {
        return creaEstado;
    }

    public void setCreaEstado(Date creaEstado) {
        this.creaEstado = creaEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoEvaluacion)) {
            return false;
        }
        EstadoEvaluacion other = (EstadoEvaluacion) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.EstadoEvaluacion[ idEstado=" + idEstado + " ]";
    }
    
}
