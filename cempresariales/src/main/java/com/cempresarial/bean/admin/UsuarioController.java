package com.cempresarial.bean.admin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

import com.cempresarial.entities.Empleado;
import com.cempresarial.entities.Empresa;
import com.cempresarial.entities.DTO.PerfilDTO;
import com.cempresarial.entities.admin.Autorizacion;
import com.cempresarial.entities.admin.Perfil;
import com.cempresarial.entities.admin.PerfilHasUsuario;
import com.cempresarial.entities.admin.PerfilHasUsuarioPK;
import com.cempresarial.entities.admin.Usuario;
import com.cempresarial.recursos.Password;
import com.cempresarial.recursos.SesionController;
import com.cempresarial.recursos.Utilitarios;
import com.cempresarial.rest.client.service.AutorizacionService;
import com.cempresarial.rest.client.service.EmpleadoService;
import com.cempresarial.rest.client.service.EmpresaService;
import com.cempresarial.rest.client.service.PerfilHasUsuarioService;
import com.cempresarial.rest.client.service.PerfilService;
import com.cempresarial.rest.client.service.UsuarioService;

@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController extends SesionController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();
	}

	@Inject
	private UsuarioService usuarioDAO;
	@Inject
	private PerfilService perfilDAO;
	@Inject
	private PerfilHasUsuarioService perfilUsuarioDAO;
	@Inject
	private EmpresaService empresaDAO;
	@Inject
	private EmpleadoService empleadoDAO;
	@Inject
	private AutorizacionService autorizacionDAO;

	// VARIABLES
	private Utilitarios util;
	private Usuario usuario;
	private Autorizacion autoriacion;
	private List<Usuario> listUsuarios;
	private List<Usuario> listUsuarioSelect;
	private Perfil perfil;
	private List<Perfil> listPerfil;
	private List<Empresa> listEmpresa;
	private List<Empleado> listEmpleado;
	private List<PerfilDTO> listPerfilDTO;

	private Long idEmpresa;
	private Long idEmpleado;

	private boolean guardarRender;

	private UploadedFile file;
	private StreamedContent fotoUsuario;

	public String mensajePerfiles = "";
	public String clave;

	private String pathimages = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
	private String pathWindows = "C:\\Users\\Wilson\\Pictures\\Saved Pictures\\";
	private String pathLinux = "usr/cempresarial/";
	private String pathMac = "usr/cempresarial/";

	private static String OS = System.getProperty("os.name").toLowerCase();
	private static String OSArch = System.getProperty("os.arch").toLowerCase();
	private static String OSVersion = System.getProperty("os.version").toLowerCase();

	private String menuId;

	// METODOS
	@PostConstruct
	private void init() {
		clear();
	}

	public void clear() {
		try {
			util = new Utilitarios();
			usuario = new Usuario();
			autoriacion = new Autorizacion();
			clave = "";
			listUsuarios = usuarioDAO.listar();

			fotoUsuario = getFotoInicial();

			listEmpresa = empresaDAO.listar();
			listEmpleado = empleadoDAO.listar();

			idEmpleado = new Long(0);
			idEmpresa = new Long(0);

			construirSeleccionPerfil();
			
			consultarPermisosBotones();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void consultarPermisosBotones() {
		try {
			autoriacion = autorizacionDAO.findByUrlMenu("/pages/admin/adminUsuarios.jsf");

			System.out.println("MENU USUARIO CONTROLLER: " + autoriacion.getPermisos());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void construirSeleccionPerfil() {
		try {
			listPerfil = perfilDAO.listar();
			listPerfilDTO = new ArrayList<>();
			for (Perfil p : listPerfil) {
				PerfilDTO pdto = new PerfilDTO();
				pdto.setPerfil(p);
				pdto.setCheck(false);
				listPerfilDTO.add(pdto);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void actualizarListPerfiles() {
		try {
			listPerfil = perfilDAO.listar();
			util.mostrarMensaje("PERFILES", "Se ha actualziado el LISTADO DE PERFILES", "f");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actualizarLista() {
		try {
			listUsuarios = usuarioDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public StreamedContent getFotoInicial() {
		try {

			DefaultStreamedContent image = null;
			String pathimages = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/");
			pathimages.concat("\\resources\\images\\");
			File file = new File(pathimages + "\\images\\user.jpg");
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

	public StreamedContent obtenerPlano(String path) {

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

	public void handleFileUpload(FileUploadEvent event) {
		try {
			file = event.getFile();
			fotoUsuario = new DefaultStreamedContent(file.getInputStream());
			util.mostrarMensaje("Foto", file.getFileName() + " subida exitosamente.", "I");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String saveFile(Usuario usuario) {

		String path = pathimages;

		/*
		 * if (isWindows()) path = pathWindows; else if (isUnix()) path = pathLinux;
		 * else path = pathMac;
		 */

		path += "/resources/usuarios/" + usuario.getIdUsuario() + "/avatar-" + usuario.getIdUsuario() + ".jpg";
		File targetFile = new File(path);

		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);
			return targetFile.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
	}

	public void eliminarUsuario(Usuario user) {
		try {
			List<Perfil> list = perfilDAO.obtenerPerfilesUsuario(user.getNombreUsuario());
			if (list.isEmpty()) {
				usuarioDAO.eliminar(user.getIdUsuario());
				listUsuarios = usuarioDAO.listar();
				util.mostrarMensaje("USUARIO", "El usuario ha sido eliminado correctamente.!", "i");
			} else {
				util.mostrarMensaje("USUARIO", "Usuario en USO. No se puede eliminar!", "W");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pasarPerfilUsuario(Usuario user) {
		try {

			System.out.println("GO PROBAR ANTES E GUARDAR FPTOS");

			usuario = user;
			List<Perfil> list = perfilDAO.obtenerPerfilesUsuario(user.getNombreUsuario());
			if (!list.isEmpty()) {
				for (int y = 0; y < listPerfilDTO.size(); y++) {
					for (int x = 0; x < list.size(); x++) {
						PerfilDTO p = new PerfilDTO();
						p.setPerfil(list.get(x));
						p.setCheck(false);
						if (listPerfilDTO.get(y).getPerfil().getIdPerfil() == list.get(x).getIdPerfil()) {
							p.setCheck(true);
							listPerfilDTO.set(y, p);
							break;
						}
					}

				}
			}

			System.out.println("GO PROBAR ANTES E GUARDAR FPTOS");

			util.mostrarMensaje("USUARIO", "El usuario ha sido cargado correctamente.!", "i");
			idEmpleado = user.getIdEmpleado();
			idEmpresa = user.getIdEmpresa();
			if (user.getFoto() != null) {
				fotoUsuario = obtenerPlano(user.getFoto());
			} else {
				fotoUsuario = getFotoInicial();
			}
			clave = user.getClave();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> cargarPerfilesUsuario(Usuario user) {
		try {
			List<Perfil> list = perfilDAO.obtenerPerfilesUsuario(user.getNombreUsuario());
			List<String> listP = new ArrayList<>();
			if (!list.isEmpty()) {
				for (int x = 0; x < list.size(); x++) {
					Perfil p = new Perfil();
					p = list.get(x);
					// p.setSeleccionado("SI");

					listP.add(p.getNombre());
				}
			}
			return listP;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void actualizarUsuario() {
		try {
			if (usuario.getIdUsuario() != 0) {
				if (verificarDatosVacios()) {
					
					if (file != null)
						usuario.setFoto(saveFile(usuario));
					usuario.setIdEmpleado(idEmpleado);
					usuario.setIdEmpresa(idEmpresa);
					usuarioDAO.actualizar(usuario.getIdUsuario(), usuario);
					util.mostrarMensaje("USUARIO", "El usuario ha sido actualizado correctamente.!", "i");
				}
				listUsuarios = usuarioDAO.listar();

			} else {
				util.mostrarMensaje("USUARIO", "No se puede actualizar usuario. Id no identificado o no existe!", "f");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void activaDesactivaUsuario(Usuario user) {
		try {

			if (user.getActivo()) {
				user.setActivo(false);
				util.mostrarMensaje("USUARIO", "Usuario DESACTIVADO correctamente.!", "i");
			} else {
				user.setActivo(true);
				util.mostrarMensaje("USUARIO", "Usuario ACTIVADO correctamente.!", "i");
			}
			usuarioDAO.actualizar(user.getIdUsuario(), user);
			listUsuarios = usuarioDAO.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void crearUsuario() {
		try {

			//int valorItem = usuarioDAO.listar().size();

			// if (verificarPaquete(1, valorItem)) {
			
			usuario.setIdEmpleado(idEmpleado);
			usuario.setIdEmpresa(idEmpresa);

			usuario.setCuenta(getCurrentUser().getCuenta());
			Usuario user = usuarioDAO.findByNombreUsuario(usuario);
			if (user == null) {
				util.mostrarMensaje("USUARIO", "Se ha creado el usuario exitosamente", "i");
				usuario = usuarioDAO.insertar(usuario);
				if (file != null) {
					usuario.setFoto(saveFile(usuario));
					usuarioDAO.actualizar(usuario.getIdUsuario(), usuario);
				}
			} else {
				util.mostrarMensaje("USUARIO", "Nombre de Usario en USO, intente otro", "W");
			}

			if (guardarRender) {
				guardarUsuarioPerfil();
				List<Perfil> list = perfilDAO.obtenerPerfilesUsuario(usuario.getNombreUsuario());
				if (!list.isEmpty()) {
					util.mostrarMensaje("PERFIL-USUARIO", "Se ha asigando un perfil al Usuario", "i");
				}
			}

			clear();
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void guardarUsuarioPerfil() {
		try {

			for (PerfilDTO p : listPerfilDTO) {
				if (p.isCheck()) {
					PerfilHasUsuario pu = new PerfilHasUsuario();
					PerfilHasUsuarioPK pupk = new PerfilHasUsuarioPK();
					pupk.setUsuarioIdUsuario(usuario.getIdUsuario());
					pupk.setPerfilIdPerfil(p.getPerfil().getIdPerfil());
					pu.setPerfil(p.getPerfil());
					pu.setUsuario(usuario);
					pu.setActivoPerfilHasUsuario(true);
					pu.setPerfilHasUsuarioPK(pupk);
					perfilUsuarioDAO.insertar(pu);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verificacionesAntesGuardar() {
		try {

			if (verificarPerfilesSeleccionados()) {
				mensajePerfiles = "Está seguro de Guardar?";
				guardarRender = true;
				util.mostrarMensaje("USUARIO", mensajePerfiles, "W");
			} else {
				mensajePerfiles = "Perfil no seleccionado. ¿Esta seguro de GUARDAR?";
				guardarRender = true;
				util.mostrarMensaje("USUARIO", mensajePerfiles, "W");
			}
			if (verificarDatosVacios()) {
				Usuario user = usuarioDAO.findByNombreUsuario(usuario);
				if (verificarDatosUsuario(user)) {

					util.ejecutarPaneles("pnldGuardar", "S");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verificarDatosUsuario(Usuario user) {
		try {
			if (user != null) {
				if (user.getCedula().trim().equals(usuario.getCedula().trim())
						|| user.getNombreUsuario().trim().toUpperCase()
								.equals(usuario.getNombreUsuario().trim().toUpperCase())
						|| user.getNombres().trim().toUpperCase().equals(usuario.getNombres().trim().toUpperCase())) {
					util.mostrarMensaje("USUARIO",
							"Se ha encontrado un usuario con credenciales similares, por favor, verifiquelas para continuar",
							"w");
					guardarRender = false;
					return false;
				} else {
					guardarRender = true;
					return true;
				}
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean verificarDatosVacios() {
		try {
			if (usuario.getCedula().trim().equals("") || usuario.getNombreUsuario().trim().toUpperCase().equals("")
					|| usuario.getNombres().trim().toUpperCase().equals("")
					|| usuario.getEmail().trim().toUpperCase().equals("") || usuario.getActivo() == null
					|| usuario.getFechaCreacion() == null) {
				util.mostrarMensaje("USUARIO", "Existen datos vacios, por favor, verificar antes de guardar", "w");
				guardarRender = false;
				return false;
			} else {
				guardarRender = true;
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean verificarPerfilesSeleccionados() {
		try {
			boolean valor = false;
			for (Perfil p : listPerfil) {
				// if (p.getSeleccionado() != null) {
				// !p.getSeleccionado().equals("") ||
				valor = true;
				break;
				// }
			}
			return valor;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Setters y Getters
	public StreamedContent getFotoUsuario() {
		return fotoUsuario;
	}

	public void setFotoUsuario(StreamedContent fotoUsuario) {
		this.fotoUsuario = fotoUsuario;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public boolean isGuardarRender() {
		return guardarRender;
	}

	public void setGuardarRender(boolean guardarRender) {
		this.guardarRender = guardarRender;
	}

	public String getMensajePerfiles() {
		return mensajePerfiles;
	}

	public void setMensajePerfiles(String mensajePerfiles) {
		this.mensajePerfiles = mensajePerfiles;
	}

	public Utilitarios getUtil() {
		return util;
	}

	public void setUtil(Utilitarios util) {
		this.util = util;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListUsuarios() {
		return listUsuarios;
	}

	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Perfil> getListPerfil() {
		return listPerfil;
	}

	public void setListPerfil(List<Perfil> listPerfil) {
		this.listPerfil = listPerfil;
	}

	public List<Usuario> getListUsuarioSelect() {
		return listUsuarioSelect;
	}

	public void setListUsuarioSelect(List<Usuario> listUsuarioSelect) {
		this.listUsuarioSelect = listUsuarioSelect;
	}

	public List<Empresa> getListEmpresa() {
		return listEmpresa;
	}

	public void setListEmpresa(List<Empresa> listEmpresa) {
		this.listEmpresa = listEmpresa;
	}

	public List<Empleado> getListEmpleado() {
		return listEmpleado;
	}

	public void setListEmpleado(List<Empleado> listEmpleado) {
		this.listEmpleado = listEmpleado;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public List<PerfilDTO> getListPerfilDTO() {
		return listPerfilDTO;
	}

	public void setListPerfilDTO(List<PerfilDTO> listPerfilDTO) {
		this.listPerfilDTO = listPerfilDTO;
	}

	public Autorizacion getAutoriacion() {
		return autoriacion;
	}

	public void setAutoriacion(Autorizacion autoriacion) {
		this.autoriacion = autoriacion;
	}
	
	

}
