package com.benjiaren.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.benjiaren.bean.JiongShi;

@Path(value = "/jiongshi")   
@Produces("application/json") 
public interface JiongShiService {
	@GET  
    @Path(value = "/{id}/info")  
    public JiongShi getCategory(@PathParam("id") String id);
	
	@GET  
    @Path(value = "/search")  
	JiongShi findUserByName(@QueryParam("name")String name);

}
