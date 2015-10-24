package br.com.projetoperiodo.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEnviaDocumento
 */
public class ServletEnviaDocumento extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String PATH_RELATORIO = "\\pdf\\relatorio.pdf";
    private static final String FILE_NAME = "relatorio.pdf";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEnviaDocumento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String contextPath = getServletContext().getRealPath("//");
		File pdfFile = new File(contextPath + PATH_RELATORIO);

		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=" + FILE_NAME);
		response.setContentLength((int) pdfFile.length());

		FileInputStream fileInputStream = new FileInputStream(pdfFile);
		OutputStream responseOutputStream = response.getOutputStream();
		int bytes;
		while ((bytes = fileInputStream.read()) != -1) {
			responseOutputStream.write(bytes);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
