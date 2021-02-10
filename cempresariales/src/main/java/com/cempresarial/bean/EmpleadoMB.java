/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.bean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

import com.cempresarial.entities.Agencia;
import com.cempresarial.entities.Empleado;
import com.cempresarial.entities.Provincia;
import com.cempresarial.entities.Rol;
import com.cempresarial.entities.RolHasEmpleado;
import com.cempresarial.entities.RolHasEmpleadoPK;
import com.cempresarial.entities.ZonaHasProvincia;
import com.cempresarial.entities.ZonaHasProvinciaPK;
import com.cempresarial.recursos.Utilitarios;
import com.cempresarial.rest.client.service.AgenciaService;
import com.cempresarial.rest.client.service.EmpleadoHasRolService;
import com.cempresarial.rest.client.service.EmpleadoService;
import com.cempresarial.rest.client.service.RolService;

/**
 *
 * @author DIGETBI 05
 */
@ManagedBean
@SessionScoped
public class EmpleadoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EmpleadoService empleadoService;
	@Inject
	private AgenciaService agenciaService;
	@Inject
	private RolService rolService;
	@Inject
	private EmpleadoHasRolService ehrService;

	private List<Empleado> listaEmpleados;
	private List<Rol> listaRoles;
	private List<Agencia> listaAgencias;
	private List<RolHasEmpleado> listaRolHasEmpleado;

	private List<String> listaCheckRoles;

	private Empleado empleadoSeleccionado;
	private Agencia agencia;

	private Long idAgencia;
	private Long idRol;

	private UploadedFile file2;
	private StreamedContent foto;
	// cambiar entre linux o mac o windows
	private String pathimages = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
	private String pathWindows = "C:\\Users\\ADM-DGIP\\Pictures\\Saved Pictures\\";
	private String pathLinux = "usr/cempresarial/";
	private String pathMac = "usr/cempresarial/";

	private Utilitarios utils;

	@PostConstruct
	public void init() {
		this.clear();
	}

	public void clear() {

		listaRoles = rolService.listar();
		listaAgencias = agenciaService.listar();

		empleadoSeleccionado = new Empleado();
		agencia = new Agencia();
		listaCheckRoles = new ArrayList<>();
		listaRolHasEmpleado = new ArrayList<>();
		idAgencia = new Long("0");
		idRol = new Long("0");

		foto = getFotoInicial();
		utils = new Utilitarios();

		this.actualizarLista();
	}

	public void actualizarLista() {
		listaEmpleados = empleadoService.listar();
	}

	public boolean verificarRequeridos() {
		if (idAgencia == 0) {
			utils.mostrarMensaje("Agencia", "Faltan Datos de agencia, por favor revisar", "W");
			return false;
		} else
			return true;
	}

	public void obtenerAgencia() {
		agencia = agenciaService.buscarPorId(idAgencia);
	}

	public void guardar() {

		if (verificarRequeridos()) {
			Agencia agencia = agenciaService.buscarPorId(idAgencia);
			empleadoSeleccionado.setAgenciaIdAgencia(agencia);

			if (empleadoSeleccionado.getIdEmpleado() == null) {
				if (file2 == null) {
					utils.mostrarMensaje("Logo", "Falta Logo, por favor revisar", "W");
				} else {
					empleadoSeleccionado.setFotoEmpleado(this.saveFile());
					empleadoSeleccionado.setCreaEmpleado(new Date());
					Empleado empInserted = empleadoService.insertar(empleadoSeleccionado);
					utils.mostrarMensaje("Empleado", "Guardado Exitosamente", "I");

					if (idRol != 0 && (empInserted != null)) {
						Rol rol = rolService.buscarPorId(idRol);
						RolHasEmpleadoPK pk = new RolHasEmpleadoPK();
						pk.setEmpleadoIdEmpleado(empInserted.getIdEmpleado());
						pk.setRolIdRol(idRol);

						RolHasEmpleado re = new RolHasEmpleado();
						re.setRolHasEmpleadoPK(pk);
						re.setActivo(true);
						re.setEmpleado(empInserted);
						re.setRol(rol);

						ehrService.insertar(re);

						utils.mostrarMensaje("Empleado - Rol",
								"Se ha asigando el ROL: " + rol.getNombreRol() + " al Empleado", "w");
					}
				}
			} else {

				if (idRol != 0) {

					Rol rol = rolService.buscarPorId(idRol);
					RolHasEmpleadoPK pk = new RolHasEmpleadoPK();
					pk.setEmpleadoIdEmpleado(empleadoSeleccionado.getIdEmpleado());
					pk.setRolIdRol(idRol);

					RolHasEmpleado re = new RolHasEmpleado();
					re.setRolHasEmpleadoPK(pk);
					re.setActivo(true);
					re.setEmpleado(empleadoSeleccionado);
					re.setRol(rol);

					ehrService.insertar(re);

					utils.mostrarMensaje("Empleado - Rol",
							"Se ha asigando el ROL: " + rol.getNombreRol() + " al Empleado", "w");
				}

				if (file2 != null) {
					empleadoSeleccionado.setFotoEmpleado(this.saveFile());
				}
				empleadoService.actualizar(empleadoSeleccionado.getIdEmpleado(), empleadoSeleccionado);
				utils.mostrarMensaje("Empleado", "Actualizado Exitosamente", "I");
			}
		}

		this.clear();

	}

	public void sideActualiza() {
		try {

			boolean match = false;

			// esta en base pero no en check, quiere decir que le puso false
			match = false;
			for (int y = 0; y < listaRolHasEmpleado.size(); y++) {
				match = false;
				RolHasEmpleado obj = listaRolHasEmpleado.get(y);
				for (int x = 0; x < listaCheckRoles.size(); x++) {
					String id = listaCheckRoles.get(x).toString();
					if (obj.getRolHasEmpleadoPK().getRolIdRol() == Long.parseLong(id)) {
						match = true;

						obj.setActivo(true);

						ehrService.insertar(obj);

						break;
					}
				}
				if (!match) {
					obj.setActivo(false);
					ehrService.insertar(obj);
				}
			}

			// esta en check pero no en base, quiere decir que agrega un nuevo registro
			for (String idStr : listaCheckRoles) {
				match = false;
				for (int x = 0; x < listaRolHasEmpleado.size(); x++) {
					Long id = listaRolHasEmpleado.get(x).getRolHasEmpleadoPK().getRolIdRol();
					RolHasEmpleado obj = new RolHasEmpleado();
					obj = listaRolHasEmpleado.get(x);
					if (Long.parseLong(idStr) == id) {
						match = true;
						break;
					}
				}
				if (!match) {
					Rol rol = rolService.buscarPorId(Long.parseLong(idStr));
					RolHasEmpleadoPK pk = new RolHasEmpleadoPK();
					pk.setEmpleadoIdEmpleado(empleadoSeleccionado.getIdEmpleado());
					pk.setRolIdRol(rol.getIdRol());

					RolHasEmpleado re = new RolHasEmpleado();
					re.setRolHasEmpleadoPK(pk);
					re.setActivo(true);
					re.setEmpleado(empleadoSeleccionado);
					re.setRol(rol);

					ehrService.insertar(re);
				}
			}

			if (idAgencia != empleadoSeleccionado.getAgenciaIdAgencia().getIdAgencia())
				empleadoSeleccionado.setAgenciaIdAgencia(agenciaService.buscarPorId(idAgencia));

			if (file2 != null) {
				empleadoSeleccionado.setFotoEmpleado(this.saveFile());
			}
			// empleadoSeleccionado.setRolHasEmpleadoList(rz);
			empleadoService.actualizar(empleadoSeleccionado.getIdEmpleado(), empleadoSeleccionado);
			actualizarLista();

			empleadoSeleccionado = empleadoService.buscarPorId(empleadoSeleccionado.getIdEmpleado());

			foto = obtenerFoto(empleadoSeleccionado.getFotoEmpleado());

			pasarDatoseditar(empleadoSeleccionado);

			utils.mostrarMensaje("Empleado", "Actualizado Exitosamente", "I");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pasarDatoseditar(Empleado entidad) {
		empleadoSeleccionado = entidad;
		idAgencia = entidad.getAgenciaIdAgencia().getIdAgencia();
		listaRolHasEmpleado = ehrService.findRolHasEmpleadoByEmpleado(entidad);

		listaCheckRoles = new ArrayList<>();

		if (!listaRolHasEmpleado.isEmpty()) {
			idRol = listaRolHasEmpleado.get(0).getRolHasEmpleadoPK().getRolIdRol();
			for (int x = 0; x < listaRolHasEmpleado.size(); x++) {
				if (listaRolHasEmpleado.get(x).getActivo()) {
					listaCheckRoles.add(Long.toString(listaRolHasEmpleado.get(x).getRolHasEmpleadoPK().getRolIdRol()));
				}
			}
		}
		foto = obtenerFoto(entidad.getFotoEmpleado());
		obtenerAgencia();
	}

	public void switchActiva(Empleado entidad) {

		empleadoService.actualizar(entidad.getIdEmpleado(), entidad);
		if (entidad.getActivoEmpleado())
			utils.mostrarMensaje("Empleado" + entidad.getNombreEmpleado(), "Activado Exitosamente", "I");
		else
			utils.mostrarMensaje("Empleado " + entidad.getNombreEmpleado(), "Desactivado Exitosamente", "w");

		actualizarLista();
	}

	public void eliminar() {
		try {
			empleadoService.eliminar(empleadoSeleccionado.getIdEmpleado());
			empleadoSeleccionado = new Empleado();
			this.actualizarLista();
			utils.mostrarMensaje("Empleado", "Eliminado Exitosamente !", "I");

		} catch (Exception e) {
			utils.mostrarMensaje("Eliminación", "Imposible Eliminar, Empleado en USO", "w");
		}
	}

	public List<String> cargarPerfilesUsuario(Empleado entidad) {
		try {
			List<RolHasEmpleado> list = ehrService.listar();
			List<String> listP = new ArrayList<>();
			if (!list.isEmpty()) {
				for (int x = 0; x < list.size(); x++) {
					if (entidad.getIdEmpleado() == list.get(x).getRolHasEmpleadoPK().getEmpleadoIdEmpleado()
							&& list.get(x).getActivo()) {
						Rol rol = rolService.buscarPorId(list.get(x).getRolHasEmpleadoPK().getRolIdRol());
						listP.add(rol.getNombreRol());
					}
				}
			}
			return listP;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String saveFile() {

		String path = "";
		if (isWindows())
			path = pathWindows;
		else if (isUnix())
			path = pathLinux;
		else
			path = pathMac;

		path += "/" + empleadoSeleccionado.getNombreEmpleado() + "/logo" + file2.getFileName();
		File targetFile = new File(path);

		try {
			FileUtils.copyInputStreamToFile(file2.getInputStream(), targetFile);
			return targetFile.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public void upload(FileUploadEvent event1) {
		try {
			file2 = event1.getFile();
			foto = new DefaultStreamedContent(event1.getFile().getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public StreamedContent getFotoInicial() {
		try {

			DefaultStreamedContent image = null;
			
			String path = "";
			if (isWindows())
				path = pathimages;
			else if (isUnix())
				path = pathLinux;
			else
				path = pathMac;

			
			
			File file = new File(path + "your-logo.png");
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream ous = null;
			InputStream ios = null;

			byte[] buffer = new byte[4096];
			ous = new ByteArrayOutputStream();
			ios = new FileInputStream(file);
			int read = 0;
			while ((read = ios.read(buffer)) != -1) {
				ous.write(buffer, 0, read);
			}

			image = new DefaultStreamedContent(new ByteArrayInputStream(ous.toByteArray()), "image/png");
			return image;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public StreamedContent obtenerFoto(String path) {
		try {

			DefaultStreamedContent image = null;
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream ous = null;
			InputStream ios = null;

			byte[] buffer = new byte[4096];
			ous = new ByteArrayOutputStream();
			ios = new FileInputStream(file);
			int read = 0;
			while ((read = ios.read(buffer)) != -1) {
				ous.write(buffer, 0, read);
			}

			image = new DefaultStreamedContent(new ByteArrayInputStream(ous.toByteArray()), "image/png");
			return image;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public StreamedContent getImage() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
				return new DefaultStreamedContent();
			} else {
				Long idEmpleado = Long
						.parseLong(context.getExternalContext().getRequestParameterMap().get("empleadoId"));
				Empleado obj = empleadoService.buscarPorId(idEmpleado);
				DefaultStreamedContent image = null;
				File file = new File(obj.getFotoEmpleado());
				FileInputStream fis = new FileInputStream(file);
				ByteArrayOutputStream ous = null;
				InputStream ios = null;

				byte[] buffer = new byte[4096];
				ous = new ByteArrayOutputStream();
				ios = new FileInputStream(file);
				int read = 0;
				while ((read = ios.read(buffer)) != -1) {
					ous.write(buffer, 0, read);
				}

				image = new DefaultStreamedContent(new ByteArrayInputStream(ous.toByteArray()), "image/png");
				return image;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public StreamedContent getStream() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the HTML. Return a stub StreamedContent so that it will
			// generate right URL.
			return new DefaultStreamedContent();
		} else {
			// So, browser is requesting the media. Return a real StreamedContent with the
			// media bytes.
			String idVideo = (context.getExternalContext().getRequestParameterMap().get("idEmpresa")).toString();
			System.out.println("FILE PARA VIDEO: " + idVideo);
			File file = new File("C:\\Users\\ADM-DGIP\\Videos\\Captures\\video.mp4");
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream ous = null;
			InputStream ios = null;

			byte[] buffer = new byte[4096];
			ous = new ByteArrayOutputStream();
			ios = new FileInputStream(file);

			return new DefaultStreamedContent(ios, "video/mp4");
		}
	}

	private static String OS = System.getProperty("os.name").toLowerCase();
	private static String OSArch = System.getProperty("os.arch").toLowerCase();
	private static String OSVersion = System.getProperty("os.version").toLowerCase();

	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
	}

	/** SETTRES Y GETTERS **/

	public List<String> getListaCheckRoles() {
		return listaCheckRoles;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public void setListaCheckRoles(List<String> listaCheckRoles) {
		this.listaCheckRoles = listaCheckRoles;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public List<Rol> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<Rol> listaRoles) {
		this.listaRoles = listaRoles;
	}

	public List<Agencia> getListaAgencias() {
		return listaAgencias;
	}

	public void setListaAgencias(List<Agencia> listaAgencias) {
		this.listaAgencias = listaAgencias;
	}

	public Long getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public UploadedFile getFile2() {
		return file2;
	}

	public void setFile2(UploadedFile file2) {
		this.file2 = file2;
	}

	public StreamedContent getFoto() {
		return foto;
	}

	public void setFoto(StreamedContent foto) {
		this.foto = foto;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public Empleado getEmpleadoSeleccionado() {
		return empleadoSeleccionado;
	}

	public void setEmpleadoSeleccionado(Empleado empleadoSeleccionado) {
		this.empleadoSeleccionado = empleadoSeleccionado;
	}

}
