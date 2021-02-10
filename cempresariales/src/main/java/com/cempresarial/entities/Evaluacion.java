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

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "evaluacion")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
		@NamedQuery(name = "Evaluacion.findByIdEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.idEvaluacion = :idEvaluacion"),
		@NamedQuery(name = "Evaluacion.findByActivoEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.activoEvaluacion = :activoEvaluacion"),
		@NamedQuery(name = "Evaluacion.findByFechaEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.fechaEvaluacion = :fechaEvaluacion"),
		@NamedQuery(name = "Evaluacion.findByCreaEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.creaEvaluacion = :creaEvaluacion"),
		@NamedQuery(name = "Evaluacion.findByPromedioPregunta", query = "SELECT e FROM Evaluacion e WHERE e.promedioPregunta = :promedioPregunta"),
		@NamedQuery(name = "Evaluacion.findByPromedioSeccion", query = "SELECT e FROM Evaluacion e WHERE e.promedioSeccion = :promedioSeccion"),
		@NamedQuery(name = "Evaluacion.findByPromedioTotal", query = "SELECT e FROM Evaluacion e WHERE e.promedioTotal = :promedioTotal"),
		@NamedQuery(name = "Evaluacion.findByPuntajeEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.puntajeEvaluacion = :puntajeEvaluacion"),
		@NamedQuery(name = "Evaluacion.findByAtencionEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.atencionEvaluacion = :atencionEvaluacion"),
		@NamedQuery(name = "Evaluacion.findByContactoEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.contactoEvaluacion = :contactoEvaluacion"),
		@NamedQuery(name = "Evaluacion.findByEsperaEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.esperaEvaluacion = :esperaEvaluacion"),
		@NamedQuery(name = "Evaluacion.findByHoraFinEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.horaFinEvaluacion = :horaFinEvaluacion"),
		@NamedQuery(name = "Evaluacion.findByHoraInicioEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.horaInicioEvaluacion = :horaInicioEvaluacion"),
		@NamedQuery(name = "Evaluacion.findByVideoEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.videoEvaluacion = :videoEvaluacion"),
		@NamedQuery(name = "Evaluacion.findByObservacionEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.observacionEvaluacion = :observacionEvaluacion") })
