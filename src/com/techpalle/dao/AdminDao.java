package com.techpalle.dao;

import java.sql.*;

import com.techpalle.model.*;

public class AdminDao
{
	private static Connection con=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	private static final String validateQuery= "select * from store_admin where username=? and password=?";
	
	
	public static boolean validateAdmin(Admin a)
	{
		boolean b=false;
		try 
		{
			con=JdbcSteps.getConnectionDef();
			ps=con.prepareStatement(validateQuery);
			
			ps.setString(1, a.getUsername());
			ps.setString(2, a.getPassword());
			
			rs=ps.executeQuery();
			
			b=rs.next();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			JdbcSteps.finallyBlock();
		}
		return b;
	}
}
