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
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hwn.model.Category;
import com.hwn.model.CategoryDAO;
import com.hwn.model.User;


/**
 * Servlet implementation class CategoryController
 */
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/enroll")
    private DataSource dataSource;
	
	CategoryDAO categoryDAO;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		 categoryDAO = new CategoryDAO(dataSource);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
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
			showCategoryList(request,response);
			break;
		case "CREATE":
			createCategoryList(request,response);
			break;
		case "ADD":
			loadToAdd(request,response);
			break;
		case "LOAD":
			loadCategory(request,response);
			break;
		case "UPDATE":
			updateCategory(request,response);
			break;
		case "DELETE":
			 deleteCategory(request,response);
			 break;
		default:
			showCategoryList(request,response);
			break;
		}
		}
	}

	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		int id=Integer.parseInt(request.getParameter("id"));
		int rowEffected = this.categoryDAO.deleteCategory(id);
		if(rowEffected>0) {
			response.sendRedirect("category");
		}
		
	}

	private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		int id =Integer.parseInt(request.getParameter("id"));
		String categoryType = request.getParameter("categoryType");
		String description = request.getParameter("description");
		
		
		Category category = new Category(id,categoryType, description);
		System.out.println("me "+category.getId());
		int rowEffected = this.categoryDAO.updateCategory(category);
		
		if(rowEffected > 0) {
			showCategoryList(request, response);
		}
		
	}

	private void loadCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		int id = Integer.parseInt(request.getParameter("id"));
		Category category = this.categoryDAO.getCategory(id);
		request.setAttribute("category", category);
		RequestDispatcher rd = request.getRequestDispatcher("updateCategory.jsp");
		rd.forward(request, response);
		
	}

	private void loadToAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		List<Category> categoryList = new ArrayList<>();
		categoryList = categoryDAO.getcategoryList();
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher rd = request.getRequestDispatcher("addCourse.jsp");
		rd.forward(request, response);
		
	}

	private void createCategoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		
		String categoryType = request.getParameter("categoryType");
		String description = request.getParameter("description");
		
		
		Category category = new Category(categoryType, description);
		int rowEffected = this.categoryDAO.createCategory(category);
		
		if(rowEffected > 0) {
			request.setAttribute("message", "Adding new category is successful!");
			RequestDispatcher rd = request.getRequestDispatcher("addCategory.jsp");
			rd.forward(request, response);
		}
		
	}

	private void showCategoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		List<Category> categoryList = new ArrayList<>();
		categoryList = categoryDAO.getcategoryList();
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher rd = request.getRequestDispatcher("category.jsp");
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
