package com.benjiaren.server;


import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import com.benjiaren.service.UpLoadFileService;
import com.benjiaren.service.impl.CommentServiceImpl;
import com.benjiaren.service.impl.JiongShiServiceImpl;
import com.benjiaren.service.impl.UserServiceImpl;

public class Server {
	public static void main(String[] args) {
      
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();  
        factoryBean.getInInterceptors().add(new LoggingInInterceptor());  
        factoryBean.getOutInterceptors().add(new LoggingOutInterceptor()); 
        List<Class<?>> cc = new ArrayList<Class<?>>();
        cc.add(UserServiceImpl.class);
        cc.add(JiongShiServiceImpl.class);
        cc.add(UpLoadFileService.class);
        cc.add(CommentServiceImpl.class);
        factoryBean.setResourceClasses(cc);
        factoryBean.setAddress("http://localhost:9000/js/jaxrs");  
        factoryBean.create();
	}
}
