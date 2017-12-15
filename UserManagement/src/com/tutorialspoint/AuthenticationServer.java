package com.tutorialspoint;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.SessionTrackingMode;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ConfidentialInformation.RegisteredUser;
import KeyEncryptionStorage.KeyEncryptionInformation;

  // This is the authentication server
/**
 * 
 * @author mshob_000
 * User first has to come to this server for the authentication
 */

@Path("/userAutentication") 

public class AuthenticationServer  {  
   
   @GET 
   @Produces(MediaType.APPLICATION_XML) 
   @Path("{userName}")
   public String sayHelloXMl(@PathParam("userName") String userName){
	   
	   
	   try {
		if(!authenticateTheUser(userName)) {
			   return "Sorry You  don't have access";
		   }
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	   
	   String keyOfTheUser ="";
		   
		   Random rand = new Random();

		   int  key = rand.nextInt(500000) + 1;
		   
		   String encrytedKey="";
		   
		   // We have to encrypt this key
		  try {
			  int  secondKey = rand.nextInt(5000000) + 1;
			  String firstKey =  String.valueOf(key);
			encrytedKey = encrypt(String.valueOf(secondKey), firstKey);
			writeKeyAndEncryptedMssg(firstKey    ,encrytedKey, String.valueOf(secondKey));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return encrytedKey;
	   
	   
	   
   }
   
   
   // this method encrypt the key
   public static String encrypt(String strClearText,String strKey) throws Exception{
		String strData="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted=cipher.doFinal(strClearText.getBytes());
			strData=new String(encrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}
   
   public static String decrypt(String strEncrypted,String strKey) throws Exception{
		String strData="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
			byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
			strData=new String(decrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}
   // This method Decrypt the key
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   public void writeKeyAndEncryptedMssg(String key, String encryptedMessage,String secondkey) {
	   
	    String FILENAME = KeyEncryptionInformation.getKeyPwdFile();
	   
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = key + ";" + encryptedMessage + ";" + secondkey;

			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
   }
   
   
   
   
public boolean authenticateTheUser(String userName) throws Exception {  
	String url="jdbc:mysql://localhost:3306/filedetails";
	String uname ="shobhit";
	String pass = "pearl";
	String query = "Select user from adminusers where user=" + "'" + userName+ "'";
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(url,uname,pass);
	Statement st = con.createStatement();
	if(st.executeQuery(query) != null)  {
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String name= rs.getString("user");
		if(name.equals("userName")) {
			return false;
		}
		System.out.println(name);
		st.close();
		con.close();
		
	}
		return true;
	
	
	
	
	}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
