package com.easy.dao;

import java.util.List;

import com.easy.model.Users;

public interface UsersDao {

	//ȫ��ѯ
	List<Users> selectAll();
	//��¼��֤
	Users login(String username,String password);
}
