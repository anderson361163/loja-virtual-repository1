import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametros2 {

	public static void main(String[] args) throws SQLException {


		String nome = "Mouse";
		String descricao = "Mouse sem fio";

		try(Connection conn = new CriaConexao().recuperaConexao()){

			//2. com este comando, ele desativa o auto comite
			conn.setAutoCommit(false);

			//Desde o java 7 existe o recurso de auto fechamento de transação na interface Statement
			try(
				//Para evitar o SQL Injection, existe a preparação do Statement
				PreparedStatement stm = conn.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
				){


				adicionarVariavel(nome, descricao, stm);
				adicionarVariavel("celular", "Samsung Galaxy M21S", stm);


				//fecha a transação das duas inserções
				conn.commit();
				
				//Não precisa dele, caso use o try para fechar a conexão
				//conn.close();
			}catch(Exception ex) {

				ex.printStackTrace();

				System.out.println("Rollback executado");
				conn.rollback();
			}
		}

	}

	/* 
	 * Para criar métodos de trechos de código use o atalho ctrl+3 e escolha a opção "Extração de método"
	 * 1. uma vez executado esse método será feita uma transação
	 */
	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		stm.execute();


		//Pega o retorno do Statement
		try(ResultSet rst = stm.getGeneratedKeys()){

			while(rst.next()) {


				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);

			}
		}
	}

}
