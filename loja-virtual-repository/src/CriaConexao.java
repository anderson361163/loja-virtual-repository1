import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriaConexao {
	
	//isso é chamado de uma factory já que é uma fabrica de conexões que produz conexões com o banco
	public Connection recuperaConexao() throws SQLException {

		Connection connection = DriverManager.
				getConnection("jdbc:mysql://localhost/loja_virtual?"
						+ "useTimezone=true&serverTimezone=UTC&"
						+ "autoReconnect=true&useSSL=false", "root", "root");
	
		return connection;
		
	}

	
}
