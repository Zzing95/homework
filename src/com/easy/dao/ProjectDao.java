package com.easy.dao;

import java.util.List;

import com.easy.model.Project;

public interface ProjectDao {

	//添加项目
	int add(Project project);
	//更新项目
	int update(Project project);
	//删除
	int delete(int proid);
	//全查询
	List<Project> selectAll();
	//按照id查询
	Project selectById(int proid);
	//模糊查询
	List<Project> selectByName(String proname);
}
