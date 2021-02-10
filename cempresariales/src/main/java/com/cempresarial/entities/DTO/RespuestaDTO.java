package com.cempresarial.entities.DTO;

import java.util.List;

import com.cempresarial.entities.Categoria;

public class RespuestaDTO {

	private Categoria categoria;
	private List<ContenidoRespuestaDTO> listaContenidoRespuesta;
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<ContenidoRespuestaDTO> getListaContenidoRespuesta() {
		return listaContenidoRespuesta;
	}
	public void setListaContenidoRespuesta(List<ContenidoRespuestaDTO> listaContenidoRespuesta) {
		this.listaContenidoRespuesta = listaContenidoRespuesta;
	}

	
	
	
	
}
