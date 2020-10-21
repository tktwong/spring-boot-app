package com.appswalker.nplusone.example.controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private DataSource dataSource;

	@PostMapping
	public void export(@RequestParam Map<String, Object> books, HttpServletResponse response) throws JRException, SQLException, IOException {
		
		books = books == null ? new HashMap<>() : books;
		InputStream jasperStream = this.getClass().getResourceAsStream("/reports/books.jasper");
		
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, books, dataSource.getConnection());

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline; filename=books.pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}

}
