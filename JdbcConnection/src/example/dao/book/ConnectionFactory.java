package example.dao.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url ="jdbc:sqlserver://localhost:1433;DatabaseName=db_book";
	private String userName = "sa";
	private String password = "123";
	
	private static ConnectionFactory connectionFactory=null;

	private ConnectionFactory() {
		
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public  Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url, userName, password);
		
	}
	
	public static ConnectionFactory getInstance()
	{   
		if (null==connectionFactory) {
			connectionFactory=new ConnectionFactory();
		}
		return connectionFactory;
		
	}
	
	

}
