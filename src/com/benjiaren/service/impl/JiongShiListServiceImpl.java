package com.benjiaren.service.impl;

import java.util.List;

import com.benjiaren.bean.JiongShi;
import com.benjiaren.bean.JiongShiList;
import com.benjiaren.dao.JiongShiDAO;
import com.benjiaren.service.JiongShiListService;

public class JiongShiListServiceImpl implements JiongShiListService{

	@Override
	public JiongShiList findALLJiongShi(String jsl) {
		// TODO Auto-generated method stub
		JiongShiList jsll = new JiongShiList();
		List<JiongShi> list = new JiongShiDAO().getAllJiongshi();
		jsll.setJsList(list);
		System.out.println("--------");
		System.out.println(list.size() );
		return jsll;
	}

}
