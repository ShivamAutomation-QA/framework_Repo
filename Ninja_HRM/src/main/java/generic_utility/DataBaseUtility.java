package generic_utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility 
{
	public Connection getDBConnection (String url,String un,String pwd) throws Exception
	{
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		return DriverManager.getConnection(url, un, pwd);
	}
	
	public boolean validateDataEntry(String tName,String cName,String data,String url,String un,String pwd) throws Exception
	{
		Connection con = getDBConnection(url, un, pwd);
		Statement st = con.createStatement();
		return st.execute("select * from "+tName+"where"+cName+"='"+data+"';");
	}
	
	public ResultSet readDataDromDb (String url,String un,String pwd,String query) throws Exception
	{
		Connection con = getDBConnection(url, un, pwd);
		Statement st = con.createStatement();
		return st.executeQuery(query);
	}
	
	public void closeConnection(Connection con) throws Exception
	{
		con.close();
	}
}
