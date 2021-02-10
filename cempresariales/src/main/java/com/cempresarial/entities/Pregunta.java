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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p")
    , @NamedQuery(name = "Pregunta.findByIdPregunta", query = "SELECT p FROM Pregunta p WHERE p.idPregunta = :idPregunta")
    , @NamedQuery(name = "Pregunta.findByActivoPregunta", query = "SELECT p FROM Pregunta p WHERE p.activoPregunta = :activoPregunta")
    , @NamedQuery(name = "Pregunta.findByCreaPregunta", query = "SELECT p FROM Pregunta p WHERE p.creaPregunta = :creaPregunta")
    , @NamedQuery(name = "Pregunta.findByNombrePregunta", query = "SELECT p FROM Pregunta p WHERE p.nombrePregunta = :nombrePregunta")})
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pregunta")
    private Long idPregunta;
    @Column(name = "activo_pregunta")
    private Boolean activoPregunta;
    @Column(name = "crea_pregunta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creaPregunta;
    @Column(name = "nombre_pregunta")
    private String nombrePregunta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pregunta")
    @JsonIgnore
    private List<CatalogoPregunta> catalogoPreguntaList;
    @OneToMany(mappedBy = "preguntaIdPregunta")
    @JsonBackReference
    private List<Pregunta> preguntaList;
    @JoinColumn(name = "pregunta_id_pregunta", referencedColumnName = "id_pregunta")
    @ManyToOne
    private Pregunta preguntaIdPregunta;

    public Pregunta() {
    }

    public Pregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Boolean getActivoPregunta() {
        return activoPregunta;
    }

    public void setActivoPregunta(Boolean activoPregunta) {
        this.activoPregunta = activoPregunta;
    }

    public Date getCreaPregunta() {
        return creaPregunta;
    }

    public void setCreaPregunta(Date creaPregunta) {
        this.creaPregunta = creaPregunta;
    }

    public String getNombrePregunta() {
        return nombrePregunta;
    }

    public void setNombrePregunta(String nombrePregunta) {
        this.nombrePregunta = nombrePregunta;
    }


    @XmlTransient
    public List<CatalogoPregunta> getCatalogoPreguntaList() {
        return catalogoPreguntaList;
    }

    public void setCatalogoPreguntaList(List<CatalogoPregunta> catalogoPreguntaList) {
        this.catalogoPreguntaList = catalogoPreguntaList;
    }

    @XmlTransient
    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }

    public Pregunta getPreguntaIdPregunta() {
        return preguntaIdPregunta;
    }

    public void setPreguntaIdPregunta(Pregunta preguntaIdPregunta) {
        this.preguntaIdPregunta = preguntaIdPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.Pregunta[ idPregunta=" + idPregunta + " ]";
    }
    
}
