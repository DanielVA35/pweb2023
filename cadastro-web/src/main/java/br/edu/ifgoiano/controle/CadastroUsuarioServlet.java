package br.edu.ifgoiano.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.entidade.Usuario;

@WebServlet("/cadastroUsuario")
public class CadastroUsuarioServlet extends HttpServlet {
	
	//Simulando o banco de dados
	private List<Usuario> lstDeUsuario;
	
	@Override
	public void init() throws ServletException {
		this.lstDeUsuario = new ArrayList<Usuario>();
	}
	
	
	private static final long serialVersionUID = -3572994547498409627L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String senha1 = req.getParameter("senha1");
		String senha2 = req.getParameter("senha2");
		
		//Verificar se as senhas são iguais
		if (senha1.equals(senha2)) {
			Usuario usu = new Usuario();
			usu.setNome(req.getParameter("nome"));
			usu.setEmail(req.getParameter("email"));
			usu.setSenha(senha1);
			
			lstDeUsuario.add(usu);
			
			//Redireciona o usuario para a tela de login
			resp.sendRedirect("index.html");
			
		}else {
			req.getRequestDispatcher("usuarioCadastro.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		for (Usuario usuario : lstDeUsuario) {
			System.out.println(usuario.getNome().concat("-").concat(usuario.getEmail()));
		}

	}
	
	@Override
	public void destroy() {
		this.lstDeUsuario.clear();
	}
	
}
