package com.hwn.model;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hwn.crypto.PasswordEncoder;
import com.hwn.crypto.PasswordValidator;

public class UserDAO {
	
	private final DataSource dataSource;
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	
	public UserDAO(DataSource dataSource) {
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
	
	public List<User> getUserList(){
		List<User> userList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from user where role='user';");
			
			while(rs.next()) {
				userList.add(new User(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("email"),
						rs.getString("password"),
						rs.getString("createDate"),
						rs.getString("role"),
						rs.getString("phNo")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return userList;
	}
	
	public int createUser(User user) {
		int rowEffected = 0;
		
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("INSERT INTO `studentenrollment`.`user` (`username`, `email`, `password`, `createdate`, `role`, `phNo`) VALUES ("
					+ "?,"
					+ " ?,"
					+ " ?,"
					+ " ?,"
					+ " ?,"
					+ " ?);");
			pStmt.setString(1,user.getUsername());
			pStmt.setString(2,user.getEmail());
			String rawPassword = user.getPassword();
			String securedPassword = null;
			
			try {
				securedPassword = PasswordEncoder.encode(rawPassword);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pStmt.setString(3,securedPassword);
			pStmt.setString(4, user.getCreateDate());
			pStmt.setString(5, user.getRole());
			pStmt.setString(6, user.getPhNo());
			
			
			
			
			 rowEffected = pStmt.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally {
				close();
			}
		
		return rowEffected;
		
	}
	
	public User getUserByEmail(String email) {
		User user = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs=stmt.executeQuery("select * from user where email='"+email+"';");
			while(rs.next()) {
				user = new User(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("email"),
						rs.getString("password"),
						rs.getString("createdate"),
						rs.getString("role"),				
						rs.getString("phNo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return user;
	}
	
	public boolean isValid(String email,String originalPassword) {
		boolean valid = false;
		User user = getUserByEmail(email);
		
		if(user!=null ) {
			String securedPassword = user.getPassword();
			String role = user.getRole();
			try {
				System.out.println(user.getRole());
				System.out.println("user check "+role.equals("user"));
				if(role.equals("user")) {
				if (PasswordValidator.validatePassword(originalPassword, securedPassword)) {
					valid = true;	
				}
				}else {
					if(securedPassword.equals(originalPassword)) {
						valid=true;
					}
				}
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return valid;
	}
	
	
	

}
