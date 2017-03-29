package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Obtem a conexão com o banco de dados
	public static Connection obtemConexao() throws SQLException {
		return (Connection) DriverManager.getConnection("jdbc:mysql://localhost/predial?user=alunos&password=alunos");
	}
}
