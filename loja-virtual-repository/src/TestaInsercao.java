import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = new CriaConexao().recuperaConexao();
		Statement stm = conn.createStatement();
		
		//como o retorno do insert/delet/update é false (por não apresentar retorno) fica assim
		stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('Mouse', 'Mouse sem fio')",
				//com esse novo parametro você consegue saber o retorno do id
				Statement.RETURN_GENERATED_KEYS);
		
		//Pega o retorno do Statement
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) {
			
			
			
			
		}
		
		
		
	}
	
}
