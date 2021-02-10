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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "Empleado.findByActivoEmpleado", query = "SELECT e FROM Empleado e WHERE e.activoEmpleado = :activoEmpleado")
    , @NamedQuery(name = "Empleado.findByApellidoEmpleado", query = "SELECT e FROM Empleado e WHERE e.apellidoEmpleado = :apellidoEmpleado")
    , @NamedQuery(name = "Empleado.findByCiEmpleado", query = "SELECT e FROM Empleado e WHERE e.ciEmpleado = :ciEmpleado")
    , @NamedQuery(name = "Empleado.findByCreaEmpleado", query = "SELECT e FROM Empleado e WHERE e.creaEmpleado = :creaEmpleado")
    , @NamedQuery(name = "Empleado.findByFotoEmpleado", query = "SELECT e FROM Empleado e WHERE e.fotoEmpleado = :fotoEmpleado")
    , @NamedQuery(name = "Empleado.findByGeneroEmpleado", query = "SELECT e FROM Empleado e WHERE e.generoEmpleado = :generoEmpleado")
    , @NamedQuery(name = "Empleado.findByMailEmpleado", query = "SELECT e FROM Empleado e WHERE e.mailEmpleado = :mailEmpleado")
    , @NamedQuery(name = "Empleado.findByNombreEmpleado", query = "SELECT e FROM Empleado e WHERE e.nombreEmpleado = :nombreEmpleado")
    , @NamedQuery(name = "Empleado.findByTelefonoEmpleado", query = "SELECT e FROM Empleado e WHERE e.telefonoEmpleado = :telefonoEmpleado")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private Long idEmpleado;
    @Column(name = "activo_empleado")
    private Boolean activoEmpleado;
    @Column(name = "apellido_empleado")
    private String apellidoEmpleado;
    @Column(name = "ci_empleado")
    private String ciEmpleado;
    @Column(name = "crea_empleado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creaEmpleado;
    @Column(name = "foto_empleado")
    private String fotoEmpleado;
    @Column(name = "genero_empleado")
    private String generoEmpleado;
    @Column(name = "mail_empleado")
    private String mailEmpleado;
    @Column(name = "nombre_empleado")
    private String nombreEmpleado;
    @Column(name = "telefono_empleado")
    private String telefonoEmpleado;
    @JoinColumn(name = "agencia_id_agencia", referencedColumnName = "id_agencia")
    @ManyToOne(optional = false)
    private Agencia agenciaIdAgencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<RolHasEmpleado> rolHasEmpleadoList;

    public Empleado() {
    }

    public Empleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Boolean getActivoEmpleado() {
        return activoEmpleado;
    }

    public void setActivoEmpleado(Boolean activoEmpleado) {
        this.activoEmpleado = activoEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getCiEmpleado() {
        return ciEmpleado;
    }

    public void setCiEmpleado(String ciEmpleado) {
        this.ciEmpleado = ciEmpleado;
    }

    public Date getCreaEmpleado() {
        return creaEmpleado;
    }

    public void setCreaEmpleado(Date creaEmpleado) {
        this.creaEmpleado = creaEmpleado;
    }

    public String getFotoEmpleado() {
        return fotoEmpleado;
    }

    public void setFotoEmpleado(String fotoEmpleado) {
        this.fotoEmpleado = fotoEmpleado;
    }

    public String getGeneroEmpleado() {
        return generoEmpleado;
    }

    public void setGeneroEmpleado(String generoEmpleado) {
        this.generoEmpleado = generoEmpleado;
    }

    public String getMailEmpleado() {
        return mailEmpleado;
    }

    public void setMailEmpleado(String mailEmpleado) {
        this.mailEmpleado = mailEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public Agencia getAgenciaIdAgencia() {
        return agenciaIdAgencia;
    }

    public void setAgenciaIdAgencia(Agencia agenciaIdAgencia) {
        this.agenciaIdAgencia = agenciaIdAgencia;
    }

    @XmlTransient
    public List<RolHasEmpleado> getRolHasEmpleadoList() {
        return rolHasEmpleadoList;
    }

    public void setRolHasEmpleadoList(List<RolHasEmpleado> rolHasEmpleadoList) {
        this.rolHasEmpleadoList = rolHasEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cempresariales.servicio.commons.model.entity.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
