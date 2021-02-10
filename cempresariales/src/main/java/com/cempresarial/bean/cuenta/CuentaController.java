package com.cempresarial.bean.cuenta;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cempresarial.entities.admin.Usuario;
import com.cempresarial.recursos.SesionController;
import com.cempresarial.rest.client.service.CuentaService;
import com.cempresarial.rest.client.service.UsuarioService;

@ManagedBean(name = "cuentaController")
@SessionScoped
public class CuentaController extends SesionController implements Serializable {

	private static final long serialVersionUID = -468877955954871485L;

	// SERVICIO
	@Inject
	UsuarioService usuarioI;

	// VARIABLES
	private Usuario usuario;
	private String fechaActual;

	@PostConstruct
	public void init() {
		setterVars();
	}

	// METODOS
	public void setterVars() {
		try {

			Date fecha = new Date();
			SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
			this.fechaActual = format.format(fecha);
			this.usuario = getCurrentUser();

			usuarioI.verificaCurrentser();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** SETTERS & GETTERS **/
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(String fechaActual) {
		this.fechaActual = fechaActual;
	}

}