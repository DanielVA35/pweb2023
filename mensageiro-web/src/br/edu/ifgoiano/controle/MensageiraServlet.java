package br.edu.ifgoiano.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mensageiro")
public class MensageiraServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<String> lstDeEmails = new ArrayList<String>();	

		lstDeEmails.add("usuario1@gmail.com");
		lstDeEmails.add("usuario2@gmail.com");
		lstDeEmails.add("usuario3@gmail.com");

		req.setAttribute("lstDeEmails", lstDeEmails);

		req.getRequestDispatcher("index.jsp").forward(req, resp);


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("emails");
		String tipoCumprimento = req.getParameter("cumprimento");
		String aviso = req.getParameter("aviso");
		String titulo = req.getParameter("titulo");
		String texto = req.getParameter("texto");

		String msgAviso = " ";
		Calendar c1 = Calendar.getInstance();
		int hora = c1.get(Calendar.HOUR_OF_DAY);

		String cumprimento = "";

		if(tipoCumprimento == "formal") {
			cumprimento = "Prezada(o),";
		} else if(hora >= 5 && hora <= 11){
			cumprimento = "Bom Dia,";
		}else if(hora >= 12 && hora <= 18){
			cumprimento = "Boa Tarde,";
		}else{
			cumprimento = "Boa Noite,";
		}

		if (!(aviso == null)) {
			if(aviso.equals("automatico")) {
				msgAviso = "Atenção: esse é um e-mail automático e não deve ser respondido.";
			}
		}

		if(!(email.isEmpty() && titulo.isEmpty() && texto.isEmpty())) {

			req.getRequestDispatcher("Sucesso.jsp");

			System.out.println("E-mail enviado para:" + email + "\n"
					+ titulo + "\n"
					+ cumprimento + "\n"
					+ texto + "\n" 
					+ msgAviso);

		}else {
			req.getRequestDispatcher("erro.jsp");
		}
		
	}
}
