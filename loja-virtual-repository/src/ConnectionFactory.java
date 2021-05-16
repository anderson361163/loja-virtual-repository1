import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
	public ConnectionFactory() {
		
		ComboPooledDataSource comboPoolDataSource = new ComboPooledDataSource();
		
		comboPoolDataSource.setJdbcUrl(
		"jdbc:mysql://localhost/loja_virtual?useTimezone=true&"
		+ "serverTimezone=UTC&"
		+ "autoReconnect=true&"
		+ "useSSL=false");
		
		
		//define que haverá 15 conexões abertas
		comboPoolDataSource.setMaxPoolSize(15);
		
		
		comboPoolDataSource.setUser("root");
		comboPoolDataSource.setPassword("root");
		
		this.dataSource = comboPoolDataSource;
		
	}
	
	public Connection recuperarConexao() throws SQLException{
		return this.dataSource.getConnection();
	}
	
	
}
