package com.easy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easy.dao.UsersDao;
import com.easy.daoImpl.UsersDaoImpl;
import com.easy.model.Users;


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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsersDao usersDao = new UsersDaoImpl();
		Users users = usersDao.login(username, password);
		HttpSession session = request.getSession();
		session.setAttribute("users", users);
		if (users == null) {
			response.sendRedirect("login.jsp");
		}else {
			request.getRequestDispatcher("ProjectsServlet?flag=selectAll").forward(request, response);
		}

	}

}
