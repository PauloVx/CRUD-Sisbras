package backend;

import java.sql.*;

public class DatabaseController {
	
	public static Connection getConnection() {
		final String connectionString = "jdbc:postgresql://localhost:5432/crudsisbras";
		final String user = "postgres";
		final String password = "admin";
		
		Connection connection;
		
		try {
			connection = DriverManager.getConnection(connectionString, user, password);
			System.out.println("Conectado ao PostgreSQL");
			
			return connection;
		}
		catch (SQLException e) {
			e.printStackTrace();
			
			return null;
		}
	}
	
}
