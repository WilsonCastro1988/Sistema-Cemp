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
public class RolHasEmpleadoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "rol_id_rol")
    private long rolIdRol;
    @Basic(optional = false)
    @Column(name = "empleado_id_empleado")
    private long empleadoIdEmpleado;

    public RolHasEmpleadoPK() {
    }

    public RolHasEmpleadoPK(long rolIdRol, long empleadoIdEmpleado) {
        this.rolIdRol = rolIdRol;
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    public long getRolIdRol() {
        return rolIdRol;
    }

    public void setRolIdRol(long rolIdRol) {
        this.rolIdRol = rolIdRol;
    }

    public long getEmpleadoIdEmpleado() {
        return empleadoIdEmpleado;
    }

    public void setEmpleadoIdEmpleado(long empleadoIdEmpleado) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rolIdRol;
        hash += (int) empleadoIdEmpleado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolHasEmpleadoPK)) {
            return false;
        }
        RolHasEmpleadoPK other = (RolHasEmpleadoPK) object;
        if (this.rolIdRol != other.rolIdRol) {
            return false;
        }
        if (this.empleadoIdEmpleado != other.empleadoIdEmpleado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.RolHasEmpleadoPK[ rolIdRol=" + rolIdRol + ", empleadoIdEmpleado=" + empleadoIdEmpleado + " ]";
    }
    
}
