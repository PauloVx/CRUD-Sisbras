package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;

import models.AutoPeca;

public class AutoPecaController {

	public static void inserirAutoPeca(AutoPeca autoPeca) {
		
		Connection connection = DatabaseController.getConnection();
		
		PreparedStatement stmt;
		
		String query = "INSERT INTO autopecas (nome, preco, descricao, qtd_estoque) VALUES (?, ?, ?, ?)";
		
		try {
			stmt = connection.prepareStatement(query);
			
			stmt.setString(1, autoPeca.getNome());
			stmt.setFloat(2, autoPeca.getPreco());
			stmt.setString(3, autoPeca.getDescricao());
			stmt.setInt(4, autoPeca.getQtdEmEstoque());
			
			stmt.execute();
			System.out.println("Nova peï¿½a inserida com sucesso");
			
			stmt.close();
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<AutoPeca> listarTodasAsPecas() {
		Connection connection = DatabaseController.getConnection();
		
		Statement stmt;
		
		String query = "SELECT * FROM autopecas";
		
		try {
			stmt = connection.createStatement();
			
			ResultSet result = stmt.executeQuery(query);
			
			List<AutoPeca> pecas = new ArrayList<AutoPeca>();
			
			//Nada encontrado.
			if(!result.next()) return null;
			
			while(result.next()) {
				
				int cod = result.getInt("codigo");
				String nome = result.getString("nome");
				float preco = result.getFloat("preco");
				String descricao = result.getString("descricao");
				int qtd = result.getInt("qtd_estoque");
				
				pecas.add(new AutoPeca(cod, nome, preco, descricao, qtd));
			}
			
			stmt.close();
			connection.close();
			
			return pecas;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static AutoPeca listarUnicaPeca(int codigo) {
		Connection connection = DatabaseController.getConnection();
		PreparedStatement stmt;
		ResultSet result;
		
		String query = "SELECT * FROM autopecas WHERE codigo=?";
		
		try {
			stmt = connection.prepareStatement(query);
			
			stmt.setInt(1, codigo);
			
			result = stmt.executeQuery();
			
			//Nada encontrado.
			if(!result.next()) return null;
			
			int cod = result.getInt("codigo");
			String nome = result.getString("nome");
			float preco = result.getFloat("preco");
			String descricao = result.getString("descricao");
			int qtd = result.getInt("qtd_estoque");
			
			
			stmt.close();
			connection.close();
			
			return new AutoPeca(cod, nome, preco, descricao, qtd);
		}
		catch(SQLException e) { e.printStackTrace(); }
		
		return null;
	}
	
	public static void atualizarPeca(AutoPeca p) {
		
	}
	
	public static boolean excluirPeca(int codigo) {
		Connection connection = DatabaseController.getConnection();
		PreparedStatement stmt;

		String query = "DELETE FROM autopecas WHERE codigo=?";

		try {
			stmt = connection.prepareStatement(query);

			stmt.setInt(1, codigo);
			
			int linhasAfetadas = stmt.executeUpdate();
			
			//Excluiu
			if(linhasAfetadas > 0 ) return true;
			
			stmt.close();
			connection.close();

			System.out.println("Operação realizada com sucesso.");
		}
		catch(SQLException e) { e.printStackTrace(); }

		//Nada encontrado
		return false;
	}
}
