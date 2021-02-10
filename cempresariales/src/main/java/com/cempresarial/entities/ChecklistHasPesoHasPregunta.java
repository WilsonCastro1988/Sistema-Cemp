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
import javax.persistence.JoinColumns;
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
@Table(name = "checklist_has_peso_has_pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChecklistHasPesoHasPregunta.findAll", query = "SELECT c FROM ChecklistHasPesoHasPregunta c")
    , @NamedQuery(name = "ChecklistHasPesoHasPregunta.findByChecklistIdChecklist", query = "SELECT c FROM ChecklistHasPesoHasPregunta c WHERE c.checklistHasPesoHasPreguntaPK.checklistIdChecklist = :checklistIdChecklist")
    , @NamedQuery(name = "ChecklistHasPesoHasPregunta.findByPesoHasPreguntaPesoIdPeso", query = "SELECT c FROM ChecklistHasPesoHasPregunta c WHERE c.checklistHasPesoHasPreguntaPK.pesoHasPreguntaPesoIdPeso = :pesoHasPreguntaPesoIdPeso")
    , @NamedQuery(name = "ChecklistHasPesoHasPregunta.findByPesoHasPreguntaPreguntaIdPregunta", query = "SELECT c FROM ChecklistHasPesoHasPregunta c WHERE c.checklistHasPesoHasPreguntaPK.pesoHasPreguntaPreguntaIdPregunta = :pesoHasPreguntaPreguntaIdPregunta")
    , @NamedQuery(name = "ChecklistHasPesoHasPregunta.findByActivo", query = "SELECT c FROM ChecklistHasPesoHasPregunta c WHERE c.activo = :activo")})
public class ChecklistHasPesoHasPregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChecklistHasPesoHasPreguntaPK checklistHasPesoHasPreguntaPK;
    @Column(name = "activo")
    private Short activo;
    @JoinColumn(name = "checklist_id_checklist", referencedColumnName = "id_checklist", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Checklist checklist;
    @JoinColumns({
        @JoinColumn(name = "peso_has_pregunta_peso_id_peso", referencedColumnName = "peso_id_peso", insertable = false, updatable = false)
        , @JoinColumn(name = "peso_has_pregunta_pregunta_id_pregunta", referencedColumnName = "pregunta_id_pregunta", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PesoHasPregunta pesoHasPregunta;

    public ChecklistHasPesoHasPregunta() {
    }

    public ChecklistHasPesoHasPregunta(ChecklistHasPesoHasPreguntaPK checklistHasPesoHasPreguntaPK) {
        this.checklistHasPesoHasPreguntaPK = checklistHasPesoHasPreguntaPK;
    }

    public ChecklistHasPesoHasPregunta(long checklistIdChecklist, long pesoHasPreguntaPesoIdPeso, long pesoHasPreguntaPreguntaIdPregunta) {
        this.checklistHasPesoHasPreguntaPK = new ChecklistHasPesoHasPreguntaPK(checklistIdChecklist, pesoHasPreguntaPesoIdPeso, pesoHasPreguntaPreguntaIdPregunta);
    }

    public ChecklistHasPesoHasPreguntaPK getChecklistHasPesoHasPreguntaPK() {
        return checklistHasPesoHasPreguntaPK;
    }

    public void setChecklistHasPesoHasPreguntaPK(ChecklistHasPesoHasPreguntaPK checklistHasPesoHasPreguntaPK) {
        this.checklistHasPesoHasPreguntaPK = checklistHasPesoHasPreguntaPK;
    }

    public Short getActivo() {
        return activo;
    }

    public void setActivo(Short activo) {
        this.activo = activo;
    }

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }

    public PesoHasPregunta getPesoHasPregunta() {
        return pesoHasPregunta;
    }

    public void setPesoHasPregunta(PesoHasPregunta pesoHasPregunta) {
        this.pesoHasPregunta = pesoHasPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checklistHasPesoHasPreguntaPK != null ? checklistHasPesoHasPreguntaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChecklistHasPesoHasPregunta)) {
            return false;
        }
        ChecklistHasPesoHasPregunta other = (ChecklistHasPesoHasPregunta) object;
        if ((this.checklistHasPesoHasPreguntaPK == null && other.checklistHasPesoHasPreguntaPK != null) || (this.checklistHasPesoHasPreguntaPK != null && !this.checklistHasPesoHasPreguntaPK.equals(other.checklistHasPesoHasPreguntaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.ChecklistHasPesoHasPregunta[ checklistHasPesoHasPreguntaPK=" + checklistHasPesoHasPreguntaPK + " ]";
    }
    
}
