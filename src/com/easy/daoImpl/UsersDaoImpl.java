package com.easy.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.easy.dao.JDBCTools;
import com.easy.dao.UsersDao;
import com.easy.model.Users;

public class UsersDaoImpl implements UsersDao{

	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	@Override
	public List<Users> selectAll() {
		conn = JDBCTools.getConnection();
		List<Users> list = new ArrayList<>();
		String sql = "select user_id,user_name,password,user_type from users";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Users users = new Users();
				users.setId(rs.getInt(1));
				users.setName(rs.getString(2));
				users.setPassword(rs.getString(3));
				users.setType(rs.getInt(4));
				list.add(users);
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
	public Users login(String username, String password) {
		conn = JDBCTools.getConnection();
		Users users = new Users();
		String sql = "select user_id,user_name,password,user_type from users where user_name = ? and password = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			if (rs.next()) {
				users.setId(rs.getInt(1));
				users.setName(rs.getString(2));
				users.setPassword(rs.getString(3));
				users.setType(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTools.closeAll(rs, pstm, conn);
		}
		return users;
	}
}
