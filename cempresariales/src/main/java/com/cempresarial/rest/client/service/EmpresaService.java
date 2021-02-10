/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.rest.client.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cempresarial.entities.Cliente;
import com.cempresarial.entities.Empresa;
import com.cempresarial.rest.client.endpoint.EmpresaClient;
import com.cempresarial.rest.generic.ServiceException;

/**
 *
 * @author DIGETBI 05
 */
public class EmpresaService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String URL = "http://localhost:8004";
	//final String URL = "https://servicioclientes.herokuapp.com/";
	final String PATH = "/empresa";

	public List<Empresa> listar() {
		List<Empresa> listaEmpresas = new ArrayList<>();
		try {
			EmpresaClient client = new EmpresaClient(URL, PATH);
			listaEmpresas.addAll(client.listar());

		} catch (ServiceException ex) {
			ex.toString();
		}

		return listaEmpresas;
	}

	public void insertar(Empresa empresa) {
		EmpresaClient client = new EmpresaClient(URL, PATH);
		client.crear(empresa);
	}

	public void actualizar(Long id, Empresa empresa) {
		Empresa obj;
		EmpresaClient client = new EmpresaClient(URL, PATH);
		obj = client.actualizar(id, empresa);
	}

	public Empresa buscarPorId(Long id) {
		Empresa obj;
		EmpresaClient client = new EmpresaClient(URL, PATH);
		obj = client.buscarPorId(id);
		return obj;
	}

	public void eliminar(Long id) {
		EmpresaClient client = new EmpresaClient(URL, PATH);
		client.eliminar(id);
	}

	public List<Empresa> findByClienteIdCliente(Cliente cliente) {
		try {
			EmpresaClient client = new EmpresaClient(URL, PATH);
			return client.findByClienteIdCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
