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
public class EvaluacionHasEncabezadoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "evaluacion_id_evaluacion")
    private long evaluacionIdEvaluacion;
    @Basic(optional = false)
    @Column(name = "encabezado_id_encabezado")
    private long encabezadoIdEncabezado;

    public EvaluacionHasEncabezadoPK() {
    }

    public EvaluacionHasEncabezadoPK(long evaluacionIdEvaluacion, long encabezadoIdEncabezado) {
        this.evaluacionIdEvaluacion = evaluacionIdEvaluacion;
        this.encabezadoIdEncabezado = encabezadoIdEncabezado;
    }

    public long getEvaluacionIdEvaluacion() {
        return evaluacionIdEvaluacion;
    }

    public void setEvaluacionIdEvaluacion(long evaluacionIdEvaluacion) {
        this.evaluacionIdEvaluacion = evaluacionIdEvaluacion;
    }

    public long getEncabezadoIdEncabezado() {
        return encabezadoIdEncabezado;
    }

    public void setEncabezadoIdEncabezado(long encabezadoIdEncabezado) {
        this.encabezadoIdEncabezado = encabezadoIdEncabezado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) evaluacionIdEvaluacion;
        hash += (int) encabezadoIdEncabezado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionHasEncabezadoPK)) {
            return false;
        }
        EvaluacionHasEncabezadoPK other = (EvaluacionHasEncabezadoPK) object;
        if (this.evaluacionIdEvaluacion != other.evaluacionIdEvaluacion) {
            return false;
        }
        if (this.encabezadoIdEncabezado != other.encabezadoIdEncabezado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.EvaluacionHasEncabezadoPK[ evaluacionIdEvaluacion=" + evaluacionIdEvaluacion + ", encabezadoIdEncabezado=" + encabezadoIdEncabezado + " ]";
    }
    
}
