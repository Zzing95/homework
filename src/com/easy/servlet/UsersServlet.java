package com.easy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.easy.dao.UsersDao;
import com.easy.daoImpl.UsersDaoImpl;
import com.easy.mapper.UsersMapper;
import com.easy.model.Users;
import com.easy.mybatis.MybatisTools;


@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("addUsers");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsersDao usersDao = new UsersDaoImpl();
		Users users = usersDao.login(username, password);
		HttpSession session = request.getSession();
		session.setAttribute("users", users);
		if (users == null) {
			response.sendRedirect("login.jsp");
		}else if ("addUsers".equals(flag)) {
			addUsers(request,response);
		} else {
			request.getRequestDispatcher("ProjectsServlet?flag=selectAll").forward(request, response);
		}

	}


	private void addUsers(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//接收画面传来的值
		String id = request.getParameter("user_id");
		String name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		Users user = new Users();
		user.setId(Integer.parseInt(id));
		user.setName(name);
		user.setPassword(password);
		user.setType(Integer.parseInt(type));
		//调用mybatis方法打开会话工厂
		SqlSession sqlSession = MybatisTools.getSqlSession();
		UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
		//关闭会话工厂
		sqlSession.commit();
		sqlSession.close();
		int record = usersMapper.addUser(user);
		if (record > 0) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
	}

}
