package com.techpalle.model;

import java.sql.*;

public class JdbcSteps 
{
	private static final String driverPath="com.mysql.cj.jdbc.Driver";
	private static final String dbUrl="jdbc:mysql://localhost:3306/customer_management";
	private static final String dbUsername="root";
	private static final String dbPassword="aryan";
	
	private static Connection con=null;
	private static PreparedStatement ps=null;
	private static Statement stm=null;
	private static ResultSet rs=null;
	
		
	public static Connection getConnectionDef() 
	{
		try 
		{
			Class.forName(driverPath);
			con =DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return con;
	}
	
	
	public static void finallyBlock()
	{
		try 
		{
			if(rs!=null)
			{
				rs.close();
			}
			if(stm!=null)
			{
				stm.close();
			}
			if(ps!=null)
			{
				ps.close();
			}
			if(con!=null)
			{
				con.close();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
