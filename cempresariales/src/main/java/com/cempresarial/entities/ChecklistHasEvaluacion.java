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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "checklist_has_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChecklistHasEvaluacion.findAll", query = "SELECT c FROM ChecklistHasEvaluacion c")
    , @NamedQuery(name = "ChecklistHasEvaluacion.findByChecklistIdChecklist", query = "SELECT c FROM ChecklistHasEvaluacion c WHERE c.checklistHasEvaluacionPK.checklistIdChecklist = :checklistIdChecklist")
    , @NamedQuery(name = "ChecklistHasEvaluacion.findByEvaluacionIdEvaluacion", query = "SELECT c FROM ChecklistHasEvaluacion c WHERE c.checklistHasEvaluacionPK.evaluacionIdEvaluacion = :evaluacionIdEvaluacion")
    , @NamedQuery(name = "ChecklistHasEvaluacion.findByActivo", query = "SELECT c FROM ChecklistHasEvaluacion c WHERE c.activo = :activo")})
public class ChecklistHasEvaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChecklistHasEvaluacionPK checklistHasEvaluacionPK;
    @Column(name = "activo")
    private boolean activo;
    @JoinColumn(name = "checklist_id_checklist", referencedColumnName = "id_checklist", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Checklist checklist;
    @JoinColumn(name = "evaluacion_id_evaluacion", referencedColumnName = "id_evaluacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Evaluacion evaluacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checklistHasEvaluacion")
    @JsonBackReference
    private List<Respuesta> respuestaList;

    public ChecklistHasEvaluacion() {
    }

    public ChecklistHasEvaluacion(ChecklistHasEvaluacionPK checklistHasEvaluacionPK) {
        this.checklistHasEvaluacionPK = checklistHasEvaluacionPK;
    }

    public ChecklistHasEvaluacion(long checklistIdChecklist, long evaluacionIdEvaluacion) {
        this.checklistHasEvaluacionPK = new ChecklistHasEvaluacionPK(checklistIdChecklist, evaluacionIdEvaluacion);
    }

    public ChecklistHasEvaluacionPK getChecklistHasEvaluacionPK() {
        return checklistHasEvaluacionPK;
    }

    public void setChecklistHasEvaluacionPK(ChecklistHasEvaluacionPK checklistHasEvaluacionPK) {
        this.checklistHasEvaluacionPK = checklistHasEvaluacionPK;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    @XmlTransient
    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checklistHasEvaluacionPK != null ? checklistHasEvaluacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChecklistHasEvaluacion)) {
            return false;
        }
        ChecklistHasEvaluacion other = (ChecklistHasEvaluacion) object;
        if ((this.checklistHasEvaluacionPK == null && other.checklistHasEvaluacionPK != null) || (this.checklistHasEvaluacionPK != null && !this.checklistHasEvaluacionPK.equals(other.checklistHasEvaluacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.ChecklistHasEvaluacion[ checklistHasEvaluacionPK=" + checklistHasEvaluacionPK + " ]";
    }
    
}
