/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.rest.client.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.cempresarial.entities.admin.PermisoAgencia;
import com.cempresarial.rest.client.endpoint.PermisoAgenciaClient;
import com.cempresarial.rest.generic.ServiceException;

/**
 *
 * @author DIGETBI 05
 */
@Stateless
public class PermisoAgenciaService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String URL = "http://localhost:8001";
	//final String URL = "https://servicio-cemp-admin.herokuapp.com/";
	final String PATH = "/permiso-agencia";
	private PermisoAgenciaClient client = new PermisoAgenciaClient(URL, PATH);

	public List<PermisoAgencia> listar() {
		List<PermisoAgencia> lista = new ArrayList<>();
		try {
			lista.addAll(client.listar());

		} catch (ServiceException ex) {
			ex.toString();
		}

		return lista;
	}
	
	public List<PermisoAgencia> findPermisosAgeciaByPerfil(Long id) {
		List<PermisoAgencia> lista = new ArrayList<>();
		try {
			lista.addAll(client.findPermisosAgeciaByPerfil(id));

		} catch (ServiceException ex) {
			ex.toString();
		}

		return lista;
	}
	

	public void insertar(PermisoAgencia entidad) {
		client.crear(entidad);
	}

	public void actualizar(Long id, PermisoAgencia entidad) {
		PermisoAgencia obj;
		obj = client.actualizar(id, entidad);
	}

	public PermisoAgencia buscarPorId(Long id) {
		PermisoAgencia obj;
		obj = client.buscarPorId(id);
		return obj;
	}

	public void eliminar(Long id) {
		client.eliminar(id);
	}

}
