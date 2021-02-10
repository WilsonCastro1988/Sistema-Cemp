/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "peso_has_pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PesoHasPregunta.findAll", query = "SELECT p FROM PesoHasPregunta p")
    , @NamedQuery(name = "PesoHasPregunta.findByPesoIdPeso", query = "SELECT p FROM PesoHasPregunta p WHERE p.pesoHasPreguntaPK.pesoIdPeso = :pesoIdPeso")
    , @NamedQuery(name = "PesoHasPregunta.findByPreguntaIdPregunta", query = "SELECT p FROM PesoHasPregunta p WHERE p.pesoHasPreguntaPK.preguntaIdPregunta = :preguntaIdPregunta")
    , @NamedQuery(name = "PesoHasPregunta.findByActivo", query = "SELECT p FROM PesoHasPregunta p WHERE p.activo = :activo")})
public class PesoHasPregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PesoHasPreguntaPK pesoHasPreguntaPK;
    @Column(name = "activo")
    private Short activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pesoHasPregunta")
    private List<ChecklistHasPesoHasPregunta> checklistHasPesoHasPreguntaList;
    @JoinColumn(name = "peso_id_peso", referencedColumnName = "id_peso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Peso peso;
    @JoinColumn(name = "pregunta_id_pregunta", referencedColumnName = "id_pregunta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pregunta pregunta;

    public PesoHasPregunta() {
    }

    public PesoHasPregunta(PesoHasPreguntaPK pesoHasPreguntaPK) {
        this.pesoHasPreguntaPK = pesoHasPreguntaPK;
    }

    public PesoHasPregunta(long pesoIdPeso, long preguntaIdPregunta) {
        this.pesoHasPreguntaPK = new PesoHasPreguntaPK(pesoIdPeso, preguntaIdPregunta);
    }

    public PesoHasPreguntaPK getPesoHasPreguntaPK() {
        return pesoHasPreguntaPK;
    }

    public void setPesoHasPreguntaPK(PesoHasPreguntaPK pesoHasPreguntaPK) {
        this.pesoHasPreguntaPK = pesoHasPreguntaPK;
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<ChecklistHasPesoHasPregunta> getChecklistHasPesoHasPreguntaList() {
        return checklistHasPesoHasPreguntaList;
    }

    public void setChecklistHasPesoHasPreguntaList(List<ChecklistHasPesoHasPregunta> checklistHasPesoHasPreguntaList) {
        this.checklistHasPesoHasPreguntaList = checklistHasPesoHasPreguntaList;
    }

    public Peso getPeso() {
        return peso;
    }

    public void setPeso(Peso peso) {
        this.peso = peso;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pesoHasPreguntaPK != null ? pesoHasPreguntaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PesoHasPregunta)) {
            return false;
        }
        PesoHasPregunta other = (PesoHasPregunta) object;
        if ((this.pesoHasPreguntaPK == null && other.pesoHasPreguntaPK != null) || (this.pesoHasPreguntaPK != null && !this.pesoHasPreguntaPK.equals(other.pesoHasPreguntaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.PesoHasPregunta[ pesoHasPreguntaPK=" + pesoHasPreguntaPK + " ]";
    }
    
}
