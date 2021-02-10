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
@Table(name = "checklist_has_catalogo_pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChecklistHasCatalogoPregunta.findAll", query = "SELECT c FROM ChecklistHasCatalogoPregunta c")
    , @NamedQuery(name = "ChecklistHasCatalogoPregunta.findByChecklistIdChecklist", query = "SELECT c FROM ChecklistHasCatalogoPregunta c WHERE c.checklistHasCatalogoPreguntaPK.checklistIdChecklist = :checklistIdChecklist")
    , @NamedQuery(name = "ChecklistHasCatalogoPregunta.findByCatalogoPreguntaCategoriaIdCategoria", query = "SELECT c FROM ChecklistHasCatalogoPregunta c WHERE c.checklistHasCatalogoPreguntaPK.catalogoPreguntaCategoriaIdCategoria = :catalogoPreguntaCategoriaIdCategoria")
    , @NamedQuery(name = "ChecklistHasCatalogoPregunta.findByCatalogoPreguntaPreguntaIdPregunta", query = "SELECT c FROM ChecklistHasCatalogoPregunta c WHERE c.checklistHasCatalogoPreguntaPK.catalogoPreguntaPreguntaIdPregunta = :catalogoPreguntaPreguntaIdPregunta")
    , @NamedQuery(name = "ChecklistHasCatalogoPregunta.findByCatalogoPreguntaPesoIdPeso", query = "SELECT c FROM ChecklistHasCatalogoPregunta c WHERE c.checklistHasCatalogoPreguntaPK.catalogoPreguntaPesoIdPeso = :catalogoPreguntaPesoIdPeso")
    , @NamedQuery(name = "ChecklistHasCatalogoPregunta.findByActivo", query = "SELECT c FROM ChecklistHasCatalogoPregunta c WHERE c.activo = :activo")})
public class ChecklistHasCatalogoPregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChecklistHasCatalogoPreguntaPK checklistHasCatalogoPreguntaPK;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "orden_bloque")
    private int ordenBloque;
    @JoinColumns({
        @JoinColumn(name = "catalogo_pregunta_categoria_id_categoria", referencedColumnName = "categoria_id_categoria", insertable = false, updatable = false)
        , @JoinColumn(name = "catalogo_pregunta_pregunta_id_pregunta", referencedColumnName = "pregunta_id_pregunta", insertable = false, updatable = false)
        , @JoinColumn(name = "catalogo_pregunta_peso_id_peso", referencedColumnName = "peso_id_peso", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    @JsonIgnore
    private CatalogoPregunta catalogoPregunta;
    @JoinColumn(name = "checklist_id_checklist", referencedColumnName = "id_checklist", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private Checklist checklist;

    public ChecklistHasCatalogoPregunta() {
    }

    public ChecklistHasCatalogoPregunta(ChecklistHasCatalogoPreguntaPK checklistHasCatalogoPreguntaPK) {
        this.checklistHasCatalogoPreguntaPK = checklistHasCatalogoPreguntaPK;
    }

    public ChecklistHasCatalogoPregunta(long checklistIdChecklist, long catalogoPreguntaCategoriaIdCategoria, long catalogoPreguntaPreguntaIdPregunta, long catalogoPreguntaPesoIdPeso) {
        this.checklistHasCatalogoPreguntaPK = new ChecklistHasCatalogoPreguntaPK(checklistIdChecklist, catalogoPreguntaCategoriaIdCategoria, catalogoPreguntaPreguntaIdPregunta, catalogoPreguntaPesoIdPeso);
    }

    public ChecklistHasCatalogoPreguntaPK getChecklistHasCatalogoPreguntaPK() {
        return checklistHasCatalogoPreguntaPK;
    }

    public void setChecklistHasCatalogoPreguntaPK(ChecklistHasCatalogoPreguntaPK checklistHasCatalogoPreguntaPK) {
        this.checklistHasCatalogoPreguntaPK = checklistHasCatalogoPreguntaPK;
    }
    
    
    
    

    public int getOrdenBloque() {
		return ordenBloque;
	}

	public void setOrdenBloque(int ordenBloque) {
		this.ordenBloque = ordenBloque;
	}

	public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public CatalogoPregunta getCatalogoPregunta() {
        return catalogoPregunta;
    }

    public void setCatalogoPregunta(CatalogoPregunta catalogoPregunta) {
        this.catalogoPregunta = catalogoPregunta;
    }

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checklistHasCatalogoPreguntaPK != null ? checklistHasCatalogoPreguntaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChecklistHasCatalogoPregunta)) {
            return false;
        }
        ChecklistHasCatalogoPregunta other = (ChecklistHasCatalogoPregunta) object;
        if ((this.checklistHasCatalogoPreguntaPK == null && other.checklistHasCatalogoPreguntaPK != null) || (this.checklistHasCatalogoPreguntaPK != null && !this.checklistHasCatalogoPreguntaPK.equals(other.checklistHasCatalogoPreguntaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.ChecklistHasCatalogoPregunta[ checklistHasCatalogoPreguntaPK=" + checklistHasCatalogoPreguntaPK + " ]";
    }
    
}
