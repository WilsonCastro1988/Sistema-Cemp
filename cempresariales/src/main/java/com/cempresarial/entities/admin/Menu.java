/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.entities.admin;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author ADM-DGIP
 */
@Entity
@Table(name = "menu", catalog = "cempresariales_admin", schema = "")
@XmlRootElement
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_menu", nullable = false)
	private Long idMenu;
	private Boolean activo;
	@Column(length = 255)
	private String descripcion;
	@Column(name = "icon_position", length = 255)
	private String iconPosition;
	@Column(length = 255)
	private String icon;
	@Column(length = 255)
	private String nombre;
	@Basic(optional = false)
	@Column(nullable = false)
	private int orden;
	@Column(length = 255)
	private String tipo;
	@Column(length = 255)
	private String url;
	
	@OneToMany(mappedBy = "menu")
	@JsonBackReference(value = "autorizacion")
	private List<Autorizacion> autorizacionList;
	@OneToMany(mappedBy = "menuPadre")
	@JsonBackReference(value = "menu")
	private List<Menu> menuList;
	@JoinColumn(name = "id_menu_padre", referencedColumnName = "id_menu")
	@ManyToOne
	private Menu menuPadre;
	@JoinColumn(name = "id_aplicacion", referencedColumnName = "id_aplicacion")
	@ManyToOne
	@JsonBackReference(value = "aplicacion")
	private Aplicacion aplicacion;

	public Menu() {
	}

	public Menu(Long idMenu) {
		this.idMenu = idMenu;
	}

	public Menu(Long idMenu, int orden) {
		this.idMenu = idMenu;
		this.orden = orden;
	}

	public Long getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIconPosition() {
		return iconPosition;
	}

	public void setIconPosition(String iconPosition) {
		this.iconPosition = iconPosition;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@XmlTransient
	public List<Autorizacion> getAutorizacionList() {
		return autorizacionList;
	}

	public void setAutorizacionList(List<Autorizacion> autorizacionList) {
		this.autorizacionList = autorizacionList;
	}

	@XmlTransient
	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public Menu getMenuPadre() {
		return menuPadre;
	}

	public void setMenuPadre(Menu menuPadre) {
		this.menuPadre = menuPadre;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idMenu != null ? idMenu.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Menu)) {
			return false;
		}
		Menu other = (Menu) object;
		if ((this.idMenu == null && other.idMenu != null)
				|| (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication2.Menu[ idMenu=" + idMenu + " ]";
	}

}
