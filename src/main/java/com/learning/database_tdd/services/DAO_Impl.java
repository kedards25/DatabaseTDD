package com.learning.database_tdd.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learning.database_tdd.models.UserModel;

public class DAO_Impl implements IDAO_Service {

	String user = "sa";
	String pass = "";
	String url = "jdbc:h2:tcp://localhost/~/test";
	Connection con = null;
	UserModel model;
	Statement statement;
	PreparedStatement pStatement;

	public boolean getConnected() {
		try {
			con = DriverManager.getConnection(url, user, pass);
			if (con != null) {
				return true;
			}
			return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("getConnected Error: " + e.getMessage());
		}
		return false;
	}

	public List<UserModel> getData() {
		List<UserModel> modelList = new ArrayList();
		if (getConnected()) {
			String q = "select * from usermodel";
			try {
				statement = con.createStatement();
				ResultSet resultSet = statement.executeQuery(q);
				while (resultSet.next()) {
					model = new UserModel();
					model.setId(resultSet.getInt("id"));
					model.setName(resultSet.getString("Name"));
					model.setPwd(resultSet.getString("pwd"));
					modelList.add(model);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("getData Error: " + e.getMessage());
			}

		}
		return modelList;
	}

	public int insertDetails(UserModel model) throws SQLException {
		// if you initialise the model obj
		// it will create a new object
		// model=new UserModel();
//		System.out.println(model.getName());

		int rowsInserted = 0;
		if (getConnected()) {
			String q = "insert into userModel(name,pwd) values(?,?)";
			pStatement = con.prepareStatement(q);
			pStatement.setString(1, model.getName());
			pStatement.setString(2, model.getPwd());
			rowsInserted=pStatement.executeUpdate();
		}
		return rowsInserted;
	}

	public int updateData(int i, UserModel model) {
		int rowsUpdated = 0;
		if (getConnected()) {
			String q = "update userModel "
					+ "set name=?,"
					+ "pwd=? "
					+ "where id=?";
							
			try {
				pStatement = con.prepareStatement(q);
				pStatement.setString(1, model.getName());
				pStatement.setString(2, model.getPwd());
				pStatement.setInt(3, i);
				rowsUpdated=pStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("updateData Error: " + e.getMessage());
			}
			
		}
		return rowsUpdated;
	}

	public UserModel getDataById(int i) {
		UserModel model=null;
		if (getConnected()) {
			String q = "select * from usermodel where id=?";
			try {
				pStatement = con.prepareStatement(q);
				pStatement.setInt(1, i);
				ResultSet resultSet = pStatement.executeQuery();
				if (resultSet.next()) {
					model = new UserModel();
					model.setId(resultSet.getInt("id"));
					model.setName(resultSet.getString("Name"));
					model.setPwd(resultSet.getString("pwd"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("getData Error: " + e.getMessage());
			}

		}
		if (model!=null) {
			return model;
		}
		return null;
		
	}

	
}
