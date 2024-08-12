package com.crudMvc.dao;
import java.sql.Connection;
import java.sql.DriverManager;
public class UtilConnectionClass 
{
	public static Connection getConnection()
	{
		Connection connection= null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/crudusingmvc", "root", "root");
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println(connection);	
		return connection;
			
	}

}
