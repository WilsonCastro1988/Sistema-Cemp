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
import com.cempresarial.entities.Sector;
import com.cempresarial.recursos.Utilitarios;
import com.cempresarial.rest.client.service.ClienteService;
import com.cempresarial.rest.client.service.EmpresaService;
import com.cempresarial.rest.client.service.SectorService;

/**
 *
 * @author DIGETBI 05
 */
@ManagedBean
@SessionScoped
public class EmpresaMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Empresa> listaEmpresas;
	private List<Cliente> listaClientes;
	private List<Sector> listaSector;

	private Empresa empresaSel;
	private Cliente clienteSel;
	private Long idCliente;
	private Long idSector;

	private UploadedFile file2;
	private StreamedContent foto;
	// cambiar entre linux o mac o windows
	private String pathimages = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
	private String pathLinux = "usr/cempresarial/";
	private String pathMac = "usr/cempresarial/";

	private Utilitarios utils;

	@Inject
	private EmpresaService empresaService;
	@Inject
	private ClienteService clienteService;
	@Inject
	private SectorService sectorService;

	@PostConstruct
	public void init() {
		this.clear();
	}

	public void clear() {
		empresaSel = new Empresa();
		idCliente = new Long("0");
		idSector = new Long("0");
		listaEmpresas = empresaService.listar();
		listaClientes = clienteService.listar();
		listaSector = sectorService.listar();

		foto = getFotoInicial();

		utils = new Utilitarios();

	}

	public void listarEmpresas() {
		listaEmpresas = empresaService.listar();
	}

	public boolean verificarRequeridos() {
		if (file2 == null || idCliente == 0 || idSector == 0) {
			utils.mostrarMensaje("Empresa", "Faltan Datos, por favor revisar", "W");
			return false;
		} else
			return true;
	}

	public void guardar() {

		if (verificarRequeridos()) {
			clienteSel = clienteService.buscarPorId(idCliente);
			Sector sector = sectorService.buscarPorId(idSector);
			empresaSel.setClienteIdCliente(clienteSel);
			empresaSel.setSectorIdSector(sector);
			empresaSel.setImagenEmpresa(this.saveFile());

			if (empresaSel.getIdEmpresa() == null) {
				empresaSel.setCreaEmpresa(new Date());
				empresaService.insertar(empresaSel);

				utils.mostrarMensaje("Empresa", "Guardada Exitosamente", "I");

			} else {
				empresaService.actualizar(empresaSel.getIdEmpresa(), empresaSel);
			}
		}

		this.clear();

	}

	public void pasarDatoseditar(Empresa empresa) {
		empresaSel = empresa;
		idCliente = empresa.getClienteIdCliente().getIdCliente();
		idSector = empresa.getSectorIdSector().getIdSector();
		foto = obtenerFoto(empresa.getImagenEmpresa());
	}

	public void switchActiva(Empresa empresa) {

		empresaService.actualizar(empresa.getIdEmpresa(), empresa);
		if (empresa.getActivoEmpresa())
			utils.mostrarMensaje("Empresa " + empresa.getNombreEmpresa(), "Activada Exitosamente", "I");
		else
			utils.mostrarMensaje("Empresa " + empresa.getNombreEmpresa(), "Desactivada Exitosamente", "w");

		listarEmpresas();
	}

	public void eliminar() {

		Long id = empresaSel.getIdEmpresa();
		empresaService.eliminar(empresaSel.getIdEmpresa());
		empresaSel = new Empresa();
		listarEmpresas();
	}

	public String saveFile() {

		String path = "";
		if (isWindows())
			path = pathimages;
		else if (isUnix())
			path = pathLinux;
		else
			path = pathMac;

		path += "/" + empresaSel.getNombreEmpresa() + "/logo" + file2.getFileName();
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

			
			
			File file = new File(path + "//your-logo.png");
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
				Long empresa = Long.parseLong(context.getExternalContext().getRequestParameterMap().get("empresaId"));
				Empresa emp = empresaService.buscarPorId(empresa);
				DefaultStreamedContent image = null;
				File file = new File(emp.getImagenEmpresa());
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

	/**
	 * SETTERS Y GETTERS
	 ***/

	public StreamedContent getFoto() {
		return foto;
	}

	public void setFoto(StreamedContent foto) {
		this.foto = foto;
	}

	public UploadedFile getFile2() {
		return file2;
	}

	public void setFile2(UploadedFile file) {
		this.file2 = file;
	}

	public List<Sector> getListaSector() {
		return listaSector;
	}

	public void setListaSector(List<Sector> listaSector) {
		this.listaSector = listaSector;
	}

	public Long getIdSector() {
		return idSector;
	}

	public void setIdSector(Long idSector) {
		this.idSector = idSector;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void setListaEmpresas(List<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}

	public Empresa getEmpresaSel() {
		return empresaSel;
	}

	public void setEmpresaSel(Empresa empresaSel) {
		this.empresaSel = empresaSel;
	}

	public Cliente getClienteSel() {
		return clienteSel;
	}

	public void setClienteSel(Cliente clienteSel) {
		this.clienteSel = clienteSel;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

}
