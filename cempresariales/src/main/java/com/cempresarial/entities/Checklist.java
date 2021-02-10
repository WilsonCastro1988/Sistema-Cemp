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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "checklist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checklist.findAll", query = "SELECT c FROM Checklist c")
    , @NamedQuery(name = "Checklist.findByIdChecklist", query = "SELECT c FROM Checklist c WHERE c.idChecklist = :idChecklist")
    , @NamedQuery(name = "Checklist.findByActivoChecklist", query = "SELECT c FROM Checklist c WHERE c.activoChecklist = :activoChecklist")
    , @NamedQuery(name = "Checklist.findByCreaChecklist", query = "SELECT c FROM Checklist c WHERE c.creaChecklist = :creaChecklist")
    , @NamedQuery(name = "Checklist.findByNombreChecklist", query = "SELECT c FROM Checklist c WHERE c.nombreChecklist = :nombreChecklist")})
public class Checklist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_checklist")
    private Long idChecklist;
    @Column(name = "activo_checklist")
    private Boolean activoChecklist;
    @Column(name = "crea_checklist")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creaChecklist;
    @Column(name = "nombre_checklist")
    private String nombreChecklist;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checklist")
    private List<ChecklistHasCatalogoPregunta> checklistHasCatalogoPreguntaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "checklist")
    private List<ChecklistHasEvaluacion> checklistHasEvaluacionList;
    @JoinColumn(name = "rol_id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Rol rolIdRol;

    public Checklist() {
    }

    public Checklist(Long idChecklist) {
        this.idChecklist = idChecklist;
    }

    public Long getIdChecklist() {
        return idChecklist;
    }

    public void setIdChecklist(Long idChecklist) {
        this.idChecklist = idChecklist;
    }

    public Boolean getActivoChecklist() {
        return activoChecklist;
    }

    public void setActivoChecklist(Boolean activoChecklist) {
        this.activoChecklist = activoChecklist;
    }

    public Date getCreaChecklist() {
        return creaChecklist;
    }

    public void setCreaChecklist(Date creaChecklist) {
        this.creaChecklist = creaChecklist;
    }

    public String getNombreChecklist() {
        return nombreChecklist;
    }

    public void setNombreChecklist(String nombreChecklist) {
        this.nombreChecklist = nombreChecklist;
    }

    @XmlTransient
    public List<ChecklistHasCatalogoPregunta> getChecklistHasCatalogoPreguntaList() {
        return checklistHasCatalogoPreguntaList;
    }

    public void setChecklistHasCatalogoPreguntaList(List<ChecklistHasCatalogoPregunta> checklistHasCatalogoPreguntaList) {
        this.checklistHasCatalogoPreguntaList = checklistHasCatalogoPreguntaList;
    }

    @XmlTransient
    public List<ChecklistHasEvaluacion> getChecklistHasEvaluacionList() {
        return checklistHasEvaluacionList;
    }

    public void setChecklistHasEvaluacionList(List<ChecklistHasEvaluacion> checklistHasEvaluacionList) {
        this.checklistHasEvaluacionList = checklistHasEvaluacionList;
    }

    public Rol getRolIdRol() {
        return rolIdRol;
    }

    public void setRolIdRol(Rol rolIdRol) {
        this.rolIdRol = rolIdRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChecklist != null ? idChecklist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checklist)) {
            return false;
        }
        Checklist other = (Checklist) object;
        if ((this.idChecklist == null && other.idChecklist != null) || (this.idChecklist != null && !this.idChecklist.equals(other.idChecklist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.Checklist[ idChecklist=" + idChecklist + " ]";
    }
    
}
