package com.tutorialspoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testDB {
	
	public static void main(String[] args)throws Exception
	{   String url="jdbc:mysql://localhost:3306/filedetails";
	String uname ="shobhit";
	String pass = "pearl";
	String filenaam ="'radhe'";
	String query = "Select user from adminusers where user=" + filenaam ;
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(url,uname,pass);
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(query);
	rs.next();
	String name= rs.getString("user");
	System.out.println(name);
	st.close();
	con.close();
	}
}
