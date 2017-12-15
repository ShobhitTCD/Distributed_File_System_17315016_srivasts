package FileServerAuthenticationWithEncryptedKey;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import KeyEncryptionStorage.KeyEncryptionInformation;

public class testKar {
	
	public static void main(String[] args) throws Exception {
		
//		String encryptedKey ="h6Äù•^o";
//		
//		 String fileName = KeyEncryptionInformation.getKeyPwdFile();
//
//	     // This will reference one line at a time
//	     String line = null;
//	     
//	     authenticateTheKey(encryptedKey);
		
		String encryptedMessafe =encrypt("aqwsdfer", "aaaaaaaa");
		System.out.println(encryptedMessafe);
		String swcrytedMessg = decrypt(encryptedMessafe, "aaaaaaaa");
			System.out.println(swcrytedMessg);
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
	
	
	public static void authenticateTheKey(String encryptedKey) throws Exception {
		
		// The name of the file to open.
     String fileName = KeyEncryptionInformation.getKeyPwdFile();

     // This will reference one line at a time
     String line = null;
     

     try {
         // FileReader reads text files in the default encoding.
         FileReader fileReader = 
             new FileReader(fileName);

         // Always wrap FileReader in BufferedReader.
         BufferedReader bufferedReader = 
             new BufferedReader(fileReader);
         
         while((line = bufferedReader.readLine()) != null) {
         	  line.split(";");
         	  
         	  
         	  String decryptedKey = "";
         	 String encrytedKeyTmp = encrypt(line.split(";")[2], line.split(";")[0]);
       	  decryptedKey =   decrypt(encrytedKeyTmp,line.split(";")[0]);
               if(line.split(";").length != 0 && line.split(";")[1].equals(encryptedKey)) {
            	  
             	  System.out.println("sahi kaam kiya");
               }
               
               if(line.split(";")[0].equals(decryptedKey)) {
            	   System.out.println("chal gaya jugaad");
               }else {
            	   System.out.println("na ho paaya");
               }
               if(decryptedKey.equals(encryptedKey)) {
            	   System.out.println("heyyyyyyyyyyyyyy");
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

		
	}
	
	  

}
