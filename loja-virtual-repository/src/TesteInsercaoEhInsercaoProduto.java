import modelo.Produto;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.ProdutoDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class TesteInsercaoEhInsercaoProduto {
	
	public static void main(String[] args) throws SQLException {
		
		Produto comada = new Produto("Cômoda", "Cômoda Vertical");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			//new ProdutoDao(persistencia).salvarProduto(comada); forma mimificada
			ProdutoDao persistencia = new ProdutoDao(connection);
			persistencia.salvar(comada);
			
			List<Produto> listaProdutos = persistencia.listar();
			
			for(Produto produto : listaProdutos) {
				System.out.println(produto);
			}
		
		}
		
	}
	
}
