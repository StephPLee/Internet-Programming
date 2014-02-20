package com.abc.steph.models;

import java.util.LinkedList;

import javax.sql.DataSource;

import java.sql.*;

import com.abc.steph.stores.*;
public class DevModel {
	private DataSource _ds = null;
	public DevModel(){

	}

	public void setDatasource(DataSource _ds){
		this._ds=_ds;
		System.out.println("Set Data Source in Model"+_ds.toString());
	}

    public LinkedList<DevStore> getDev(){
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
		String sqlQuery = "select name,username,email from developer";
		System.out.println("Dev Query " + sqlQuery);
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
				ps = new DevStore();
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
    
    public void postDev(String firstname, String lastname, String title, String description, String rarity, String severity){
    	
    }
}
