import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class JdbcDemo1 {
	
	public static Connection conn=null;
	
	public static Connection dbConnector()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			conn=DriverManager.getConnection("jdbc:sqlite:Sln.sqlite");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return conn;
	}
}
