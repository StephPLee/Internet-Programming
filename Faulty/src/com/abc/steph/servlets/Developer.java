package com.abc.steph.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

import com.abc.steph.lib.Convertors;
import com.abc.steph.lib.DButils;
import com.abc.steph.models.DevModel;
import com.abc.steph.models.FaultModels;
import com.abc.steph.stores.DevStore;
import com.abc.steph.stores.FaultsStore;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Developer
 */
@WebServlet(urlPatterns = { "/Devs", "/Dev/*" }, initParams = { @WebInitParam(name = "data-source", value = "jdbc/StephLeeDB") })
public class Developer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource _ds = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Developer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		DButils db = new DButils();
		db.createSchema();
		_ds=db.assemble(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String args[] = Convertors.SplitRequestPath(request);
		if (!args[args.length - 1].equals("Devs")) {
			Iterator<DevStore> iterator;
			String id;
			DevModel Devs = new DevModel(); // Create a new instance of
			id = args[args.length - 1];
			Devs.setDatasource(_ds);
			DevStore ps = Devs.getDev(id); // Get a list of

			/* If we want to forward to a jsp page do this */
			request.setAttribute("Devs", ps); // Set a bean with the list in
												// it
			RequestDispatcher rd = request
					.getRequestDispatcher("/DevDetails.jsp");

			rd.forward(request, response);

		} else {

			// PUT CODE HERE

			Iterator<DevStore> iterator;
			DevModel Devs = new DevModel(); // Create a new instance of
													// the
													// model

			Devs.setDatasource(_ds);
			LinkedList<DevStore> psl = Devs.getDevs(); // Get a list of
																// all
																// faults

			/* If we want to forward to a jsp page do this */
			request.setAttribute("Devs", psl); // Set a bean with the list in
													// it
			RequestDispatcher rd = request
					.getRequestDispatcher("/RenderDevs.jsp");

			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "StephLeeDB";
		String driver = "com.mysql.jdbc.Driver";
		Connection Conn;

		try {
			String name = request.getParameter("name");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");

			conn = DriverManager
					.getConnection(url + dbName, "root", "Cl1m8t3;");
			PreparedStatement pst = (PreparedStatement) conn
					.prepareStatement("INSERT INTO developer(name, username, password, email) VALUES (?,?,?,?);");// try2

			pst.setString(1, name);
			pst.setString(2, username);
			pst.setString(3, password);
			pst.setString(4, email);

			int i = pst.executeUpdate();
			// conn.commit();
			if (i != 0) {
				request.setAttribute("devMessage","Thank you for your submission!");  
			    //important forward it back to the login page again.   
			    RequestDispatcher rd=request.getRequestDispatcher("NewDev.jsp");  
			    rd.forward(request,response); 
			} else {
				request.setAttribute("devMessage","Submission wasn't sent!");  
			    //important forward it back to the login page again.   
			    RequestDispatcher rd=request.getRequestDispatcher("NewDev.jsp");  
			    rd.forward(request,response); 
			}
			pst.close();
		} catch (Exception e) {
			pw.println(e);
		}
		pw.close();

	}
}
