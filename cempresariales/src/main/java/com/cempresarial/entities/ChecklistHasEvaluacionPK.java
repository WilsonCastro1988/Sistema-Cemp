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
public class ChecklistHasEvaluacionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "checklist_id_checklist")
    private long checklistIdChecklist;
    @Basic(optional = false)
    @Column(name = "evaluacion_id_evaluacion")
    private long evaluacionIdEvaluacion;

    public ChecklistHasEvaluacionPK() {
    }

    public ChecklistHasEvaluacionPK(long checklistIdChecklist, long evaluacionIdEvaluacion) {
        this.checklistIdChecklist = checklistIdChecklist;
        this.evaluacionIdEvaluacion = evaluacionIdEvaluacion;
    }

    public long getChecklistIdChecklist() {
        return checklistIdChecklist;
    }

    public void setChecklistIdChecklist(long checklistIdChecklist) {
        this.checklistIdChecklist = checklistIdChecklist;
    }

    public long getEvaluacionIdEvaluacion() {
        return evaluacionIdEvaluacion;
    }

    public void setEvaluacionIdEvaluacion(long evaluacionIdEvaluacion) {
        this.evaluacionIdEvaluacion = evaluacionIdEvaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) checklistIdChecklist;
        hash += (int) evaluacionIdEvaluacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChecklistHasEvaluacionPK)) {
            return false;
        }
        ChecklistHasEvaluacionPK other = (ChecklistHasEvaluacionPK) object;
        if (this.checklistIdChecklist != other.checklistIdChecklist) {
            return false;
        }
        if (this.evaluacionIdEvaluacion != other.evaluacionIdEvaluacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.ChecklistHasEvaluacionPK[ checklistIdChecklist=" + checklistIdChecklist + ", evaluacionIdEvaluacion=" + evaluacionIdEvaluacion + " ]";
    }
    
}
