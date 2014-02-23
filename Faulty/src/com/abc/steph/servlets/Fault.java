package com.abc.steph.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

import com.abc.steph.lib.*;
import com.abc.steph.stores.*;
import com.abc.steph.models.*;

/**
 * Servlet implementation class Fault
 */
@WebServlet(urlPatterns = { "/Faults", "/Faults/*" }, initParams = { @WebInitParam(name = "data-source", value = "jdbc/StephLeeDB") })
public class Fault extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource _ds = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Fault() {
		super();
		// TODO Auto-generated constructor stub

	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
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
		if (!args[args.length-1].equals("Faults")) {
			String id;
			FaultModels Faults = new FaultModels(); // Create a new instance of
			id = args[args.length-1];
			Faults.setDatasource(_ds);
			FaultsStore ps = Faults.getFault(id); // Get a list of

			/* If we want to forward to a jsp page do this */
			request.setAttribute("Faults", ps); // Set a bean with the list in
													// it
			RequestDispatcher rd = request
					.getRequestDispatcher("/FaultDetails.jsp");

			rd.forward(request, response);

		} else {

			// PUT CODE HERE

			FaultModels Faults = new FaultModels(); // Create a new instance of
													// the
													// model

			Faults.setDatasource(_ds);
			LinkedList<FaultsStore> psl = Faults.getFaults(); // Get a list of
																// all
																// faults

			/* If we want to forward to a jsp page do this */
			request.setAttribute("Faults", psl); // Set a bean with the list in
													// it
			RequestDispatcher rd = request
					.getRequestDispatcher("/RenderFaults.jsp");

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
		try {
			int catagory = Integer.parseInt(request.getParameter("catagory"));
			String summary = request.getParameter("summary");
			String description = request.getParameter("description");

			conn = DriverManager
					.getConnection(url + dbName, "root", "Cl1m8t3;");
			PreparedStatement pst = (PreparedStatement) conn
					.prepareStatement("INSERT INTO fault(summary, details, author_idauthor, section_idsection) VALUES (?,?,?,?);");// try2

			pst.setString(1, summary);
			pst.setString(2, description);
			pst.setInt(3, 1);
			pst.setInt(4, catagory);

			int i = pst.executeUpdate();
			if (i != 0) {
				request.setAttribute("postMessage","Thank you for your submission!");  
			    //important forward it back to the login page again.   
			    RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");  
			    rd.forward(request,response); 
			} else {
				request.setAttribute("postMessage","Submission wasn't sent!");  
			    //important forward it back to the login page again.   
			    RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");  
			    rd.forward(request,response); 
			}
			pst.close();
		} catch (Exception e) {
			pw.println(e);
		}
		pw.close();
	}

}
