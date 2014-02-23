package com.abc.steph.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import javax.sql.DataSource;

import com.abc.steph.stores.AdminStore;
import com.abc.steph.stores.DevStore;

public class AdminModel {
	private DataSource _ds = null;
	public AdminModel(){
		
	}
	
	public void setDatasource(DataSource _ds){
		this._ds=_ds;
		System.out.println("Set Data Source in Model"+_ds.toString());
	}
	
	public LinkedList<AdminStore> getAdmins(){
		LinkedList<AdminStore> psl = new LinkedList<AdminStore>();
		Connection Conn;
		AdminStore ps = null;
		ResultSet rs = null;
		try {
			Conn = _ds.getConnection();
		} catch (Exception et) {

			System.out.println("No Connection in Devs Model");
			return null;
		}

		PreparedStatement pmst = null;
		Statement stmt = null;
		String sqlQuery = "select * from administrator";
		try {
			try {
				// pmst = Conn.prepareStatement(sqlQuery);
				stmt = Conn.createStatement();
			} catch (Exception et) {
				System.out.println("Can't create prepare statement");
				return null;
			}
			System.out.println("Created prepare");
			try {
				// rs=pmst.executeQuery();
				rs = stmt.executeQuery(sqlQuery);
			} catch (Exception et) {
				System.out.println("Can not execut query " + et);
				return null;
			}
			System.out.println("Statement executed");
			if (rs.wasNull()) {
				System.out.println("result set was null");
			} else {
				System.out.println("Well it wasn't null");
			}
			while (rs.next()) {
				System.out.println("Getting RS");
				ps = new AdminStore();
				ps.setID(rs.getString("iddev"));
				ps.setName(rs.getString("name"));
				ps.setUsername(rs.getString("username"));
				ps.setEmail(rs.getString("email"));
				psl.add(ps);
			}
		} catch (Exception ex) {
			System.out.println("Opps, error in query " + ex);
			return null;
		}

		try {

			Conn.close();
		} catch (Exception ex) {
			return null;
		}
		return psl;

	}
	
	public String getAdminLogin(String username){
		String password="";
    	LinkedList<DevStore> psl = new LinkedList<DevStore>();
		Connection Conn;
		DevStore ps = null;
		ResultSet rs = null;
		try {
			Conn = _ds.getConnection();
		} catch (Exception et) {

			System.out.println("No Connection in Devs Model");
			return null;
		}
		PreparedStatement pmst = null;
		Statement stmt = null;
		String sqlQuery = "SELECT password FROM administrator WHERE username='"+username+"';";
		System.out.println("Dev Query " + sqlQuery);
		try {
			try {
				stmt = Conn.createStatement();
			} catch (Exception et) {
				System.out.println("Can't create prepare statement");
				return null;
			}
			System.out.println("Created prepare");
			try {
				rs = stmt.executeQuery(sqlQuery);
			} catch (Exception et) {
				System.out.println("Can not execut query " + et);
				return null;
			}
			System.out.println("Statement executed");
			if (rs.wasNull()) {
				System.out.println("result set was null");
			} else {
				System.out.println("Well it wasn't null");
			}
			while (rs.next()) {
				System.out.println("Getting RS");
				ps = new DevStore();
				ps.setPassword(rs.getString("password"));
				psl.add(ps);
			}
			password = ps.getPassword();
		} catch (Exception ex) {
			System.out.println("Opps, error in query " + ex);
			return null;
		}

		try {

			Conn.close();
		} catch (Exception ex) {
			return null;
		}
		return password;
    	
    }
}