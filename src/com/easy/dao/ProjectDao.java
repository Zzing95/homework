package com.easy.dao;

import java.util.List;

import com.easy.model.Project;

public interface ProjectDao {

	//�����Ŀ
	int add(Project project);
	//������Ŀ
	int update(Project project);
	//ɾ��
	int delete(int proid);
	//ȫ��ѯ
	List<Project> selectAll();
	//����id��ѯ
	Project selectById(int proid);
	//ģ����ѯ
	List<Project> selectByName(String proname);
}
