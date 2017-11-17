package com.easy.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easy.dao.JDBCTools;
import com.easy.dao.ProjectDao;
import com.easy.model.Project;

public class ProjectDaoImpl implements ProjectDao{

	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	@Override
	public int add(Project project) {
		//º”‘ÿ«˝∂Ø
		conn = JDBCTools.getConnection();
		String sql = "insert into project values(seq_pro_id.nextval,?,to_date(?,'yyyy-mm-dd'),to_date(?,'yyyy-mm-dd'),?)";
		int a = 0;
		try {
			//∑¢ÀÕsql÷¥––‘§±‡“Î
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, project.getProname());
			pstm.setString(2, project.getStart_time());
			pstm.setString(3, project.getEnd_time());
			pstm.setInt(4, project.getHeader());
			a = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTools.closeAll(rs, pstm, conn);
		}
		return a;
	}

	@Override
	public int update(Project project) {
		 conn = JDBCTools.getConnection();
		 int a = 0 ;
		 String sql = "update project set pro_name = ?,start_time = to_date(?,'yyyy-mm-dd'),end_time =to_date(?,'yyyy-mm-dd'),header = ? where pro_id = ?";
		 try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, project.getProname());
			pstm.setString(2, project.getStart_time());
			pstm.setString(3, project.getEnd_time());
			pstm.setInt(4, project.getHeader());
			pstm.setInt(5, project.getProid());
			a = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTools.closeAll(rs, pstm, conn);
		}
		 
		return a;
	}

	@Override
	public int delete(int proid) {
		conn = JDBCTools.getConnection();
		String sql = "delete from project where pro_id = ?";
		int a = 0 ;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, proid);
			a = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			JDBCTools.closeAll(rs, pstm, conn);
		}
		return a;
	}

	@Override
	public List<Project> selectAll() {
		conn = JDBCTools.getConnection();
		List<Project> list = new ArrayList<>();
		String sql = "select pro_id,pro_name,to_char(start_time,'yyyy-mm-dd') start_time,to_char(end_time,'yyyy-mm-dd') end_time,header from project";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Project project = new Project();
				project.setProid(rs.getInt(1));
				project.setProname(rs.getString(2));
				project.setStart_time(rs.getString(3));
				project.setEnd_time(rs.getString(4));
				project.setHeader(rs.getInt(5));
				list.add(project);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTools.closeAll(rs, pstm, conn);
		}
		
		return list;
	}

	@Override
	public Project selectById(int proid) {
		conn = JDBCTools.getConnection();
		Project project = new Project();
		String sql = "select pro_id,pro_name,to_char(start_time,'yyyy-mm-dd') start_time,to_char(end_time,'yyyy-mm-dd') end_time,header from project where pro_id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, proid);
			rs = pstm.executeQuery();
			if (rs.next()) {
				project.setProid(rs.getInt(1));
				project.setProname(rs.getString(2));
				project.setStart_time(rs.getString(3));
				project.setEnd_time(rs.getString(4));
				project.setHeader(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTools.closeAll(rs, pstm, conn);
		}
		return project;
	}

	@Override
	public List<Project> selectByName(String proname) {
		conn = JDBCTools.getConnection();
		List<Project> list = new ArrayList<Project>();
		String sql = "select pro_id,pro_name,to_char(start_time,'yyyy-mm-dd') start_time,to_char(end_time,'yyyy-mm-dd') end_time,header from project where pro_name like ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%"+proname+"%");
			rs = pstm.executeQuery();
			if (rs.next()) {
				Project project = new Project();
				project.setProid(rs.getInt(1));
				project.setProname(rs.getString(2));
				project.setStart_time(rs.getString(3));
				project.setEnd_time(rs.getString(4));
				project.setHeader(rs.getInt(5));
				list.add(project);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTools.closeAll(rs, pstm, conn);
		}
		return list;
	}

	
}