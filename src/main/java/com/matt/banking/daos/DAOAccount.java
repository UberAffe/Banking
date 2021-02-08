package com.matt.banking.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.matt.banking.pojos.POJOAccount;
import com.matt.banking.utils.DB;

public class DAOAccount extends POJOAccount implements DAO{

	public DAOAccount() {
		super();
	}
	
	public DAOAccount(int accountID, float balance, String type, ArrayList<Integer> ownerIDs, ArrayList<DAOTransaction> history, boolean accepted) {
		super(accountID, balance, type, ownerIDs,  history, accepted);
	}
	@Override
	public boolean create() {
		boolean success = false;
		try {
			Connection conn = DB.getConnection();
			CallableStatement cs = conn.prepareCall("call registeraccount(?,?,?)");
			cs.setInt(1, ownerIDs.get(0));
			cs.setFloat(2, balance);
			cs.setString(3, type);
			cs.executeUpdate();
			success = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public void read() {
		try {
			Connection conn = DB.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from getaccount(?)");
			ps.setInt(1, accountID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				setAccountID(rs.getInt("account_id"));
				setBalance(rs.getFloat("balance"));
				setType(rs.getString("account_type"));
				setAccepted(rs.getBoolean("approved"));
			}
			ps.close();
			ps = conn.prepareStatement("select * from getowners(?)");
			ps.setInt(1, accountID);
			rs = ps.executeQuery();
			ArrayList<Integer> owners = new ArrayList<Integer>();
			while(rs.next()) {	
				owners.add(rs.getInt("user_id"));
			}
			setOwnerIDs(owners);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean update() {
		boolean success=false;
		try {
			Connection conn = DB.getConnection();
			CallableStatement cs = conn.prepareCall("call acceptaccount(?,?)");
			cs.setInt(1, accountID);
			cs.setBoolean(2, accepted);
			cs.executeUpdate();
			success=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public static ArrayList<DAOAccount> getPending() {
		ArrayList<DAOAccount> accounts = new ArrayList<DAOAccount>();
		try {
			Connection conn = DB.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from getallpendingaccounts()");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				DAOAccount account = new DAOAccount();
				account.setAccountID(rs.getInt("account_id"));
				account.setBalance(rs.getFloat("balance"));
				account.setType(rs.getString("account_type"));
				ArrayList<Integer> owners = new ArrayList<Integer>();
				owners.add(rs.getInt("user_id"));
				account.setOwnerIDs(owners);
				accounts.add(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accounts;
	}
}
