import java.sql.Connection;
import java.sql.SQLException;

public class TestaPoolDeConexoes {

	public static void main(String[] args) throws SQLException {
		
		
		ConnectionFactory factory = new ConnectionFactory();
		
		
		for(int i = 0; i < 20; i++) {
			
			factory.recuperarConexao();
			System.out.println("Conex�es de numeros: " +i);
		}
		
	}
	
	
}
