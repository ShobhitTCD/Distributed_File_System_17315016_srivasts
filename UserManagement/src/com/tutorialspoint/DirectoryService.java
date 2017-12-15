package com.tutorialspoint;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import DirectoryService.FileFormBean;
import KeyEncryptionStorage.KeyEncryptionInformation;





@Path("/directoryService") 


public class DirectoryService {
	
	
	   @GET 
	   @Produces(MediaType.APPLICATION_XML) 
	   @Path("{fileName}")
	   public String sayHelloXMl(@PathParam("fileName") String fileName) throws Exception{
		   
		   String aliasName = getAliasNameFromDB(fileName);
		   
		   return getPathAndServerName(aliasName);
	   }

	   
	   
	   
	   private String getAliasNameFromDB(String fileName)throws Exception {  
		String url="jdbc:mysql://localhost:3306/filedetails";
		String uname ="shobhit";
		String pass = "pearl";
		String query = "Select alias from filealias where filename=" + "'" + fileName+ "'";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String name= rs.getString("alias");
		System.out.println(name);
		st.close();
		con.close();
		return name;
		}
	   
	   
	   private String getPathAndServerName(String fileName)throws Exception {  
		String url="jdbc:mysql://localhost:3306/filedetails";
		String uname ="shobhit";
		String pass = "pearl";
		String query = "Select path from fileinformation where alias=" + "'" + fileName+ "'";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String name= rs.getString("path");
		System.out.println(name);
		st.close();
		con.close();
		return name;
		}
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	



























public String authenticateTheKey(String fileQueried) throws Exception {
		
		// The name of the file to open.
    String fileName = KeyEncryptionInformation.getFileDetails() ;

    // This will reference one line at a time
    String line = null;
    

    try {
        // FileReader reads text files in the default encoding.
        FileReader fileReader = 
            new FileReader(fileName);

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = 
            new BufferedReader(fileReader);
        List<FileFormBean> fileDetailList =  new ArrayList<FileFormBean>();
        while((line = bufferedReader.readLine()) != null) {
        	FileFormBean fb = new FileFormBean();
        	fb.setFileName(line.split(";")[0]);
        	fb.setFileAlias(line.split(";")[1]);
        	fb.setServerLocation(line.split(";")[2]);
        	fileDetailList.add(fb);
        	if(fb.getFileName().equals(fileQueried)) {
        		return fb.getServerLocation();
        	}
        }   
        

        // Always close files.
        bufferedReader.close();         
    }
    catch(FileNotFoundException ex) {
        System.out.println(
            "Unable to open file '" + 
            fileName + "'");                
    }
    catch(IOException ex) {
        System.out.println(
            "Error reading file '" 
            + fileName + "'");                  
        // Or we could just do this: 
        // ex.printStackTrace();
    }

		return " ";
	}
}
