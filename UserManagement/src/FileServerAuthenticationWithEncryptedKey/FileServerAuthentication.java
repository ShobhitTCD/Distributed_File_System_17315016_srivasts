package FileServerAuthenticationWithEncryptedKey;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import KeyEncryptionStorage.KeyEncryptionInformation;

@Path("/fileAutentication") 

public class FileServerAuthentication {
	
	
	   @GET 
	   @Produces(MediaType.APPLICATION_XML) 
	   @Path("{encrytedKey}")
	   public String sayHelloXMl(@PathParam("encrytedKey") String encrytedKey) throws Exception{
		   
		   
		   
		   return authenticateKey(encrytedKey);
		   
	   }
	 
	 
	 public   String authenticateKey(String encryptedKey) throws Exception {
		 
			 String fileName = KeyEncryptionInformation.getKeyPwdFile();

		     // This will reference one line at a time
		     String line = null;
		     String result ="";

		     try {
		         // FileReader reads text files in the default encoding.
		         FileReader fileReader = 
		             new FileReader(fileName);

		         // Always wrap FileReader in BufferedReader.
		         BufferedReader bufferedReader = 
		             new BufferedReader(fileReader);
		         
		         while((line = bufferedReader.readLine()) != null) {
		         	  line.split(";");
		         	  System.out.println(line.split(";")[0]);
		         	 System.out.println(line.split(";")[1]);
		         	  String decryptedKey = decrypt(encryptedKey,line.split(";")[0]);
		         	  System.out.println(decryptedKey);
		               if(line.split(";").length != 0 && line.split(";")[2].equals(decryptedKey)) {
		             	  System.out.println("sahi kaam kiya");
		             	 result ="sahi kaam kiya";
		               }else {
		             	  System.out.println("nahi kaam kiya");
		             	 result ="nahi kaam kiya";
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

				
			
		 
		 
		 
		 return result;
		 
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
	   
}
