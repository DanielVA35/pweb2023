package br.edu.ifgoiano.controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

@WebServlet("/soma")
public class somaServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String n1 = req.getParameter("numero1");
		String n2 = req.getParameter("numero2");
		float resultado = Float.parseFloat(n1) + Float.parseFloat(n2);
		
		System.out.println(resultado);
		
		
		String htmlResultado = "<html><body><h1>O resultado é " + resultado + "</h1></body></html>";
		
		PrintWriter escrev = resp.getWriter();
		escrev.println(htmlResultado);
		
	}
}
