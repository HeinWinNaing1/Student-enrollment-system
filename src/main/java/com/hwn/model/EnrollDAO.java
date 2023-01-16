package com.hwn.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EnrollDAO {
	
	private DataSource dataSource;
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	
	public EnrollDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public void close() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<Enroll> getEnrollList(){
		List<Enroll> enrollList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from enroll;");
			
			while(rs.next()) {
				enrollList.add(new Enroll(
						rs.getInt("id"),
						rs.getString("coursename"),
						rs.getString("studentname"),
						rs.getString("email"),
						rs.getString("enrollDate")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return enrollList;
	}
	
	public List<Enroll> getEnrollList(String email){
		List<Enroll> enrollList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from enroll where email= '"+email+"';");
			
			while(rs.next()) {
				enrollList.add(new Enroll(
						rs.getInt("id"),
						rs.getString("coursename"),
						rs.getString("studentname"),
						rs.getString("email"),
						rs.getString("enrollDate")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return enrollList;
	}
	
	public int createEnroll(Enroll enroll) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("INSERT INTO `studentenrollment`.`enroll` ("
					+ "`coursename`,"
					+ " `studentname`,"
					+ " `email`,"
					+ " `enrolldate`) VALUES (?, ?, ?, ?);");
			
			pStmt.setString(1, enroll.getCourseName());
			pStmt.setString(2, enroll.getStudentName());
			pStmt.setString(3, enroll.getEmail());
			pStmt.setString(4, enroll.getEnrollDate());
			
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowEffected;
	}
	
	

}