public class Evaluacion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_evaluacion")
	private Long idEvaluacion;
	@Column(name = "activo_evaluacion")
	private Boolean activoEvaluacion;
	@Column(name = "fecha_evaluacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEvaluacion;
	@Column(name = "crea_evaluacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creaEvaluacion;
	@Column(name = "promedio_pregunta")
	private String promedioPregunta;
	@Column(name = "promedio_seccion")
	private String promedioSeccion;
	@Column(name = "promedio_total")
	private String promedioTotal;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "puntaje_evaluacion")
	private Float puntajeEvaluacion;
	@Column(name = "atencion_evaluacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date atencionEvaluacion;
	@Column(name = "contacto_evaluacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date contactoEvaluacion;
	@Column(name = "espera_evaluacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date esperaEvaluacion;
	@Column(name = "hora_fin_evaluacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaFinEvaluacion;
	@Column(name = "hora_inicio_evaluacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaInicioEvaluacion;
	@Column(name = "video_evaluacion")
	private String videoEvaluacion;
	@Column(name = "observacion_evaluacion")
	private String observacionEvaluacion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluacion")
	private List<EvaluacionHasEncabezado> evaluacionHasEncabezadoList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluacion")
	@JsonBackReference
	private List<ChecklistHasEvaluacion> checklistHasEvaluacionList;
	@JoinColumn(name = "estado_evaluacion_id_estado", referencedColumnName = "id_estado")
	@ManyToOne
	private EstadoEvaluacion estadoEvaluacionIdEstado;
	@Column(name = "id_empleado")
	private Long idEmpleado;
	@Column(name = "id_evaluacion_historial")
	private Long idEvaluacionHistorial;
	@Column(name = "id_usuario_crea")
	private Long idUsuarioCrea;
	@Column(name = "id_usuario_planifica")
	private Long idUsuarioPlanifica;
	@Column(name = "id_usuario_ejecuta")
	private Long idUsuarioEjecuta;
	
	public Evaluacion() {
	}

	public Evaluacion(Long idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	

	public Long getIdUsuarioCrea() {
		return idUsuarioCrea;
	}

	public void setIdUsuarioCrea(Long idUsuarioCrea) {
		this.idUsuarioCrea = idUsuarioCrea;
	}

	public Long getIdUsuarioPlanifica() {
		return idUsuarioPlanifica;
	}

	public void setIdUsuarioPlanifica(Long idUsuarioPlanifica) {
		this.idUsuarioPlanifica = idUsuarioPlanifica;
	}

	public Long getIdUsuarioEjecuta() {
		return idUsuarioEjecuta;
	}

	public void setIdUsuarioEjecuta(Long idUsuarioEjecuta) {
		this.idUsuarioEjecuta = idUsuarioEjecuta;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Long getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(Long idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public Long getIdEvaluacionHistorial() {
		return idEvaluacionHistorial;
	}

	public void setIdEvaluacionHistorial(Long idEvaluacionHistorial) {
		this.idEvaluacionHistorial = idEvaluacionHistorial;
	}

	public Boolean getActivoEvaluacion() {
		return activoEvaluacion;
	}

	public void setActivoEvaluacion(Boolean activoEvaluacion) {
		this.activoEvaluacion = activoEvaluacion;
	}

	public Date getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	public Date getCreaEvaluacion() {
		return creaEvaluacion;
	}

	public void setCreaEvaluacion(Date creaEvaluacion) {
		this.creaEvaluacion = creaEvaluacion;
	}

	public String getPromedioPregunta() {
		return promedioPregunta;
	}

	public void setPromedioPregunta(String promedioPregunta) {
		this.promedioPregunta = promedioPregunta;
	}

	public String getPromedioSeccion() {
		return promedioSeccion;
	}

	public void setPromedioSeccion(String promedioSeccion) {
		this.promedioSeccion = promedioSeccion;
	}

	public String getPromedioTotal() {
		return promedioTotal;
	}

	public void setPromedioTotal(String promedioTotal) {
		this.promedioTotal = promedioTotal;
	}

	public Float getPuntajeEvaluacion() {
		return puntajeEvaluacion;
	}

	public void setPuntajeEvaluacion(Float puntajeEvaluacion) {
		this.puntajeEvaluacion = puntajeEvaluacion;
	}

	public Date getAtencionEvaluacion() {
		return atencionEvaluacion;
	}

	public void setAtencionEvaluacion(Date atencionEvaluacion) {
		this.atencionEvaluacion = atencionEvaluacion;
	}

	public Date getContactoEvaluacion() {
		return contactoEvaluacion;
	}

	public void setContactoEvaluacion(Date contactoEvaluacion) {
		this.contactoEvaluacion = contactoEvaluacion;
	}

	public Date getEsperaEvaluacion() {
		return esperaEvaluacion;
	}

	public void setEsperaEvaluacion(Date esperaEvaluacion) {
		this.esperaEvaluacion = esperaEvaluacion;
	}

	public Date getHoraFinEvaluacion() {
		return horaFinEvaluacion;
	}

	public void setHoraFinEvaluacion(Date horaFinEvaluacion) {
		this.horaFinEvaluacion = horaFinEvaluacion;
	}

	public Date getHoraInicioEvaluacion() {
		return horaInicioEvaluacion;
	}

	public void setHoraInicioEvaluacion(Date horaInicioEvaluacion) {
		this.horaInicioEvaluacion = horaInicioEvaluacion;
	}

	public String getVideoEvaluacion() {
		return videoEvaluacion;
	}

	public void setVideoEvaluacion(String videoEvaluacion) {
		this.videoEvaluacion = videoEvaluacion;
	}

	public String getObservacionEvaluacion() {
		return observacionEvaluacion;
	}

	public void setObservacionEvaluacion(String observacionEvaluacion) {
		this.observacionEvaluacion = observacionEvaluacion;
	}

	@XmlTransient
	public List<EvaluacionHasEncabezado> getEvaluacionHasEncabezadoList() {
		return evaluacionHasEncabezadoList;
	}

	public void setEvaluacionHasEncabezadoList(List<EvaluacionHasEncabezado> evaluacionHasEncabezadoList) {
		this.evaluacionHasEncabezadoList = evaluacionHasEncabezadoList;
	}

	@XmlTransient
	public List<ChecklistHasEvaluacion> getChecklistHasEvaluacionList() {
		return checklistHasEvaluacionList;
	}

	public void setChecklistHasEvaluacionList(List<ChecklistHasEvaluacion> checklistHasEvaluacionList) {
		this.checklistHasEvaluacionList = checklistHasEvaluacionList;
	}

	public EstadoEvaluacion getEstadoEvaluacionIdEstado() {
		return estadoEvaluacionIdEstado;
	}

	public void setEstadoEvaluacionIdEstado(EstadoEvaluacion estadoEvaluacionIdEstado) {
		this.estadoEvaluacionIdEstado = estadoEvaluacionIdEstado;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idEvaluacion != null ? idEvaluacion.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Evaluacion)) {
			return false;
		}
		Evaluacion other = (Evaluacion) object;
		if ((this.idEvaluacion == null && other.idEvaluacion != null)
				|| (this.idEvaluacion != null && !this.idEvaluacion.equals(other.idEvaluacion))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.cempresariales.servicio.commons.model.entity.Evaluacion[ idEvaluacion=" + idEvaluacion + " ]";
	}

}
