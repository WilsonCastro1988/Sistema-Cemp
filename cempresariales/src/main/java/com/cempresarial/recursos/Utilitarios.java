package com.cempresarial.recursos;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class Utilitarios implements Serializable {

	private static final long serialVersionUID = 5627070176361650393L;

	private FacesMessage msg = null;

	/** Navega entre paginas **/
	public String navegaPagina(String pagina) {
		try {
			return pagina + "?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			return "#";
		}
	}

	/** Abre y cierra los paneles modal de paginas **/
	public void ejecutarPaneles(String panel, String orden) {
		try {

			if (orden.toUpperCase().equals("S"))
				PrimeFaces.current().executeScript("PF('" + panel + "').show()");
			else
				PrimeFaces.current().executeScript("PF('" + panel + "').hide()");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Muestra los mensajes growl de las paginas dependiendi de las iniciales de
	 * severetyInfo
	 **/
	public void mostrarMensaje(String titulo, String mensaje, String tipo) {
		try {
			msg = new FacesMessage(mensaje);
			if (tipo.toUpperCase().equals("I"))
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensaje));
			if (tipo.toUpperCase().equals("W"))
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, mensaje));
			if (tipo.toUpperCase().equals("E"))
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, mensaje));
			if (tipo.toUpperCase().equals("F"))
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, mensaje));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StreamedContent obtenerImagen(byte[] plano) {

		try {
			InputStream is = new ByteArrayInputStream(plano);
			StreamedContent image = new DefaultStreamedContent(is);
			return image;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
