package com.benjiaren.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.benjiaren.bean.Geo;
import com.benjiaren.bean.JiongShi;
import com.benjiaren.bean.JiongShiList;
import com.benjiaren.bean.User;
import com.benjiaren.dao.CommentsDAO;
import com.benjiaren.dao.JiongShiDAO;
import com.benjiaren.service.JiongShiService;

public class JiongShiServiceImpl implements JiongShiService{

	@Override
	public JiongShi getCategory(String id) {
		// TODO Auto-generated method stub
		List<JiongShi> list = new JiongShiDAO().getAllJiongshi();
		
		return list.get(0);
	}

	@Override
	public JiongShi findUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addJiongShi(String jiongshi) {
		System.out.println(jiongshi);
		// TODO Auto-generated method stub
//		JiongShi js = new JiongShi();
//		js.setCreated_at(new Date());
//		js.setText("111Œ“i≤©");
//		User user = new User();
//		user.setName("xiaoxu");
//		js.setUser(user);
//		Geo geo = new Geo();
//		geo.setLongitude("10.2222");
//		geo.setLatitude("21.4232");
//		js.setGeo(geo);
//		List<String> list = new ArrayList<String>();
//		list.add("http://");
//		list.add("https:///aaa");
//		js.setPic_urls(list);
//		new JiongShiDAO().insertJiongShi(js);
	}

	@Override
	public JiongShiList findALLJiongShi(String jsl) {
		// TODO Auto-generated method stub
		JiongShiList jsll = new JiongShiList();
		List<JiongShi> list = new JiongShiDAO().getAllJiongshi();
		List<JiongShi> listj = new ArrayList<JiongShi>();
		System.out.println(list.size());
		for(JiongShi js : list){
			js.setComments(new CommentsDAO().getCommentsByUsernameANDJiongshiId(js.getUser().getName(), js.getId()));
			System.out.println(js.getComments().size());
			System.out.println(js.getUser().getName());
			System.out.println(js.getId());
			listj.add(js);
		}
		jsll.setJiongshi(listj);
		System.out.println(listj.size());
		return jsll;
	}

	@Override
	public void addJiongShiget(String text, String source, String username,
			String longitude, String latitude) {
		// TODO Auto-generated method stub
		JiongShi js = new JiongShi();
		js.setCreated_at(new Date());
		js.setText(text);
		User user = new User();
		user.setName(username);
		js.setUser(user);
		Geo geo = new Geo();
		geo.setLongitude(longitude);
		geo.setLatitude(latitude);
		js.setGeo(geo);
		
		new JiongShiDAO().insertJiongShi(js);
	}

	@Override
	public void addJiongShipost(String text, String source, String username,
			String longitude, String latitude) {
		// TODO Auto-generated method stub
		JiongShi js = new JiongShi();
		js.setCreated_at(new Date());
		js.setText(text);
		User user = new User();
		user.setName(username);
		js.setUser(user);
		Geo geo = new Geo();
		geo.setLongitude(longitude);
		geo.setLatitude(latitude);
		js.setGeo(geo);
		
		new JiongShiDAO().insertJiongShi(js);
	}



}
