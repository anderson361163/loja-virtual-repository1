import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestaConexao {
	
	
	
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("Abrindo conexão");
		
		Connection connection = DriverManager.
				//para retirar o warning adicione o "&autoReconnect=true&useSSL=false"
				getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "root");
				
		System.out.println("Fechando conexão");
		
		connection.close();
	}
	
	
	
	
	
}
