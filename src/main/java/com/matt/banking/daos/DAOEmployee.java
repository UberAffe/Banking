package com.matt.banking.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.matt.banking.pojos.POJOEmployee;
import com.matt.banking.utils.DB;

public class DAOEmployee extends POJOEmployee implements DAO{

	public DAOEmployee() {
		super();
	}

	public DAOEmployee(int userID, String username, String password) {
		super(userID, username, password);
	}

	@Override
	public boolean create() {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update() {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<DAOTransaction> getTransactions() {
		ArrayList<DAOTransaction> ts = new ArrayList<DAOTransaction>();
		try {
			Connection conn = DB.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from getalltransactions(?)");
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DAOTransaction dt = new DAOTransaction();
				dt.setTransactionID(rs.getInt("transaction_id"));
				dt.setAmount(rs.getFloat("amount"));
				dt.setFromAccount(rs.getInt("from_account"));
				dt.setPending(rs.getBoolean("accepted"));
				dt.setFromUser(rs.getInt("from_user"));
				dt.setTimestamp(rs.getDate("timestamp"));
				dt.setToAccount(rs.getInt("to_account"));
				dt.setToUser(rs.getInt("to_user"));
				ts.add(dt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ts;
	}

}
