package com.easy.dao;

import java.util.List;

import com.easy.model.Users;

public interface UsersDao {

	//全查询
	List<Users> selectAll();
	//登录验证
	Users login(String username,String password);
}
