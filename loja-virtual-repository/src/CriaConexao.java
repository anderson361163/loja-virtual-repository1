import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriaConexao {
	
	//isso � chamado de uma factory j� que � uma fabrica de conex�es que produz conex�es com o banco
	public Connection recuperaConexao() throws SQLException {

		Connection connection = DriverManager.
				getConnection("jdbc:mysql://localhost/loja_virtual?"
						+ "useTimezone=true&serverTimezone=UTC&"
						+ "autoReconnect=true&useSSL=false", "root", "root");
	
		return connection;
		
	}

	
}
