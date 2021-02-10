/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "respuesta")
@XmlRootElement
public class Respuesta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_respuesta")
	private Long idRespuesta;
	@Basic(optional = false)
	@Column(name = "id_catalogo_pregunta")
	private Long idCatalogoPregunta;
	@Column(name = "cumple_respuesta")
	private boolean cumpleRespuesta;
	@Column(name = "observacion_respuesta")
	private String observacionRespuesta;
	@Column(name = "no_procede")
	private boolean noProcede;
	@Column(name = "porcentaje_respuesta")
	private int porcentajeRespuesta;
	@Column(name = "peso_respuesta")
	private int pesoRespuesta;
	@Column(name = "valor_real_respuesta")
	private double valorRealRespuesta;
	@Column(name = "valor_calculado_respuesta")
	private double valorCalculadoRespuesta;

	@JoinColumns({
			@JoinColumn(name = "checklist_has_evaluacion_checklist_id_checklist", referencedColumnName = "checklist_id_checklist"),
			@JoinColumn(name = "checklist_has_evaluacion_evaluacion_id_evaluacion", referencedColumnName = "evaluacion_id_evaluacion") })
	@ManyToOne(optional = false)
	private ChecklistHasEvaluacion checklistHasEvaluacion;

	public Respuesta() {
	}

	public Respuesta(Long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	

	public int getPorcentajeRespuesta() {
		return porcentajeRespuesta;
	}

	public void setPorcentajeRespuesta(int porcentajeRespuesta) {
		this.porcentajeRespuesta = porcentajeRespuesta;
	}

	public int getPesoRespuesta() {
		return pesoRespuesta;
	}

	public void setPesoRespuesta(int pesoRespuesta) {
		this.pesoRespuesta = pesoRespuesta;
	}

	public double getValorRealRespuesta() {
		return valorRealRespuesta;
	}

	public void setValorRealRespuesta(double valorRealRespuesta) {
		this.valorRealRespuesta = valorRealRespuesta;
	}

	public double getValorCalculadoRespuesta() {
		return valorCalculadoRespuesta;
	}

	public void setValorCalculadoRespuesta(double valorCalculadoRespuesta) {
		this.valorCalculadoRespuesta = valorCalculadoRespuesta;
	}

	public Long getIdCatalogoPregunta() {
		return idCatalogoPregunta;
	}

	public void setIdCatalogoPregunta(Long idCatalogoPregunta) {
		this.idCatalogoPregunta = idCatalogoPregunta;
	}

	public boolean getNoProcede() {
		return noProcede;
	}

	public void setNoProcede(boolean noProcede) {
		this.noProcede = noProcede;
	}

	public Long getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(Long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public boolean getCumpleRespuesta() {
		return cumpleRespuesta;
	}

	public void setCumpleRespuesta(boolean cumpleRespuesta) {
		this.cumpleRespuesta = cumpleRespuesta;
	}

	public String getObservacionRespuesta() {
		return observacionRespuesta;
	}

	public void setObservacionRespuesta(String observacionRespuesta) {
		this.observacionRespuesta = observacionRespuesta;
	}

	public ChecklistHasEvaluacion getChecklistHasEvaluacion() {
		return checklistHasEvaluacion;
	}

	public void setChecklistHasEvaluacion(ChecklistHasEvaluacion checklistHasEvaluacion) {
		this.checklistHasEvaluacion = checklistHasEvaluacion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idRespuesta != null ? idRespuesta.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Respuesta)) {
			return false;
		}
		Respuesta other = (Respuesta) object;
		if ((this.idRespuesta == null && other.idRespuesta != null)
				|| (this.idRespuesta != null && !this.idRespuesta.equals(other.idRespuesta))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.cempresariales.servicio.commons.model.entity.Respuesta[ idRespuesta=" + idRespuesta + " ]";
	}

}
