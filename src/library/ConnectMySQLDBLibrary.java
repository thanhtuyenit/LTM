package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectMySQLDBLibrary {
	
	private Connection connection;
	private String url;
	private String user;
	private String pass;
	private ReadPropertiesLibrary propertiesLibrary;
	private Properties properties = null;
	public ConnectMySQLDBLibrary(){
		propertiesLibrary = new ReadPropertiesLibrary();
		properties = propertiesLibrary.readProperties();
		this.url = properties.getProperty("url");
		this.user = properties.getProperty("username");
		this.pass = properties.getProperty("password");
	}
	public Connection getConnectMySQL(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void main(String[] args) {
		ConnectMySQLDBLibrary conn = new ConnectMySQLDBLibrary();
		System.out.println(conn.getConnectMySQL());
	}
}
