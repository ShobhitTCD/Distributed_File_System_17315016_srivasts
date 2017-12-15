package com.tutorialspoint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.multipart.FormDataParam;

  

@Path("/UserService") 

public class UserService  {  
   
//   @GET 
// //  @Path("/users") 
//   @Produces(MediaType.APPLICATION_XML) 
//   @Path("{parameter}")
//   public String sayHelloXMl(@PathParam("parameter") String parameterValueMillGayi){
//	   String xmlExamaple = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<hello> Hello XML </hello>"  + "       " + parameterValueMillGayi;
//	 //  User u = new User(0, "chal jaa mere bhai ", "scalable project");
//	   Book b = new Book();
//	   b.setId("1234");
//	   return "hello";
//	   
//   }
   
	 private static final String FOLDER_PATH = "C:/Users/Public/uploadedFiles/";
	    
//	   @POST
//	   @Path("/upload")
//	   @Consumes(MediaType.MULTIPART_FORM_DATA)
//	   //@Produces(MediaType.TEXT_PLAIN)
//	   public String uploadFile(@FormDataParam("file") InputStream fis,
//	                   @FormDataParam("file") FormDataContentDisposition fdcd) {
//	 
//	       OutputStream outpuStream = null;
//	       String fileName = fdcd.getFileName();
//	       System.out.println("File Name: " + fdcd.getFileName());
//	       String filePath = FOLDER_PATH + fileName;
//	        
//	       try {
//	           int read = 0;
//	           byte[] bytes = new byte[1024];
//	           outpuStream = new FileOutputStream(new File(filePath));
//	           while ((read = fis.read(bytes)) != -1) {
//	               outpuStream.write(bytes, 0, read);
//	           }
//	           outpuStream.flush();
//	           outpuStream.close();
//	       } catch(IOException iox){
//	           iox.printStackTrace();
//	       } finally {
//	           if(outpuStream != null){
//	               try{outpuStream.close();} catch(Exception ex){}
//	           }
//	       }
//	       return "File Upload Successfully !!";
//	   }
   
//   UserDao userDao = new UserDao();  
//   @GET 
//   @Path("/users") 
//   @Produces(MediaType.APPLICATION_XML) 
//   public List<User> getUsers(){ 
//      return userDao.getAllUsers(); 
//   }  
//   
//   
//  
//   
//   
//   @GET
//   @Produces(MediaType.APPLICATION_OCTET_STREAM)
//   @Path("/users") 
//   public Response getFile() {
//     //File file =  new File("User.java"); 
//	   
//	   
//	   
//     File file = new File("E:\\TRINITY COURSE WORK\\SCALABLE COMPUTING\\rough files\\Server.java");
//     //"C:\\Users\\mshob_000\\Downloads"; // Initialize this to the File path you want to serve.
//     System.out.println("hi");
//     return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
//         .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
//         .build();
//   }
//   
//   
//   
//   @POST
//   @Produces(MediaType.APPLICATION_OCTET_STREAM)
//   @Path("/sandesassss") 
//   public void ReceiveFile() {
//     //File file =  new File("User.java"); 
//	   
//	   System.out.println("hi");
//     File file = new File("E:\\TRINITY COURSE WORK\\SCALABLE COMPUTING\\rough files\\Server.java");
//     //"C:\\Users\\mshob_000\\Downloads"; // Initialize this to the File path you want to serve.
//     System.out.println("hi");
//    
//   }
   
   
//   @POST
//   @Path("/sandesa")
//   @Consumes(MediaType.MULTIPART_FORM_DATA)
//   public Response createTrackInJSON(FormDataMultiPart formParams) {
//
//	   //org.glassfish.jersey.media.multipart.FormDataContentDisposition
//	   System.out.println("hi");
//		String result = "Track saved : " ;
//		System.out.println(result);
//		
//		return Response.status(201).entity(result).build();
//		
//
//	}
//   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
//   public static void download(String downloadURL) throws IOException
//   {
//       URL website = new URL(downloadURL);
//       String fileName = getFileName(downloadURL);
//
//       try (InputStream inputStream = website.openStream())
//       {
//           Files.copy(inputStream, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
//       }
//   }
//
//   public static String getFileName(String downloadURL)
//   {
//       String baseName = FilenameUtils.getBaseName(downloadURL);
//       String extension = FilenameUtils.getExtension(downloadURL);
//       String fileName = baseName + "." + extension;
//
//       int questionMarkIndex = fileName.indexOf("?");
//       if (questionMarkIndex != -1)
//       {
//           fileName = fileName.substring(0, questionMarkIndex);
//       }
//
//       fileName = fileName.replaceAll("-", "");
//       return URLDecoder.decode(fileName, "UTF-8");
//   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
//   @GET 
//   @Path("/users") 
//   @Produces(MediaType.TEXT_HTML) 
//   public String sayHelloHTML(){
//	   String xmlExamaple = "<hello> Hello XML </hello>" ;
//			   
//	   return xmlExamaple;
//	   
//   }
//   public List<User> getUsers(){ 
//      return userDao.getAllUsers(); 
//   }  
}
