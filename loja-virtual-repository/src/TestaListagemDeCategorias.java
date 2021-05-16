import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ProdutoDao;
import modelo.Categoria;
import modelo.CategoriaDAO;
import modelo.Produto;

public class TestaListagemDeCategorias {
	public static void main(String[] args) throws SQLException {

		//ListandoCategorias();
		System.out.println("--------------------------------");
		//buscarPorParametro();
		System.out.println("--------------------------------");
		BuscarPorParametroComJoin();
		
		
	}

	private static void BuscarPorParametroComJoin() throws SQLException {
		try (Connection connection = new ConnectionFactory().recuperarConexao()){
			CategoriaDAO categoria = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoria.listarComProduto();
			for(Categoria ct : listaDeCategorias) {
				System.out.println(ct.getNome());
				for(Produto produto : new ProdutoDao(connection).buscar(ct)) {
					System.out.println("Produto: " + produto.getNome());
				}
			}
		}
	}

	private static void buscarPorParametro() throws SQLException {
		try (Connection connection = new ConnectionFactory().recuperarConexao()){
			CategoriaDAO categoria = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoria.listar();
			for(Categoria ct : listaDeCategorias) {
				System.out.println(ct.getNome());
				for(Produto produto : new ProdutoDao(connection).buscar(ct)) {
					System.out.println("Produto: " + produto.getNome());
				}
			}
		
		}
	}

	private static void ListandoCategorias() throws SQLException {
		try (Connection connection = new ConnectionFactory().recuperarConexao()){
			CategoriaDAO categoria = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoria.listar();
			for(Categoria ct : listaDeCategorias) {
				System.out.println(ct.getNome());
			}
		
		}
	}
}
