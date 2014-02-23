package com.abc.steph.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.abc.steph.lib.DButils;
import com.abc.steph.models.AdminModel;
import com.abc.steph.models.DevModel;
import com.abc.steph.stores.AdminStore;
import com.abc.steph.stores.DevStore;

/**
 * Servlet implementation class DevLogin
 */
@WebServlet(urlPatterns = { "/AdminLogin" }, initParams = { @WebInitParam(name = "data-source", value = "jdbc/Faultdb") })
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource _ds = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DButils db = new DButils();
		_ds = db.assemble(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("adusername");
		AdminModel Admins = new AdminModel();
		LinkedList<AdminStore> psl = Admins.getAdmins();
		System.out.println("Starting GET");
		// String args[]=Convertors.SplitRequestPath(request);
		Iterator<AdminStore> iterator;
		Admins.setDatasource(_ds);
		String password = Admins.getAdminLogin(username);
		if (password != null)
			if (password.equals(request.getParameter("adpassword"))) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/AdminOptions.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("adminError","Username or Password Incorrect");  
			    //important forward it back to the login page again.   
			    RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");  
			    rd.forward(request,response); 
			}
		else {
			request.setAttribute("adminError","Username or Password Incorrect");  
		    //important forward it back to the login page again.   
		    RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");  
		    rd.forward(request,response); 
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

