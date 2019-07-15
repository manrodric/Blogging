package com.ithinkisink.model;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Constancia {

	private String numeroReferencia;
	private String numeroOperacion;
	private String fechaPresentacion;
	private String cuentaOrigen;
	private String titularCtaOrigen;
	private String glosa;
	private String cci;
	private String banco;
	private String titularCcci;
	private String tipoCliente;
	private String moneda;
	private String montoTransferir;
	private String comisionCmac;
	private String gastoBanco;
	private String igv;
	private String itf;

	public Constancia(String numeroReferencia, String numeroOperacion, String fechaPresentacion, String cuentaOrigen,
			String titularCtaOrigen, String glosa, String cci, String banco, String titularCcci, String tipoCliente, String moneda, String montoTransferir, String comisionCmac,
			String gastoBanco, String igv, String itf) {
		super();
		this.numeroReferencia = numeroReferencia;
		this.numeroOperacion = numeroOperacion;
		this.fechaPresentacion = fechaPresentacion;
		this.cuentaOrigen = cuentaOrigen;
		this.titularCtaOrigen = titularCtaOrigen;
		this.glosa = glosa;
		this.cci = cci;
		this.banco = banco;
		this.titularCcci = titularCcci;
		this.tipoCliente = tipoCliente;
		this.moneda = moneda;
		this.montoTransferir = montoTransferir;
		this.comisionCmac = comisionCmac;
		this.gastoBanco = gastoBanco;
		this.igv = igv;
		this.itf = itf;
	}

	public String getNumeroReferencia() {
		return numeroReferencia;
	}

	public void setNumeroReferencia(String numeroReferencia) {
		this.numeroReferencia = numeroReferencia;
	}

	public String getNumeroOperacion() {
		return numeroOperacion;
	}

	public void setNumeroOperacion(String numeroOperacion) {
		this.numeroOperacion = numeroOperacion;
	}

	public String getFechaPresentacion() {
		return fechaPresentacion;
	}

	public void setFechaPresentacion(String fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
	}

	public String getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(String cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public String getTitularCtaOrigen() {
		return titularCtaOrigen;
	}

	public void setTitularCtaOrigen(String titularCtaOrigen) {
		this.titularCtaOrigen = titularCtaOrigen;
	}

	public String getGlosa() {
		return glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getCci() {
		return cci;
	}

	public void setCci(String cci) {
		this.cci = cci;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getTitularCcci() {
		return titularCcci;
	}

	public void setTitularCcci(String titularCcci) {
		this.titularCcci = titularCcci;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getMontoTransferir() {
		return montoTransferir;
	}

	public void setMontoTransferir(String montoTransferir) {
		this.montoTransferir = montoTransferir;
	}

	public String getComisionCmac() {
		return comisionCmac;
	}

	public void setComisionCmac(String comisionCmac) {
		this.comisionCmac = comisionCmac;
	}

	public String getGastoBanco() {
		return gastoBanco;
	}

	public void setGastoBanco(String gastoBanco) {
		this.gastoBanco = gastoBanco;
	}

	public String getIgv() {
		return igv;
	}

	public void setIgv(String igv) {
		this.igv = igv;
	}

	public String getItf() {
		return itf;
	}

	public void setItf(String itf) {
		this.itf = itf;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> objectAsMap = new HashMap<String, Object>();
		try {
			BeanInfo info = Introspector.getBeanInfo(this.getClass());
			for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
				Method reader = pd.getReadMethod();
				if (reader != null)
					objectAsMap.put(pd.getName(), reader.invoke(this));
			}
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// when opps happens
			e.printStackTrace();
		}
		return objectAsMap;
	}
}