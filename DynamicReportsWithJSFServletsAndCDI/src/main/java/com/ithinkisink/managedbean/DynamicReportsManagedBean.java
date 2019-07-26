package com.ithinkisink.managedbean;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.ithinkisink.model.Constancia;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/**
 * 
 * @author Belal
 *
 */
@Named
@SessionScoped
public class DynamicReportsManagedBean implements Serializable {

	private static final long serialVersionUID = -1;

	private String invoiceName;
	private JRBeanCollectionDataSource beanCollectionDataSource;
	private Map<String, Object> parameters;

	@PostConstruct
	public void init() {
//		invoiceName="Invoice.jrxml";
//		invoiceName="constancia.jrxml";
//		
//		List<Item> itemList = new ArrayList<>(Arrays.asList(
//				new Item("01", "Item 01 description", 1.1, 1), 
//				new Item("02", "Item 02 description", 2.2, 2),
//				new Item("03", "Item 03 description", 3.3, 3)));
//		beanCollectionDataSource = new JRBeanCollectionDataSource(itemList);
//		
////		parameters = (new InvoiceDetails("INV#01", "Billing Company", "Billing Company Add", 
////				"Billing Company State 1", "Billing Company State 2", 
////				"Shipping Name", "Shipping Address", "Shipping State 1", "Shipping State 2", 1000)).toMap();
//		
//		parameters = (new Constancia("190713253239", "0000001107552", "13/07/2019 14:10:28", 
//				"11-01-2558990", "ERLITA CORDOVA FERNANDEZ", 
//				"Prueba",
//				"002-193-191153780123-12", "BANCO DE CREDITO DEL PERU", "PEREZ LOPEZ JUAN","Otro Cliente","Soles","S/ 100.00",
//				"S/2.50","S/7.00","S/0.45","S/0.00")).toMap();
		
	}
	
	/**
	 * Preparing an output stream of the generated PDF invoice.
	 * 
	 * @return
	 */
//	public OutputStream getOS(ServletContext context, OutputStream outputStream) {
//
//		parameters.put("IMAGE_PATH", context.getRealPath("/jasper/invoices"));
//
//		InputStream is = context.getResourceAsStream("/jasper/invoices/" + invoiceName);
//
//		try {
//			report().setTemplateDesign(is)
//					.setDataSource(beanCollectionDataSource)
//					.setParameters(parameters).toPdf(outputStream);
//		} catch (DRException e) {
//			e.printStackTrace();
//		}
//
//		return outputStream;
//	}

	// setters and getters
	public String getInvoiceName() {
		return invoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public JRBeanCollectionDataSource getBeanCollectionDataSource() {
		return beanCollectionDataSource;
	}

	public void setBeanCollectionDataSource(
			JRBeanCollectionDataSource beanCollectionDataSource) {
		this.beanCollectionDataSource = beanCollectionDataSource;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}
	
	
	public void exportarPDF(ActionEvent actionEvent) throws JRException, IOException{
		
		 List<Constancia> lstConstancia = new ArrayList<Constancia>();
		 Constancia constancia = new Constancia("190713253239", "0000001107552", "13/07/2019 14:10:28", 
					"11-01-2558990", "ERLITA CORDOVA FERNANDEZ", 
					"Prueba",
					"002-193-191153780123-12", "BANCO DE CREDITO DEL PERU", "PEREZ LOPEZ JUAN","Otro Cliente","Soles","S/ 100.00",
					"S/2.50","S/7.00","S/0.45","S/0.00");
		 lstConstancia.add(constancia);
		 
		
		
//		List<Item> itemList = new ArrayList<>(Arrays.asList(
//				new Item("01", "Item 01 description", 1.1, 1), 
//				new Item("02", "Item 02 description", 2.2, 2),
//				new Item("03", "Item 03 description", 3.3, 3)));
//		
		
		
	
		Map<String,Object> parametros= new HashMap<String,Object>();
		parametros.put("prueba", "Miguel");
		
		File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/jasper/invoices/constancia.jasper"));
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),parametros, new JRBeanCollectionDataSource(lstConstancia));
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition","attachment; filename=jsfReporte.pdf");
		ServletOutputStream stream = response.getOutputStream();
		
		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		
		stream.flush();
		stream.close();
		FacesContext.getCurrentInstance().responseComplete();
	}
	
	
}
