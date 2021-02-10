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

import com.cempresarial.entities.admin.Aplicacion;
import com.cempresarial.rest.client.endpoint.AplicacionClient;
import com.cempresarial.rest.generic.ServiceException;

/**
 *
 * @author DIGETBI 05
 */
@Stateless
public class AplicacionService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String URL = "http://localhost:8001";
	//final String URL = "https://servicio-cemp-admin.herokuapp.com/";
	final String PATH = "/aplicacion";
	private AplicacionClient client = new AplicacionClient(URL, PATH);

	public List<Aplicacion> listar() {
		List<Aplicacion> lista = new ArrayList<>();
		try {
			lista.addAll(client.listar());

		} catch (ServiceException ex) {
			ex.toString();
		}

		return lista;
	}

	public Aplicacion findByUrl(String url) {
		Aplicacion obj;
		obj = client.findByUrl(url);
		return obj;
	}

	public void insertar(Aplicacion entidad) {
		client.crear(entidad);
	}

	public void actualizar(Long id, Aplicacion entidad) {
		Aplicacion obj;
		obj = client.actualizar(id, entidad);
	}

	public Aplicacion buscarPorId(Long id) {
		Aplicacion obj;
		obj = client.buscarPorId(id);
		return obj;
	}

	public void eliminar(Long id) {
		client.eliminar(id);
	}

}
