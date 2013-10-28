package com.benjiaren.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.benjiaren.bean.JiongShi;
import com.benjiaren.bean.JiongShiList;

@Path(value = "/jiongshi")   
@Produces("application/json") 
public interface JiongShiService {
	@GET  
    @Path(value = "/{id}/info")  
    public JiongShi getCategory(@PathParam("id") String id);
	
	@GET  
    @Path(value = "/searchbyName")  
	public JiongShi findUserByName(@QueryParam("name")String name);
	
	
	@GET  
    @Path(value = "/{jiongshiUpload}/add")  
	public void addJiongShi(@PathParam("jiongshiUpload")String jiongshiUpload);
	@GET  
    @Path(value = "/add")  
	public void addJiongShiget(@QueryParam("text")String text,@QueryParam("source")String source,
			@QueryParam("username")String username,@QueryParam("longitude")String longitude,@QueryParam("latitude")String latitude);
	@POST 
    @Path(value = "/{jiongshiUpload}/add")  
	public void addJiongShipost(@QueryParam("text")String text,@QueryParam("source")String source,
			@QueryParam("username")String username,@QueryParam("longitude")String longitude,@QueryParam("latitude")String latitude);
	@GET  
    @Path(value = "/search")  
	public JiongShiList findALLJiongShi(@QueryParam("jsl")String jsl);
}
