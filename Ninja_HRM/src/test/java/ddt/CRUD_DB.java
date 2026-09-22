package ddt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class CRUD_DB {

	public static void main(String[] args) throws Exception{

		Driver d = new Driver();
		DriverManager.registerDriver(d);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm","root@%","root");
		Statement st = con.createStatement();	
		//execute	
//		st.execute("create table shivamrts(name VARCHAR(20));");
//		st.execute("insert into shivamrts values('shivam');");
//		
//		boolean status = st.execute("select * from shivamrts;");
//		if(status==true)
//			System.out.println("table created");
//		else
//			System.out.println("table not created");
		
		//executeQuery
		//reading data from db
		
		ResultSet set = st.executeQuery("select * from project;");
		while(set.next())
		{
			System.out.println("PID:"+set.getString(1)+"CreatedBy:"+set.getString(2)+"CreatedOn:"+set.getString(3)+"Project_name:"+set.getString(4)+"Status:"+set.getString(5)+"Team size:"+set.getString(6));
		}
			
		con.close();
		//execute update
		int i = st.executeUpdate("insert into project values('NH_PROJ_111','ABC','03/09/2026','RUTGFHU','OnGoing','5');");
		System.out.println("I:"+i);
		//st.execute("drop table shivamrts;");
		
	}

}
