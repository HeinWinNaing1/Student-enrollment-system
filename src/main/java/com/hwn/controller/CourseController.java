package com.hwn.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hwn.model.Category;
import com.hwn.model.CategoryDAO;
import com.hwn.model.Course;
import com.hwn.model.CourseDAO;
import com.hwn.model.User;

/**
 * Servlet implementation class CourseController
 */
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/enroll")
       private DataSource dataSource;
	
	private CourseDAO courseDAO;
	private CategoryDAO categoryDAO;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		courseDAO = new CourseDAO(dataSource);
		categoryDAO = new CategoryDAO(dataSource);
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		
		if (user != null) {
		String mode = request.getParameter("mode");
		if(mode == null) {
			mode = "LIST";
		}
		switch (mode) {
		case "LIST":
			showCourseList(request,response);
			break;
		case "CREATE":
			createCourse(request,response);
			break;
		case "LOAD":
			loadCourse(request,response);
			break;
		case "UPDATE":
			updateCourse(request,response);
			break;
		case "LOGOUT":
			session.invalidate();
			response.sendRedirect("login");
			break;
		case "DELETE":
			deleteCourse(request,response);
			break;

		default:
			showCourseList(request,response);
			break;
		}
		}
		
	}

	private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		int id = Integer.parseInt(request.getParameter("id"));
		int rowEffected = this.courseDAO.deleteCourse(id);
		if(rowEffected>0) {
			response.sendRedirect("course");
		}
		
		
	}

	private void loadCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		int id = Integer.parseInt(request.getParameter("id"));
		Course course = this.courseDAO.getCourse(id);
		request.setAttribute("course", course);
		List<Category> categoryList = new ArrayList<>();
		categoryList = this.categoryDAO.getcategoryList();
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher rd = request.getRequestDispatcher("updateCourse.jsp");
		rd.forward(request, response);
		
	}

	private void updateCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		int id = Integer.parseInt(request.getParameter("id"));
		String courseName = request.getParameter("courseName");
		String instructorName = request.getParameter("instructorName");
		double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		String startDate = request.getParameter("startDate");
		String period = request.getParameter("period");
		
		
		Course course = new Course(id,courseName, instructorName, price, category, description, startDate, period);
		
		int rowEffected = this.courseDAO.updateCourse(course);
		
		if(rowEffected >0) {
			showCourseList(request, response);
		}
		
	}

	private void createCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		String courseName = request.getParameter("courseName");
		String instructorName = request.getParameter("instructorName");
		double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		String startDate = request.getParameter("startDate");
		String period = request.getParameter("period");
		List<Category> categoryList = new ArrayList<>();
		categoryList = categoryDAO.getcategoryList();
		request.setAttribute("categoryList", categoryList);
		
		Course course = new Course(courseName, instructorName, price, category, description, startDate, period);
		
		int rowEffected = this.courseDAO.createCourse(course);
		
		if(rowEffected >0) {
			request.setAttribute("message", "Adding new course is successful!");
			RequestDispatcher rd = request.getRequestDispatcher("addCourse.jsp");
			rd.forward(request, response);
		}
		
	}

	private void showCourseList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		List<Course> courseList = courseDAO.getCourseList();
		request.setAttribute("courseList", courseList);
		RequestDispatcher rs = request.getRequestDispatcher("courseList.jsp");
		rs.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
