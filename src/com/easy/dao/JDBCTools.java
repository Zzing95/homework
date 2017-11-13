package com.easy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTools {

	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USERNAME = "JAVA27";
	public static final String PASSWORD = "123456";
	
	//���ӵķ���
	public static Connection getConnection(){
		
		Connection conn = null;
		try {
			//1.��������
			Class.forName(DRIVER);
			
			//2.�������Ӳ��ҷ������Ӷ���
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//�ر���Դ
	public static void closeAll(ResultSet rs,PreparedStatement pstm,Connection conn){
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
}
