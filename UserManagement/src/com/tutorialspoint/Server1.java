package com.tutorialspoint;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/server1") 
public class Server1 {
	
	
	 	 
	 
   @GET
   @Produces(MediaType.APPLICATION_OCTET_STREAM)
   @Path("/read/{fileName}")
   public Response getFileForRead(@PathParam("fileName") String fileName) throws Exception{
	   
     File file = new File("E:\\TRINITY COURSE WORK\\SCALABLE COMPUTING\\Assignment 2\\UserManagement\\server1_files\\" + fileName);
     System.out.println("hi");
     return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
         .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
         .build();
   }
   
   
   @GET
   @Produces(MediaType.APPLICATION_OCTET_STREAM)
   @Path("/write/{fileName}")
   public Response getFileForEdit(@PathParam("fileName") String fileName) throws Exception{
	   
     File file = new File("E:\\TRINITY COURSE WORK\\SCALABLE COMPUTING\\Assignment 2\\UserManagement\\server1_files\\" + fileName);
     //update db for lock
     String modeOfFile = checkStatus("file1");
     if(modeOfFile.equals("unlocked")) {
    	 lockTheFile("file1");
    	 return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
    	         .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
    	         .build();
     }else {
    	 return Response.ok("sorry this file is already in use by other user for editing", MediaType.TEXT_PLAIN).build();
     }
     
     
   }
   
   
   private String checkStatus(String aliasName)throws Exception {  
		String url="jdbc:mysql://localhost:3306/filedetails";
		String uname ="shobhit";
		String pass = "pearl";
		String query = "Select permission from lockStatus where alias=" + "'" + aliasName+ "'";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String value= rs.getString("permission");
		System.out.println(value);
		st.close();
		con.close();
		return value;
		}
   
   private String lockTheFile(String aliasName)throws Exception {  
		String url="jdbc:mysql://localhost:3306/filedetails";
		String uname ="shobhit";
		String pass = "pearl";
		
		String query = "UPDATE lockStatus  SET permission = 'locked' where alias=" + "'" + aliasName+ "'";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		st.executeUpdate(query);
		st.close();
		con.close();
		return "";
		}
}
