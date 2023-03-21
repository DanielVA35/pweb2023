package br.edu.ifgoiano.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastroUsuario")
public class CadastroUsuarioServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3572994547498409627L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String senha1 = req.getParameter("senha1");
		String senha2 = req.getParameter("senha2");
		
		if (senha1.equals(senha2)) {
			resp.sendRedirect("index.html");
		}else {
			req.getRequestDispatcher("cadastroDeUsuario.html").forward(req, resp);
		}
		
	}
	
}
