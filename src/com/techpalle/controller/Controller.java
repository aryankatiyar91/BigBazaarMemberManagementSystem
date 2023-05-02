package com.techpalle.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.techpalle.dao.AdminDao;
import com.techpalle.dao.CustomerDao;
import com.techpalle.model.Admin;
import com.techpalle.model.Customer;

@WebServlet("/")
public class Controller extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path=request.getServletPath();
		
		switch (path) 
		{
		case "/home":
			getCustomerListPage(request, response);
			break;
		case "/list":
			validateAdmin(request,response);
			break;
		case "/delete":
			deleteCustomer(request,response);
			break;
		case "/update":
			updateCustomer(request,response);
			break;
		case "/editForm":
			getEditForm(request,response);
			break;
		case "/insertForm":
			getInsertForm(request,response);
			break;
		case "/add": 
			addCustomer(request,response);
			break;
		default:
			getStartUpPage(request,response);
			break;
		}
	}

	private void validateAdmin(HttpServletRequest request,HttpServletResponse response)
	{
		// Read the username and password
		String user=request.getParameter("tbUser");
		String pass=request.getParameter("tbPass");
		
		// Store the admin given data into model/Object
		Admin a=new Admin(user,pass);
		
		// call the dao method to validate admin 
		boolean res=AdminDao.validateAdmin(a);
		
		// Condition to redirect admin to list page
		if(res)
		{
			getCustomerListPage(request, response);
		}
		else
		{
			try 
			{
				response.sendRedirect(request.getContextPath()+"/default");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		// Read the id from url
		int id = Integer.parseInt(request.getParameter("id"));
		
		// Call the dao method to delete the row in database
		CustomerDao.deleteCustomer(id);
		
		//Redirect user to customer-list page
		getCustomerListPage(request, response);
	}

	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		// Reading data from customer-form Page
		int id = Integer.parseInt(request.getParameter("tbId"));
		String name=request.getParameter("tbName");
		String email=request.getParameter("tbEmail");
		Long mobile=Long.parseLong(request.getParameter("tbMobile"));
		
		// Store the admin given data into model/Object
		Customer c=new Customer(id,name, email, mobile);
		
		// Insert customer data to DB
		CustomerDao.updateCustomer(c);
		
		// First approach Redirect Admin to ListPage (customer-list page)
//		getCustomerListPage(request, response);
		
		// Second approach to redirect user to customer-list page
		try 
		{
			response.sendRedirect(request.getContextPath()+"/home");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	private void getEditForm(HttpServletRequest request, HttpServletResponse response) 
	{
		// Fetch the id from url:
		int id = Integer.parseInt(request.getParameter("id"));
		
		try 
		{
			// sending id to getOneCustomer method present in dao
			Customer c=CustomerDao.getOneCustomer(id);
			
			// Redirecting user to customer-form page
			RequestDispatcher rd= request.getRequestDispatcher("customer-form.jsp");
		    request.setAttribute("customer", c);
		
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
	}

	private void getInsertForm(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			response.sendRedirect("customer-form.jsp");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response)
	{
		// Reading data from customer-form Page
		String name=request.getParameter("tbName");
		String email=request.getParameter("tbEmail");
		Long mobile=Long.parseLong(request.getParameter("tbMobile"));
		
		// Store the admin given data into model/Object
		Customer c=new Customer(name, email, mobile);
		
		// Insert customer data to DB
		CustomerDao.addCustomer(c);
		
		// Redirect Admin to HomePage (customer-list page)
		getCustomerListPage(request, response);
	}

	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			// Redirecting user to admin-login page
			RequestDispatcher rd = request.getRequestDispatcher("admin-login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void getCustomerListPage(HttpServletRequest request, HttpServletResponse response)
	{
		try 
		{
			// Redirecting user to customer-list page
			RequestDispatcher rd = request.getRequestDispatcher("customer-list.jsp");
			
			ArrayList<Customer> alCustomer=CustomerDao.getAllCustomer();
			request.setAttribute("al",alCustomer);
			
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
