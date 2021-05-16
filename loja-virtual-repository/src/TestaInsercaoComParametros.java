import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametros {
	
	public static void main(String[] args) throws SQLException {
		
		
		String nome = "Mouse";
		String descricao = "Mouse sem fio";
		
		Connection conn = new CriaConexao().recuperaConexao();
		
		//Para evitar o SQL Injection, existe a preparação do Statement
		PreparedStatement stm = conn.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		
		//Pega o retorno do Statement
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) {
			
			
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
			
		}
		
		
	}
	
}
