package com.abc.steph.models;

import java.util.LinkedList;

import javax.sql.DataSource;

import java.sql.*;

import com.abc.steph.stores.*;
public class FaultModels {
	private DataSource _ds = null;
	public FaultModels(){

	}

	public void setDatasource(DataSource _ds){
		this._ds=_ds;
		System.out.println("Set Data Source in Model"+_ds.toString());
	}

    public LinkedList<FaultsStore> getFaults(){
		LinkedList<FaultsStore> psl = new LinkedList<FaultsStore>();
		Connection Conn;
		FaultsStore ps = null;
		ResultSet rs = null;
		try {
			Conn = _ds.getConnection();
		} catch (Exception et) {

			System.out.println("No Connection in Faults Model");
			return null;
		}

		PreparedStatement pmst = null;
		Statement stmt = null;
		String sqlQuery = "select summary,idfault from fault";
		try {
			try {
				// pmst = Conn.prepareStatement(sqlQuery);
				stmt = Conn.createStatement();
			} catch (Exception et) {
				System.out.println("Can't create prepare statement");
				return null;
			}
			try {
				// rs=pmst.executeQuery();
				rs = stmt.executeQuery(sqlQuery);
			} catch (Exception et) {
				System.out.println("Can not execut query " + et);
				return null;
			}
			if (rs.wasNull()) {
				System.out.println("result set was null");
			} else {
			}
			while (rs.next()) {
				ps = new FaultsStore();
				ps.setFaultid(rs.getString("idfault"));
				ps.setFaultSummary(rs.getString("summary"));
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
    
    public FaultsStore getFault(String id){
		Connection Conn;
		FaultsStore ps = null;
		ResultSet rs = null;
		try {
			Conn = _ds.getConnection();
		} catch (Exception et) {
			System.out.println("No Connection in Faults Model");
			return null;
		}

		PreparedStatement pmst = null;
		Statement stmt = null;
		String sqlQuery = "select * from fault where idfault='"+id+"';";
		try {
			try {
				// pmst = Conn.prepareStatement(sqlQuery);
				stmt = Conn.createStatement();
			} catch (Exception et) {
				System.out.println("Can't create prepare statement");
				return null;
			}
			try {
				// rs=pmst.executeQuery();
				rs = stmt.executeQuery(sqlQuery);
			} catch (Exception et) {
				System.out.println("Can not execut query " + et);
				return null;
			}
			if (rs.wasNull()) {
				System.out.println("result set was null");
			} else {
			}
			while (rs.next()) {
				ps = new FaultsStore();
				ps.setFaultid(rs.getString("idfault"));
				ps.setFaultSummary(rs.getString("summary"));
				ps.setFaultDetails(rs.getString("details"));
				ps.setFaultAuthor(rs.getString("author_idauthor"));
				ps.setFaultSection(rs.getString("section_idsection"));
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
		return ps;

	}
    
    public void postFault(String firstname, String lastname, String title, String description, String rarity, String severity){
    	
    }
}