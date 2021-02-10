/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "encabezado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encabezado.findAll", query = "SELECT e FROM Encabezado e")
    , @NamedQuery(name = "Encabezado.findByIdEncabezado", query = "SELECT e FROM Encabezado e WHERE e.idEncabezado = :idEncabezado")
    , @NamedQuery(name = "Encabezado.findByNombreEncabezado", query = "SELECT e FROM Encabezado e WHERE e.nombreEncabezado = :nombreEncabezado")
    , @NamedQuery(name = "Encabezado.findByEstadoEncabezado", query = "SELECT e FROM Encabezado e WHERE e.estadoEncabezado = :estadoEncabezado")})
public class Encabezado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_encabezado")
    private Long idEncabezado;
    @Column(name = "nombre_encabezado")
    private String nombreEncabezado;
    @Column(name = "estado_encabezado")
    private Boolean estadoEncabezado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encabezado")
    private List<EvaluacionHasEncabezado> evaluacionHasEncabezadoList;

    public Encabezado() {
    }

    public Encabezado(Long idEncabezado) {
        this.idEncabezado = idEncabezado;
    }

    public Long getIdEncabezado() {
        return idEncabezado;
    }

    public void setIdEncabezado(Long idEncabezado) {
        this.idEncabezado = idEncabezado;
    }

    public String getNombreEncabezado() {
        return nombreEncabezado;
    }

    public void setNombreEncabezado(String nombreEncabezado) {
        this.nombreEncabezado = nombreEncabezado;
    }

    public Boolean getEstadoEncabezado() {
        return estadoEncabezado;
    }

    public void setEstadoEncabezado(Boolean estadoEncabezado) {
        this.estadoEncabezado = estadoEncabezado;
    }

    @XmlTransient
    public List<EvaluacionHasEncabezado> getEvaluacionHasEncabezadoList() {
        return evaluacionHasEncabezadoList;
    }

    public void setEvaluacionHasEncabezadoList(List<EvaluacionHasEncabezado> evaluacionHasEncabezadoList) {
        this.evaluacionHasEncabezadoList = evaluacionHasEncabezadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEncabezado != null ? idEncabezado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encabezado)) {
            return false;
        }
        Encabezado other = (Encabezado) object;
        if ((this.idEncabezado == null && other.idEncabezado != null) || (this.idEncabezado != null && !this.idEncabezado.equals(other.idEncabezado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.Encabezado[ idEncabezado=" + idEncabezado + " ]";
    }
    
}
