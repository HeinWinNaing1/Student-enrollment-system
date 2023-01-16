package com.hwn.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CategoryDAO {
	
	private final DataSource dataSource;
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	
	public CategoryDAO(DataSource dataSource) {
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
	
	public List<Category> getcategoryList(){
		List<Category> categoryList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from category");
			
			while(rs.next()) {
				categoryList.add(new Category(
						rs.getInt("id"),
						rs.getString("categoryType"),
						rs.getString("description")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return categoryList;
		
	}
	
	public Category getCategory(int id) {
		Category category = null;
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from category "
					+ "where id='"+id+"';");
			
			while(rs.next()) {
				category = new Category(
						rs.getInt("id"),
						rs.getString("categoryType"),
						rs.getString("description"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return category;
	}
	
	public int createCategory(Category category) {
		int rowEffected = 0;
		
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("INSERT INTO `studentenrollment`.`category` (`categoryType`, `description`) VALUES ("
					+ "?,"
					+ " ?);");
			
			
			pStmt.setString(1,category.getCategoryType());
			pStmt.setString(2, category.getDescription());
			
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}
	
	public int updateCategory(final Category category) {
		int rowEffected = 0;
		
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("UPDATE `studentenrollment`.`category` SET "
					+ "`categoryType` = ?,"
					+ "`description` = ? WHERE (`id`= ?);");
			
			pStmt.setString(1,category.getCategoryType());
			pStmt.setString(2, category.getDescription());
			pStmt.setInt(3,category.getId());
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return rowEffected;
	}
	
	public int deleteCategory(int id) {
		int rowEffected = 0;
		
		try {
			connection = dataSource.getConnection();
			pStmt=connection.prepareStatement("delete from category where id = ?; ");
			
			pStmt.setInt(1, id);
			
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
