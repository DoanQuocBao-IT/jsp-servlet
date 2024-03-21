package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
	public static Connection getSQLServerConnection_SQLJDBC() //
			throws ClassNotFoundException, SQLException {
		String dbDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL="jdbc:sqlserver://BAO:1433";
		String dbName="myfirst";
		String dbUsername="sa";
		String dbPassword="123456";
		String connectionURL=dbURL+";databaseName="+dbName+";encrypt=true;trustServerCertificate=true;";
		Connection conn=null;
		try {
			Class.forName(dbDriver);
			conn=DriverManager.getConnection(connectionURL,dbUsername,dbPassword);
			System.out.println("connect successfully");
		}catch(Exception ex)
		{
			System.out.println("connect failure");
			ex.printStackTrace();
		}
		return conn;
	}
}
