package com.benjiaren.service.impl;

import com.benjiaren.bean.User;
import com.benjiaren.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public User getCategory(String id) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName("111");
		user.setEmail("2222");
		return user;
	}

	@Override
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
