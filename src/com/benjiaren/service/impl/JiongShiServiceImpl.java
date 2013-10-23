package com.benjiaren.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.benjiaren.bean.Geo;
import com.benjiaren.bean.JiongShi;
import com.benjiaren.service.JiongShiService;

public class JiongShiServiceImpl implements JiongShiService{

	@Override
	public JiongShi getCategory(String id) {
		// TODO Auto-generated method stub
		JiongShi js = new JiongShi();
		js.setAttitudes_count(1);
		js.setComments_count(2);
		js.setCreated_at(new Date());
		js.setId(11111);
		js.setText("dawsadwdwasdwa");
		js.setSource("daswd");
		Geo geo = new Geo();
		geo.setLatitude("21.12312312.121");
		geo.setLongitude("312");
		js.setGeo(geo);
		List<String> lis = new ArrayList<String>();
		lis.add("http://1");
		lis.add("http://2");
		js.setPic_urls(lis);
		return js;
	}

	@Override
	public JiongShi findUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
