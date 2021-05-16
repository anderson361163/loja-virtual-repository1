import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	
public static void main(String[] args) throws SQLException {
		
		System.out.println("Abrindo conexão");
		
		//instancia um objeto da fabrica de conexões
		CriaConexao criaConexao = new CriaConexao();
		// coloca o produto
		Connection connection = criaConexao.recuperaConexao();

		Statement stm = connection.createStatement();
		
		
		boolean resultado = stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		System.out.println("Ele verifica se vai retornar algo: (Sim/Não): " + resultado);
		
		//ResultSet é do java 7
		ResultSet rs = stm.getResultSet();
		
		//enquanto tiver itens na lista ele vai trazer os dados
		while(rs.next()) {
			/*
			Para pegar elementos do Statement, pode se usar o indice que começa em 1
			ou pegar pelo label da tabela (contudo se ela mudar de nome perde o caminho)
			*/
			Integer id = rs.getInt("ID");
			String nome = rs.getString("nome");
			String descricao = rs.getString("descricao");
		}
		
		System.out.println("Fechando conexão");
		
		
		connection.close();
	
	}
	
}
