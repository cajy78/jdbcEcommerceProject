package servlets;
import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;

public class DatabaseConnection {
	private static Connection con = null;
	
	protected static Connection InitiateDBConnection()
	{
		Properties dbProp = new Properties();
		try {
			FileInputStream dbIn = new FileInputStream("C:\\Users\\cajy7\\git\\eCommerce\\eCommerce\\build\\dbConfig.properties");
			dbProp.load(dbIn);
			dbIn.close();
			
			String driver = dbProp.getProperty("jdbc.driver");
			if(driver!=null)
				Class.forName(driver);
			
			String url = dbProp.getProperty("jdbc.url");
			String user = dbProp.getProperty("jdbc.username");
			String pwd = dbProp.getProperty("jdbc.password");
			con = DriverManager.getConnection(url, user, pwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}

}
