package com.tutorialspoint;




import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/server3") 
public class Server3 {
	
	
	 	 
	 
   @GET
   @Produces(MediaType.APPLICATION_OCTET_STREAM)
   @Path("{fileName}")
   public Response getFile(@PathParam("fileName") String fileName) throws Exception{
	   
     File file = new File("E:\\TRINITY COURSE WORK\\SCALABLE COMPUTING\\Assignment 2\\UserManagement\\server3_files\\" + fileName);
     System.out.println("hi");
     return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
         .header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
         .build();
   }

}