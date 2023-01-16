package com.hwn.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CourseDAO {
	
private final DataSource dataSource;
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	
	public CourseDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	
	public void close() {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<Course> getCourseList(){
		List<Course> courseList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs =stmt.executeQuery("select * from course");
			
			while(rs.next()) {
				courseList.add(new Course(
						rs.getInt("id"),
						rs.getString("coursename"),
						rs.getString("instructorname"),
						rs.getDouble("price"),
						rs.getString("category"),
						rs.getString("description"),
						rs.getString("startdate"),
						rs.getString("period")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return courseList;
		
	}
	
	public Course getCourse(int id) {
		Course course = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs =stmt.executeQuery("select * from course "
					+ "where id='"+id+"';");
			
			while(rs.next()) {
				course = new Course(
						rs.getInt("id"),
						rs.getString("coursename"),
						rs.getString("instructorname"),
						rs.getDouble("price"),
						rs.getString("category"),
						rs.getString("description"),
						rs.getString("startdate"),
						rs.getString("period"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return course;
		
	}
	
	public int createCourse(final Course course) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			
			pStmt = connection.prepareStatement("INSERT INTO course (`coursename`, `instructorname`, `price`, `category`, `description`, `startdate`, `period`) VALUES ("
					+ " ?,"
					+ " ?,"
					+ " ?,"
					+ " ?,"
					+ " ?,"
					+ " ?,"
					+ " ?);");
			pStmt.setString(1,course.getCourseName());
			pStmt.setString(2,course.getInstructorName());
			pStmt.setDouble(3,course.getPrice());
			pStmt.setString(4,course.getCategory());
			pStmt.setString(5,course.getDescription());
			pStmt.setString(6,course.getStartDate());
			pStmt.setString(7,course.getPeriod());
			
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return rowEffected;
	}
	
	public int updateCourse(final Course course) {
		int rowEffected =0;
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("UPDATE `studentenrollment`.`course` SET "
					+ "`coursename` = ?,"
					+ " `instructorname` = ?,"
					+ " `price` = ?,"
					+ " `category` = ?,"
					+ " `description` = ?,"
					+ " `startdate` = ?,"
					+ " `period` = ? WHERE (`id` = ?);");
			
			pStmt.setString(1, course.getCourseName());
			pStmt.setString(2, course.getInstructorName());
			pStmt.setDouble(3, course.getPrice());
			pStmt.setString(4, course.getCategory());
			pStmt.setString(5, course.getDescription());
			pStmt.setString(6, course.getStartDate());
			pStmt.setString(7, course.getPeriod());
			pStmt.setInt(8,course.getId());
			
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return rowEffected;
		
	}
	
	public int deleteCourse(int id) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("delete from course where id = ?;");
			
			pStmt.setInt(1,id);
			
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return rowEffected;
	}
	
	

}
