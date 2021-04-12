package com.revature.jamesartacho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.jamesartacho.connectionutil.ConnectionUtility;
import com.revature.jamesartacho.model.Pending;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
		//global var
		public static PreparedStatement ps =  null;
		public static ResultSet myRs=null;
		ArrayList<Pending> pen_array = new ArrayList<Pending>();
		
		//request
		public Boolean requestReimburse(String purpose, Double amount, Integer id) {
			try(Connection conn = ConnectionUtility.getConnection()){
				ps = conn.prepareStatement("INSERT INTO ers_schema.pending_ers VALUES (null,?,?,?,?) ");
				ps.setInt(1, id);
				ps.setString(2, purpose);
				ps.setDouble(3, amount);
				ps.setString(4, "pending");
				
				ps.executeUpdate();
				
				return true;
	
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			
		}

		//view pending 
		public List<Pending> viewPending(Integer id) {
			
			
			try(Connection conn = ConnectionUtility.getConnection()){
				ps = conn.prepareStatement("SELECT * FROM ers_schema.Pending_ERS WHERE eid = ? AND status = ? ");
				ps.setInt(1, id);
				ps.setString(2, "pending");
				myRs = ps.executeQuery();
				
				while(myRs.next()) {
					Pending pen = new Pending();
					pen.setRid(myRs.getInt(1));
					pen.setEid(myRs.getInt(2));
					pen.setPurpose(myRs.getString(3));
					pen.setAmount(myRs.getDouble(4));
					pen.setStatus(myRs.getString(5));
					
					pen_array.add(pen);
			
				}

			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
			return pen_array;
			
		}

		//view resolved 
		public List<Pending> viewResolved(Integer id) {
			try(Connection conn = ConnectionUtility.getConnection()){
				ps = conn.prepareStatement("SELECT * FROM ers_schema.Pending_ERS WHERE eid = ? AND (status = ? OR status = ?) ");
				ps.setInt(1, id);
				ps.setString(2,"approved");
				ps.setString(3, "denied");
				myRs = ps.executeQuery();
				
				while(myRs.next()) {
					
					Pending pen = new Pending();
					pen.setRid(myRs.getInt(1));
					pen.setEid(myRs.getInt(2));
					pen.setPurpose(myRs.getString(3));
					pen.setAmount(myRs.getDouble(4));
					pen.setStatus(myRs.getString(5));
					
					pen_array.add(pen);
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
			return pen_array;
		}

		
		public List<Pending> viewAllPending() {
			
			try(Connection conn = ConnectionUtility.getConnection()){
				ps = conn.prepareStatement("SELECT * FROM ers_schema.Pending_ERS WHERE status=? ");
				ps.setString(1, "pending");
				myRs = ps.executeQuery();
				
				while(myRs.next()) {
					Pending pen = new Pending();
					
					pen.setRid(myRs.getInt(1));
					pen.setEid(myRs.getInt(2));
					pen.setPurpose(myRs.getString(3));
					pen.setAmount(myRs.getDouble(4));
					pen.setStatus(myRs.getString(5));
					
					pen_array.add(pen);
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
				
			}
			return pen_array;

		}

		
		public Boolean approveDeny(Integer id, String choice) {
			try(Connection conn = ConnectionUtility.getConnection()){
				ps = conn.prepareStatement("UPDATE ers_schema.Pending_ERS SET status=? WHERE rid=? ");
				ps.setString(1, choice);
				ps.setInt(2, id);
				ps.executeUpdate();
				
				return true;
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
				
			}
			
			
		}

		
		public List<Pending> viewAllResolved() {
			try(Connection conn = ConnectionUtility.getConnection()){
				ps = conn.prepareStatement("SELECT * FROM ers_schema.Pending_ERS WHERE status=? OR status=? ");	
				ps.setString(1, "approved");
				ps.setString(2, "denied");
				myRs = ps.executeQuery();

				
				while(myRs.next()) {
					Pending pen = new Pending();
					
					pen.setRid(myRs.getInt(1));
					pen.setEid(myRs.getInt(2));
					pen.setPurpose(myRs.getString(3));
					pen.setAmount(myRs.getDouble(4));
					pen.setStatus(myRs.getString(5));
					
					pen_array.add(pen);
				}
	
				
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
		}
			return pen_array;
	}
}
