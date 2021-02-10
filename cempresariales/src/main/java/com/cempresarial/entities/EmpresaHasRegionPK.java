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
public class EmpresaHasRegionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "empresa_id_empresa")
    private long empresaIdEmpresa;
    @Basic(optional = false)
    @Column(name = "region_id_region")
    private long regionIdRegion;

    public EmpresaHasRegionPK() {
    }

    public EmpresaHasRegionPK(long empresaIdEmpresa, long regionIdRegion) {
        this.empresaIdEmpresa = empresaIdEmpresa;
        this.regionIdRegion = regionIdRegion;
    }

    public long getEmpresaIdEmpresa() {
        return empresaIdEmpresa;
    }

    public void setEmpresaIdEmpresa(long empresaIdEmpresa) {
        this.empresaIdEmpresa = empresaIdEmpresa;
    }

    public long getRegionIdRegion() {
        return regionIdRegion;
    }

    public void setRegionIdRegion(long regionIdRegion) {
        this.regionIdRegion = regionIdRegion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empresaIdEmpresa;
        hash += (int) regionIdRegion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaHasRegionPK)) {
            return false;
        }
        EmpresaHasRegionPK other = (EmpresaHasRegionPK) object;
        if (this.empresaIdEmpresa != other.empresaIdEmpresa) {
            return false;
        }
        if (this.regionIdRegion != other.regionIdRegion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.EmpresaHasRegionPK[ empresaIdEmpresa=" + empresaIdEmpresa + ", regionIdRegion=" + regionIdRegion + " ]";
    }
    
}
