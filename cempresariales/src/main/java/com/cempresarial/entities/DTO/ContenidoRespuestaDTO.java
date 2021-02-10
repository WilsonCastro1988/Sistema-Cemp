package com.cempresarial.entities.DTO;

import com.cempresarial.entities.CatalogoPregunta;
import com.cempresarial.entities.Checklist;
import com.cempresarial.entities.Respuesta;

public class ContenidoRespuestaDTO {

	private Respuesta respuesta;
	private CatalogoPregunta catalogoPregunta;
	private Checklist checklist;

	public Respuesta getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

	public CatalogoPregunta getCatalogoPregunta() {
		return catalogoPregunta;
	}

	public void setCatalogoPregunta(CatalogoPregunta catalogoPregunta) {
		this.catalogoPregunta = catalogoPregunta;
	}

	public Checklist getChecklist() {
		return checklist;
	}

	public void setChecklist(Checklist checklist) {
		this.checklist = checklist;
	}

}
