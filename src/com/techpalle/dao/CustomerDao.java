package com.techpalle.dao;

import java.sql.*;
import java.util.ArrayList;

import com.techpalle.model.*;

public class CustomerDao 
{
	private static Connection con=null;
	private static PreparedStatement ps=null;
	private static Statement stm=null;
	private static ResultSet rs=null;
	
	private static final String customerListQuery="select * from customer";
	private static final String customerInsertQuery="insert into customer(name,email,mobile) values(?,?,?)";
	private static final String customerEditQuery="select * from customer where id=?";
	private static final String customerUpdateQuery="update customer set name=?,email=?,mobile=? where id=?";
	private static final String customerDeleteQuery="delete from customer where id=?";
	
	
	
	public static void deleteCustomer(int id)
	{
		try 
		{
			con=JdbcSteps.getConnectionDef();
			ps= con.prepareStatement(customerDeleteQuery);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			JdbcSteps.finallyBlock();
		}
	}
	
	
	public static void updateCustomer(Customer c) 
	{
		try 
		{
			con=JdbcSteps.getConnectionDef();
			ps= con.prepareStatement(customerUpdateQuery);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setLong(3, c.getMobile());
			ps.setInt(4, c.getId());
			
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			JdbcSteps.finallyBlock();
		}
	}
	
	
	public static Customer getOneCustomer(int id)
	{
		Customer c=null;
		try 
		{
			con=JdbcSteps.getConnectionDef();
			ps=con.prepareStatement(customerEditQuery);
			ps.setInt(1, id);
			
			rs= ps.executeQuery();
			
			rs.next();
			int i= rs.getInt("id");
			String n= rs.getString("name");
			String e= rs.getString("email");
			Long m = rs.getLong("mobile");
			c=new Customer(i,n, e, m);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			JdbcSteps.finallyBlock();
		}
		return c;
	}
	
	
	public static void addCustomer(Customer customer) 
	{
		try 
		{
			con=JdbcSteps.getConnectionDef();
			ps=con.prepareStatement(customerInsertQuery);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setLong(3, customer.getMobile());
			
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JdbcSteps.finallyBlock();
		}
	}
	
	
	public static ArrayList<Customer> getAllCustomer() 
	{
		ArrayList<Customer> al=new ArrayList<>();
		try 
		{
			con =JdbcSteps.getConnectionDef();
			stm=con.createStatement();
			rs =stm.executeQuery(customerListQuery);
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name =rs.getString("name");
				String email=rs.getString("email");
				Long mobile=rs.getLong("mobile");
				
				Customer c=new Customer(id,name, email, mobile);
				
				al.add(c);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			JdbcSteps.finallyBlock();
		}
		return al;
	}
}
