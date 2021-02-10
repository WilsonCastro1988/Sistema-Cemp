package com.cempresarial.entities;

import java.io.Serializable;

public class PreguntaDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1270280241931965200L;
	
	private Long idPregunta;
	private Long idPeso;
	private String nombrePregunta;
	private String respuestaPregunta;
	private String pesoPregunta;
	private String valorPregunta;
	private String porcentajePregunta;

	public PreguntaDto() {					
	}

	public PreguntaDto(Long idPregunta, Long idPeso, String nombrePregunta, String respuestaPregunta,
			String pesoPregunta, String valorPregunta, String porcentajePregunta) {
		super();
		this.idPregunta = idPregunta;
		this.idPeso = idPeso;
		this.nombrePregunta = nombrePregunta;
		this.respuestaPregunta = respuestaPregunta;
		this.pesoPregunta = pesoPregunta;
		this.valorPregunta = valorPregunta;
		this.porcentajePregunta = porcentajePregunta;
	}

	public Long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public Long getIdPeso() {
		return idPeso;
	}

	public void setIdPeso(Long idPeso) {
		this.idPeso = idPeso;
	}

	public String getNombrePregunta() {
		return nombrePregunta;
	}

	public void setNombrePregunta(String nombrePregunta) {
		this.nombrePregunta = nombrePregunta;
	}

	public String getRespuestaPregunta() {
		return respuestaPregunta;
	}

	public void setRespuestaPregunta(String respuestaPregunta) {
		this.respuestaPregunta = respuestaPregunta;
	}

	public String getPesoPregunta() {
		return pesoPregunta;
	}

	public void setPesoPregunta(String pesoPregunta) {
		this.pesoPregunta = pesoPregunta;
	}

	public String getValorPregunta() {
		return valorPregunta;
	}

	public void setValorPregunta(String valorPregunta) {
		this.valorPregunta = valorPregunta;
	}

	public String getPorcentajePregunta() {
		return porcentajePregunta;
	}

	public void setPorcentajePregunta(String porcentajePregunta) {
		this.porcentajePregunta = porcentajePregunta;
	}
	
	
}
