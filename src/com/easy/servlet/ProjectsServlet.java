package com.easy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easy.dao.ProjectDao;
import com.easy.dao.UsersDao;
import com.easy.daoImpl.ProjectDaoImpl;
import com.easy.daoImpl.UsersDaoImpl;
import com.easy.model.Project;
import com.easy.model.Users;


@WebServlet("/ProjectsServlet")
public class ProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProjectsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if (flag.equals("delete")) {
			delete(request,response);
		}else if (flag.equals("selectById")) {
			selectById(request,response);
		}
	}

	
	private void selectById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String proid = request.getParameter("proid");
		ProjectDao projectDao = new ProjectDaoImpl();
		Project project = projectDao.selectById(Integer.parseInt(proid));
		request.setAttribute("project", project);
		request.getRequestDispatcher("projectaddupdate.jsp").forward(request, response);
		
		
	}


	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proid = request.getParameter("proid");
		ProjectDao projectDao = new ProjectDaoImpl();
		projectDao.delete(Integer.parseInt(proid));
		selectAll(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		System.out.println(flag);
		if (flag.equals("selectAll")) {
			selectAll(request,response);
		}else if (flag.equals("addProject")) {
			addProject(request,response);
		}else if (flag.equals("updateProject")) {
			updateProject(request,response);
		}else if (flag.equals("selectByName")) {
			selectByName(request,response);
		}
	}


	private void selectByName(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String proname = request.getParameter("proname");
		ProjectDao projectDao = new ProjectDaoImpl();
		List<Project> projects = projectDao.selectByName(proname);
		request.setAttribute("list", projects);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}


	private void updateProject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String proid = request.getParameter("proid");
		System.out.println(proid);
		String proname = request.getParameter("proname");
		System.out.println(proname);
		String start_time = request.getParameter("start_time");
		System.out.println(start_time);
		String end_time = request.getParameter("end_time");
		System.out.println(end_time);
		String header = request.getParameter("header");
		System.out.println(header);
		ProjectDao projectDao = new ProjectDaoImpl();
		Project project = new Project();
		project.setProid(Integer.parseInt(proid));
		project.setProname(proname);
		project.setStart_time(start_time);
		project.setEnd_time(end_time);
		project.setHeader(Integer.parseInt(header));
		projectDao.update(project);
		selectAll(request, response);
	}


	private void addProject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String proname = request.getParameter("proname");
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		String header = request.getParameter("header");
		ProjectDao projectDao = new ProjectDaoImpl();
		Project project = new Project();
		project.setProid(1);
		project.setProname(proname);
		project.setStart_time(start_time);
		project.setEnd_time(end_time);
		project.setHeader(Integer.parseInt(header));
		projectDao.add(project);
		selectAll(request, response);
	}


	private void selectAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ProjectDao projectDao = new ProjectDaoImpl();
		List<Project> projects = projectDao.selectAll();
		request.setAttribute("list", projects);
		HttpSession session = request.getSession();
		UsersDao usersDao = new UsersDaoImpl();
		List<Users> users = usersDao.selectAll();
		session.setAttribute("list2", users);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
