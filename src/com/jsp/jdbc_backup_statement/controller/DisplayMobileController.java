package com.jsp.jdbc_backup_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayMobileController {


public static void main(String[] args) {
		
		Connection connection=null;
		
		try {
			//step-1 load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 create connection
			String url = "jdbc:mysql://localhost:3306/jdbc_backup";
			String user = "root";
			String pass = "root";
			
			connection=DriverManager.getConnection(url, user, pass);
					
			//step-3 create statement
			Statement statement=connection.createStatement();
			
			//step-4 execute Query
			String displayMobileQuery = " select * from mobile ";
//			System.out.println(displayMobileQuery);
			
			ResultSet resultSet=statement.executeQuery(displayMobileQuery);
			
				
			while(resultSet.next()) {
				int id = resultSet.getInt("idMobile");
				String name = resultSet.getString("mobileName");
				int price = resultSet.getInt("mobilePrice");
				
				System.out.println("student id " + id);
				System.out.println("studentName "+ name);
				System.out.println("studentName "+price);
				System.out.println("==============================================\n");
				
			}
					
					
//			System.out.println("data-----displayed------");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
