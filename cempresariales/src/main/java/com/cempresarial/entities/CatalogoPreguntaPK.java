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
public class CatalogoPreguntaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "categoria_id_categoria")
    private long categoriaIdCategoria;
    @Basic(optional = false)
    @Column(name = "pregunta_id_pregunta")
    private long preguntaIdPregunta;
    @Basic(optional = false)
    @Column(name = "peso_id_peso")
    private long pesoIdPeso;

    public CatalogoPreguntaPK() {
    }

    public CatalogoPreguntaPK(long categoriaIdCategoria, long preguntaIdPregunta, long pesoIdPeso) {
        this.categoriaIdCategoria = categoriaIdCategoria;
        this.preguntaIdPregunta = preguntaIdPregunta;
        this.pesoIdPeso = pesoIdPeso;
    }

    public long getCategoriaIdCategoria() {
        return categoriaIdCategoria;
    }

    public void setCategoriaIdCategoria(long categoriaIdCategoria) {
        this.categoriaIdCategoria = categoriaIdCategoria;
    }

    public long getPreguntaIdPregunta() {
        return preguntaIdPregunta;
    }

    public void setPreguntaIdPregunta(long preguntaIdPregunta) {
        this.preguntaIdPregunta = preguntaIdPregunta;
    }

    public long getPesoIdPeso() {
        return pesoIdPeso;
    }

    public void setPesoIdPeso(long pesoIdPeso) {
        this.pesoIdPeso = pesoIdPeso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) categoriaIdCategoria;
        hash += (int) preguntaIdPregunta;
        hash += (int) pesoIdPeso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoPreguntaPK)) {
            return false;
        }
        CatalogoPreguntaPK other = (CatalogoPreguntaPK) object;
        if (this.categoriaIdCategoria != other.categoriaIdCategoria) {
            return false;
        }
        if (this.preguntaIdPregunta != other.preguntaIdPregunta) {
            return false;
        }
        if (this.pesoIdPeso != other.pesoIdPeso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.CatalogoPreguntaPK[ categoriaIdCategoria=" + categoriaIdCategoria + ", preguntaIdPregunta=" + preguntaIdPregunta + ", pesoIdPeso=" + pesoIdPeso + " ]";
    }
    
}
