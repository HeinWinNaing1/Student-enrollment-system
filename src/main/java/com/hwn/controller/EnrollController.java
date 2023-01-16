package com.hwn.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hwn.model.Course;
import com.hwn.model.CourseDAO;
import com.hwn.model.Enroll;
import com.hwn.model.EnrollDAO;
import com.hwn.model.User;

/**
 * Servlet implementation class EnrollController
 */
public class EnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/enroll")
    private DataSource dataSource;
	
	private EnrollDAO enrollDAO;
	private CourseDAO courseDAO;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		enrollDAO = new EnrollDAO(dataSource);
		courseDAO = new CourseDAO(dataSource);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		
		if (user != null) {
		String mode = request.getParameter("mode");
		if(mode == null) {
			mode = "LIST";
		}
		switch (mode) {
		case "LIST":
			showEnrollList(request,response);
			break;
		case "CREATE":
			createEnrollList(request,response);
			break;

		default:
			showEnrollList(request, response);
			break;
		}
		}
	}

	private void createEnrollList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		String username = user.getUsername();
		String email = user.getEmail();
		int id = Integer.parseInt(request.getParameter("id"));
		Course course = this.courseDAO.getCourse(id);
		String courseName = course.getCourseName();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate now = LocalDate.now();
		String enrollDate = dtf.format(now);
		Enroll enroll = new Enroll(courseName,username, email, enrollDate);
		int rowEffected = this.enrollDAO.createEnroll(enroll);
		if(rowEffected > 0) {
			response.sendRedirect("course");
		}
	}

	private void showEnrollList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		String email = user.getEmail();
		List<Enroll> enrollByEmail = this.enrollDAO.getEnrollList(email);
		List<Enroll> enrollList = this.enrollDAO.getEnrollList();
		request.setAttribute("enrollList", enrollList);
		request.setAttribute("enrollByEmail", enrollByEmail);
		RequestDispatcher rd = request.getRequestDispatcher("enroll.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
