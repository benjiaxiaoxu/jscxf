package com.benjiaren.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.io.FileUtils;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.benjiaren.util.FileUpLoadForm;


/**
 * @author xuzhiguang
 *
 */
@Path(value = "/file")
public class UpLoadFileService {
	
	
	@PUT  
	@Path(value = "/{folder}/{fileName}")  
	public Response uploadFile(@PathParam("folder") String folder,@PathParam("fileName") String fileName,     @Context HttpServletRequest request)  
	{  
	    File f = new File("x:\\"+fileName);  
	    InputStream is = null;  
	    try {  
	        is = request.getInputStream();  
	        FileUtils.copyInputStreamToFile(is, f);  
	    } catch (IOException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    }  
	    return Response.ok().build();  
	}  
	
	
	
	
	
	
	
	@POST  
    @Path("/upload")  
    @Consumes("multipart/form-data")  
    public Response uploadFile(@MultipartForm FileUpLoadForm form) {  
   
        String fileName = "d:\\anything";  
   
        try {  
            writeFile(form.getData(), fileName);  
        } catch (IOException e) {  
   
            e.printStackTrace();  
        }  
   
        System.out.println("Done");  
   
        return Response.status(200)  
            .entity("uploadFile is called, Uploaded file name : " + fileName).build();  
	}
	//save to somewhere  
    private void writeFile(byte[] content, String filename) throws IOException {  
   
        File file = new File(filename);  
   
        if (!file.exists()) {  
            file.createNewFile();  
        }  
   
        FileOutputStream fop = new FileOutputStream(file);  
   
        fop.write(content);  
        fop.flush();  
        fop.close();  
   
    }  
		      
}
