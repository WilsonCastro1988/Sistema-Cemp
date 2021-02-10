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
public class PesoHasPreguntaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "peso_id_peso")
    private long pesoIdPeso;
    @Basic(optional = false)
    @Column(name = "pregunta_id_pregunta")
    private long preguntaIdPregunta;

    public PesoHasPreguntaPK() {
    }

    public PesoHasPreguntaPK(long pesoIdPeso, long preguntaIdPregunta) {
        this.pesoIdPeso = pesoIdPeso;
        this.preguntaIdPregunta = preguntaIdPregunta;
    }

    public long getPesoIdPeso() {
        return pesoIdPeso;
    }

    public void setPesoIdPeso(long pesoIdPeso) {
        this.pesoIdPeso = pesoIdPeso;
    }

    public long getPreguntaIdPregunta() {
        return preguntaIdPregunta;
    }

    public void setPreguntaIdPregunta(long preguntaIdPregunta) {
        this.preguntaIdPregunta = preguntaIdPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pesoIdPeso;
        hash += (int) preguntaIdPregunta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PesoHasPreguntaPK)) {
            return false;
        }
        PesoHasPreguntaPK other = (PesoHasPreguntaPK) object;
        if (this.pesoIdPeso != other.pesoIdPeso) {
            return false;
        }
        if (this.preguntaIdPregunta != other.preguntaIdPregunta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.PesoHasPreguntaPK[ pesoIdPeso=" + pesoIdPeso + ", preguntaIdPregunta=" + preguntaIdPregunta + " ]";
    }
    
}
