package br.edu.ifgoiano.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import br.edu.ifgoiano.entidade.Usuario;

public class UsuarioRepositorio {


	private Connection getConnection() throws SQLException {
		return DriverManager.
		        getConnection("jdbc:h2:~/usuariodb", "sa", "sa");
	}

	
	public List<Usuario> listarUsuario(){
		ArrayList<Usuario> lstUsuario = new ArrayList<Usuario>();
		
		String sql = "select id, nome, email, data_nascimento from usuario";
		try( Connection conn = this.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);){
			
			ResultSet resultSet = pst.executeQuery();
			
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setDataNascimento(resultSet.getDate("data_nascimento"));
				
				lstUsuario.add(usuario);
			}
		}catch(SQLException ex) {
			System.out.println("Erro na consulta de usuarios");
			ex.printStackTrace();
		}
		return lstUsuario;
		
	}
	
	public void inserirUsuario(Usuario usuario) {
		//Criar a SQL de insert
		StringBuilder sql = new StringBuilder();
		sql.append("insert into usuario ");
		sql.append("(nome, email, senha) ");
		sql.append("values(?, ?, ?) ");
		
		//Abrir uma conex�o
		try(Connection conn = this.getConnection();
				
		//Preparar a SQL para ser executada
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				) {
				pst.setString(1, usuario.getNome());
				pst.setString(2, usuario.getEmail());
				pst.setString(3, usuario.getSenha());
				
		
			
		//Executar a SQL
			pst.execute();
			
			conn.commit();
			
		} catch (SQLException e) {
			System.out.println("Erro na inclus�o de usuario");
			e.printStackTrace();
		}
	}
	public Usuario obterUsuario(Integer id) {
		String sql = "select nome, email, senha from usuario where id = ?";
		
		try( Connection conn = this.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, id);
			
			ResultSet resultSet = pst.executeQuery();
			
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(id);
				usuario.setNome(resultSet.getString("nome"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				
				return usuario;
			}
		}catch(SQLException ex) {
			System.out.println("Erro na consulta de usuarios");
			ex.printStackTrace();
		}
		
		throw new RuntimeErrorException(null, "Usu�rio n�o encontrado");
	}


	public void alterarUsuario(Usuario usuario) {
		//Criar a SQL de alterar
		StringBuilder sql = new StringBuilder();
		sql.append("update usuario set ");
		sql.append("nome = ?, ");
		sql.append("email = ?, ");
		sql.append("senha = ? ");
		sql.append("where id = ?");
		
		//Abrir uma conex�o
		try(Connection conn = this.getConnection();
				
		//Preparar a SQL para ser executada
				PreparedStatement pst = conn.prepareStatement(sql.toString());
				) {
				pst.setString(1, usuario.getNome());
				pst.setString(2, usuario.getEmail());
				pst.setString(3, usuario.getSenha());
				pst.setInt(4, usuario.getId());

		//Executar a SQL
			pst.execute();
			
			conn.commit();
			
		} catch (SQLException e) {
			System.out.println("Erro na altera��o de usuario");
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
