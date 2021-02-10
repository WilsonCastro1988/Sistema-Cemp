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
public class ChecklistHasPesoHasPreguntaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "checklist_id_checklist")
    private long checklistIdChecklist;
    @Basic(optional = false)
    @Column(name = "peso_has_pregunta_peso_id_peso")
    private long pesoHasPreguntaPesoIdPeso;
    @Basic(optional = false)
    @Column(name = "peso_has_pregunta_pregunta_id_pregunta")
    private long pesoHasPreguntaPreguntaIdPregunta;

    public ChecklistHasPesoHasPreguntaPK() {
    }

    public ChecklistHasPesoHasPreguntaPK(long checklistIdChecklist, long pesoHasPreguntaPesoIdPeso, long pesoHasPreguntaPreguntaIdPregunta) {
        this.checklistIdChecklist = checklistIdChecklist;
        this.pesoHasPreguntaPesoIdPeso = pesoHasPreguntaPesoIdPeso;
        this.pesoHasPreguntaPreguntaIdPregunta = pesoHasPreguntaPreguntaIdPregunta;
    }

    public long getChecklistIdChecklist() {
        return checklistIdChecklist;
    }

    public void setChecklistIdChecklist(long checklistIdChecklist) {
        this.checklistIdChecklist = checklistIdChecklist;
    }

    public long getPesoHasPreguntaPesoIdPeso() {
        return pesoHasPreguntaPesoIdPeso;
    }

    public void setPesoHasPreguntaPesoIdPeso(long pesoHasPreguntaPesoIdPeso) {
        this.pesoHasPreguntaPesoIdPeso = pesoHasPreguntaPesoIdPeso;
    }

    public long getPesoHasPreguntaPreguntaIdPregunta() {
        return pesoHasPreguntaPreguntaIdPregunta;
    }

    public void setPesoHasPreguntaPreguntaIdPregunta(long pesoHasPreguntaPreguntaIdPregunta) {
        this.pesoHasPreguntaPreguntaIdPregunta = pesoHasPreguntaPreguntaIdPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) checklistIdChecklist;
        hash += (int) pesoHasPreguntaPesoIdPeso;
        hash += (int) pesoHasPreguntaPreguntaIdPregunta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChecklistHasPesoHasPreguntaPK)) {
            return false;
        }
        ChecklistHasPesoHasPreguntaPK other = (ChecklistHasPesoHasPreguntaPK) object;
        if (this.checklistIdChecklist != other.checklistIdChecklist) {
            return false;
        }
        if (this.pesoHasPreguntaPesoIdPeso != other.pesoHasPreguntaPesoIdPeso) {
            return false;
        }
        if (this.pesoHasPreguntaPreguntaIdPregunta != other.pesoHasPreguntaPreguntaIdPregunta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.ChecklistHasPesoHasPreguntaPK[ checklistIdChecklist=" + checklistIdChecklist + ", pesoHasPreguntaPesoIdPeso=" + pesoHasPreguntaPesoIdPeso + ", pesoHasPreguntaPreguntaIdPregunta=" + pesoHasPreguntaPreguntaIdPregunta + " ]";
    }
    
}
