package com.jsp.jdbc_backup_statement.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteInsertController {

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
			String DeleteMobileQuery = "delete from mobile WHERE idMobile=123";
			
			int id=statement.executeUpdate(DeleteMobileQuery);
			
			if(id==1) {
				System.out.println("Record---deleted----");
			}else {
				System.out.println("record---is not---delete--check your id--");
			}
			
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
