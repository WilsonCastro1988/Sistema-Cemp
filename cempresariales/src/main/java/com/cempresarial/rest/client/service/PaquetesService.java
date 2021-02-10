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

import com.cempresarial.entities.admin.Paquetes;
import com.cempresarial.rest.client.endpoint.PaquetesClient;
import com.cempresarial.rest.generic.ServiceException;

/**
 *
 * @author DIGETBI 05
 */
@Stateless
public class PaquetesService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String URL = "http://localhost:8001";	//final String URL = "https://servicioagencias.herokuapp.com/";
	//final String URL = "https://servicio-cemp-admin.herokuapp.com/";
	final String PATH = "/paquetes";
	private PaquetesClient client = new PaquetesClient(URL, PATH);

	public List<Paquetes> listar() {
		List<Paquetes> lista = new ArrayList<>();
		try {
			lista.addAll(client.listar());

		} catch (ServiceException ex) {
			ex.toString();
		}

		return lista;
	}

	public void insertar(Paquetes entidad) {
		client.crear(entidad);
	}

	public void actualizar(Long id, Paquetes entidad) {
		Paquetes obj;
		obj = client.actualizar(id, entidad);
	}

	public Paquetes buscarPorId(Long id) {
		Paquetes obj;
		obj = client.buscarPorId(id);
		return obj;
	}

	public void eliminar(Long id) {
		client.eliminar(id);
	}

}
