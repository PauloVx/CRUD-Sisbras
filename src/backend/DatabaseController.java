package backend;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DatabaseController {
	
	public static Connection getConnection() {
		Connection connection;
		
		try {
			Properties props = getProperties();
			final String connectionString = props.getProperty("banco.url");
			final String user = props.getProperty("banco.usuario");
			final String password  = props.getProperty("banco.senha");
			
			connection = DriverManager.getConnection(connectionString, user, password);
			System.out.println("Conectado ao PostgreSQL");
			
			return connection;
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
			
			return null;
		}
	}
	
	private static Properties getProperties() throws IOException {
		Properties arquivoProperties = new Properties();
		String caminho = "/conexao-banco.properties";
		arquivoProperties.load(DatabaseController.class.getResourceAsStream(caminho));
		return arquivoProperties;
	}
	
}
