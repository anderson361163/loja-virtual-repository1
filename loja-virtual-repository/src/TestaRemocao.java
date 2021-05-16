import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = new CriaConexao().recuperaConexao();
		
		Statement stm = connection.createStatement();
		stm.execute("DELETE PRODUTO WHERE ID > 2");
		//Ele conta a quantidade de linha modificadas
		Integer qtd = stm.getUpdateCount();
		System.out.println("Linhas afetadas: "+ qtd);
		
	}
	
}
