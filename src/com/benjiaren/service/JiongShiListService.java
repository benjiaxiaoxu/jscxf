package com.benjiaren.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.benjiaren.bean.JiongShiList;

@Path(value = "/jsList")   
@Produces("application/json")
public interface JiongShiListService {
	@GET  
    @Path(value = "/search")  
	public JiongShiList findALLJiongShi(@QueryParam("jsl")String jsl);
	
}
