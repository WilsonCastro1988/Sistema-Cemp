/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cempresarial.bean.graficos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.AxesGridLines;
import org.primefaces.model.charts.axes.AxesScale;
import org.primefaces.model.charts.axes.cartesian.CartesianAxes;
import org.primefaces.model.charts.axes.cartesian.CartesianScaleLabel;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.axes.radial.RadialScales;
import org.primefaces.model.charts.axes.radial.linear.RadialLinearAngleLines;
import org.primefaces.model.charts.axes.radial.linear.RadialLinearPointLabels;
import org.primefaces.model.charts.axes.radial.linear.RadialLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;
import org.primefaces.model.charts.hbar.HorizontalBarChartDataSet;
import org.primefaces.model.charts.hbar.HorizontalBarChartModel;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.elements.Elements;
import org.primefaces.model.charts.optionconfig.elements.ElementsLine;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.radar.RadarChartDataSet;
import org.primefaces.model.charts.radar.RadarChartModel;
import org.primefaces.model.charts.radar.RadarChartOptions;

import com.cempresarial.entities.Agencia;
import com.cempresarial.entities.Area;
import com.cempresarial.entities.CatalogoPregunta;
import com.cempresarial.entities.Categoria;
import com.cempresarial.entities.Checklist;
import com.cempresarial.entities.ChecklistHasEvaluacion;
import com.cempresarial.entities.Ciudad;
import com.cempresarial.entities.Cliente;
import com.cempresarial.entities.Empleado;
import com.cempresarial.entities.Empresa;
import com.cempresarial.entities.Evaluacion;
import com.cempresarial.entities.Pregunta;
import com.cempresarial.entities.Provincia;
import com.cempresarial.entities.RangoDesempenio;
import com.cempresarial.entities.Region;
import com.cempresarial.entities.Respuesta;
import com.cempresarial.entities.Rol;
import com.cempresarial.entities.Sector;
import com.cempresarial.entities.Zona;
import com.cempresarial.entities.ZonaEstructural;
import com.cempresarial.entities.DTO.AgenciaPorEvaluacionDTO;
import com.cempresarial.entities.DTO.ContenidoRespuestaDTO;
import com.cempresarial.entities.DTO.RespuestaDTO;
import com.cempresarial.entities.DTO.RespuestaPorCategoriaDTO;
import com.cempresarial.entities.DTO.RolPorEvaluacionDTO;
import com.cempresarial.entities.admin.Perfil;
import com.cempresarial.entities.admin.PermisoAgencia;
import com.cempresarial.entities.admin.Usuario;
import com.cempresarial.recursos.SesionController;
import com.cempresarial.recursos.Utilitarios;
import com.cempresarial.rest.client.service.AgenciaService;
import com.cempresarial.rest.client.service.AreaService;
import com.cempresarial.rest.client.service.CatalogoPreguntaService;
import com.cempresarial.rest.client.service.CategoriaService;
import com.cempresarial.rest.client.service.ChecklistCatalogoPreguntaService;
import com.cempresarial.rest.client.service.ChecklistEvaluacionService;
import com.cempresarial.rest.client.service.ChecklistService;
import com.cempresarial.rest.client.service.CiudadService;
import com.cempresarial.rest.client.service.ClienteService;
import com.cempresarial.rest.client.service.EmpleadoService;
import com.cempresarial.rest.client.service.EmpresaService;
import com.cempresarial.rest.client.service.EvaluacionService;
import com.cempresarial.rest.client.service.PerfilService;
import com.cempresarial.rest.client.service.PermisoAgenciaService;
import com.cempresarial.rest.client.service.PreguntaService;
import com.cempresarial.rest.client.service.ProvinciaService;
import com.cempresarial.rest.client.service.RangoService;
import com.cempresarial.rest.client.service.RegionService;
import com.cempresarial.rest.client.service.RespuestaService;
import com.cempresarial.rest.client.service.RolService;
import com.cempresarial.rest.client.service.SectorService;
import com.cempresarial.rest.client.service.ZonaEstructuralService;
import com.cempresarial.rest.client.service.ZonaService;

/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
public class ControlGraficos extends SesionController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControlGraficos() {
		super();
	}

	private Usuario user;
	private String grafico = "";
	private Utilitarios utils;

	@PostConstruct
	public void init() {

		user = getCurrentUser();
		utils = new Utilitarios();

	}

	public void cambiarTemplates(int tipo) {
		try {

			System.out.println("ENTRA ACAMBIAR GRAFICO: " + tipo);

			if (tipo == 1) {
				grafico = "generales.xhtml";

			}
			if (tipo == 2) {
				grafico = "aspectoarea.xhtml";
			}

			if (tipo == 3) {
				grafico = "indicadoresporagencia.xhtml";
			}

			if (tipo == 4) {
				grafico = "indicadoresrol.xhtml";
			}

			if (tipo == 5) {
				grafico = "indicadoresporciudad.xhtml";
			}

			if (tipo == 6) {
				grafico = "indicadoresporarearol.xhtml";
			}

			if (tipo == 7) {
				grafico = "protocolos.xhtml";
			}

			utils.ejecutarPaneles("statusDialog", "h");

		} catch (Exception e) {
			e.printStackTrace();
			utils.ejecutarPaneles("statusDialog", "h");
		}
	}

	public String getGrafico() {
		return grafico;
	}

	public void setGrafico(String grafico) {
		this.grafico = grafico;
	}

}
