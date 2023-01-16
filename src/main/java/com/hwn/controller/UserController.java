package com.hwn.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.sql.DataSource;

import com.hwn.model.User;
import com.hwn.model.UserDAO;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/enroll")
	DataSource dataSource;
	
	private UserDAO userDao;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		userDao = new UserDAO(dataSource);
		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mode = request.getParameter("mode");
		
		if(mode == null) {
			mode="SIGNUP";
		}
		
		switch (mode) {
		case "SIGNUP":
			signup(request,response);
			break;
		case "SHOW":
			getUserList(request,response);
			break;

		default:
			signup(request,response);
			break;
		}
	}

	private void getUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> userList = null;
		userList = this.userDao.getUserList();
		request.setAttribute("userList", userList);
		RequestDispatcher rd = request.getRequestDispatcher("registerStudents.jsp");
		rd.forward(request, response);
		
	}

	private void signup(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String phNo = request.getParameter("phNo");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate now = LocalDate.now();
		String createDate = dtf.format(now);
		String role = "user";
		
		User user = new User(username, email, password, createDate, role,phNo);
		
		int rowEffected = this.userDao.createUser(user);
		
		if(rowEffected >0) {
			request.setAttribute("message","Sign in is successful!");
			RequestDispatcher rd = request.getRequestDispatcher("userRegister.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
