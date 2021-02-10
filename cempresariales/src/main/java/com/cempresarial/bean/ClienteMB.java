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

import com.cempresarial.entities.Cliente;
import com.cempresarial.entities.Empresa;
import com.cempresarial.recursos.Utilitarios;
import com.cempresarial.rest.client.service.ClienteService;
import com.cempresarial.rest.client.service.EmpresaService;

/**
 *
 * @author DIGETBI 05
 */
@ManagedBean
@SessionScoped
public class ClienteMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Cliente> listaClientes;
	private List<Empresa> listaEmpresa;

	private Cliente clienteSeleccionado;

	private UploadedFile file2;
	private StreamedContent foto;
	// cambiar entre linux o mac o windows
	private String pathimages = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")+ "\\";
	private String pathWindows = "C:\\Users\\Wilson\\Pictures\\Saved Pictures\\";
	private String pathLinux = "usr/cempresarial/";
	private String pathMac = "usr/cempresarial/";

	private Utilitarios utils;

	@Inject
	private ClienteService clienteService;
	@Inject
	private EmpresaService empresaService;

	@PostConstruct
	public void init() {
			 
		this.clear();
	}

	public void clear() {
		clienteSeleccionado = new Cliente();
		listaEmpresa = new ArrayList<>();
		foto = getFotoInicial();
		utils = new Utilitarios();

		this.actualizarLista();
	}

	public void actualizarLista() {
		listaClientes = clienteService.listar();
	}

	public boolean verificarRequeridos() {
		if (file2 == null) {
			utils.mostrarMensaje("Foto Logo", "Faltan Logo, por favor revisar", "W");
			return false;
		} else if(clienteSeleccionado.getNombreCliente() == null){
			utils.mostrarMensaje("Cliente", "Faltan llenar campos", "W");
			return false;
		}
		else {
			return true;
		}
			
			
	}

	public void guardar() {

		if (clienteSeleccionado.getIdCliente() == null) {
			if (verificarRequeridos()) {
				clienteSeleccionado.setFotoCliente(this.saveFile());
				clienteSeleccionado.setCreaCliente(new Date());
				clienteService.insertar(clienteSeleccionado);
				utils.mostrarMensaje("Cliente", "Guardado Exitosamente", "I");
			}
		} else {
			if (file2 != null) {
				clienteSeleccionado.setFotoCliente(this.saveFile());
			}
			clienteSeleccionado.setActualizaCliente(new Date());
			clienteService.actualizar(clienteSeleccionado.getIdCliente(), clienteSeleccionado);
			utils.mostrarMensaje("Cliente", "Actualizado Exitosamente", "I");
		}

		this.clear();

	}

	public void pasarDatoseditar(Cliente cliente) {
		clienteSeleccionado = cliente;
		foto = obtenerFoto(cliente.getFotoCliente());

		listaEmpresa = empresaService.findByClienteIdCliente(cliente);

	}

	public String verEmpresas() {
		List<String> lista = new ArrayList<>();
		listaEmpresa.stream()
				.forEach(e -> lista.add(e.getNombreEmpresa() + " - " + e.getSectorIdSector().getNombreSector()));

		return lista.toString();
	}

	public void switchActiva(Cliente cliente) {

		clienteService.actualizar(cliente.getIdCliente(), cliente);
		if (cliente.getActivoCliente())
			utils.mostrarMensaje("Cliente" + cliente.getNombreCliente(), "Activado Exitosamente", "I");
		else
			utils.mostrarMensaje("Cliente " + cliente.getNombreCliente(), "Desactivado Exitosamente", "w");

		actualizarLista();
	}

	public void eliminar() {
		try {
			if (clienteService.eliminar(clienteSeleccionado.getIdCliente())) {
				clienteSeleccionado = new Cliente();
				this.actualizarLista();
				utils.mostrarMensaje("Cliente", "Eliminado Exitosamente !", "I");
			} else {
				utils.mostrarMensaje("Eliminación", "Imposible Eliminar, Cliente en USO", "w");
			}

		} catch (Exception e) {
			utils.mostrarMensaje("Eliminación", "Imposible Eliminar, Cliente en USO", "w");
		}
	}

	public String saveFile() {

		String path = "";
		if (isWindows())
			path = pathimages;
		else if (isUnix())
			path = pathLinux;
		else
			path = pathMac;

		path += "/" + clienteSeleccionado.getNombreCliente() + "/logo" + file2.getFileName();
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
				Long idCliente = Long.parseLong(context.getExternalContext().getRequestParameterMap().get("clienteId"));
				Cliente obj = clienteService.buscarPorId(idCliente);
				DefaultStreamedContent image = null;
				File file = new File(obj.getFotoCliente());
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
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public List<Empresa> getListaEmpresa() {
		return listaEmpresa;
	}

	public void setListaEmpresa(List<Empresa> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
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

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Cliente getClienteSeleccionado() {
		return clienteSeleccionado;
	}

	public void setClienteSeleccionado(Cliente clienteSeleccionado) {
		this.clienteSeleccionado = clienteSeleccionado;
	}

}
