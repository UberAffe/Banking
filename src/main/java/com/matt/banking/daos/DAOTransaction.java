package com.matt.banking.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;

import com.matt.banking.pojos.POJOTransaction;
import com.matt.banking.utils.DB;

public class DAOTransaction extends POJOTransaction implements DAO{

	public DAOTransaction() {
		super();
	}
	public DAOTransaction(int transactionID, int fromUser, int toUser, int fromAccount, int toAccount, float amount, boolean pending, Date timestamp) {
		super(transactionID, fromUser, toUser, fromAccount, toAccount, amount, pending, timestamp);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean create() {
		boolean success = false;
		
		try {
			Connection conn = DB.getConnection();
			CallableStatement cs = conn.prepareCall("call posttransaction(?,?,?,?,?,?)");
			cs.setInt(1, fromUser);
			cs.setInt(2, fromAccount);
			cs.setFloat(3, amount);
			cs.setInt(4, toUser);
			cs.setInt(5, toAccount);
			cs.registerOutParameter(6,Types.BOOLEAN);
			cs.setBoolean(6, accepted);
			cs.executeUpdate();
			success = cs.getBoolean(6);
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
			PreparedStatement ps = conn.prepareStatement("select * from gettransaction(?)");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				fromAccount=rs.getInt("from_account");
				fromUser=rs.getInt("from_User");
				toAccount=rs.getInt("to_account");
				toUser=rs.getInt("to_account");
				amount=rs.getFloat("amount");
				timestamp=rs.getDate("timestamp");
				accepted=rs.getBoolean("accepted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean update() {
		boolean success = false;
		try {
			Connection conn = DB.getConnection();
			CallableStatement cs = conn.prepareCall("call accepttransfer(?,?,?)");
			cs.setInt(1, transactionID);
			cs.setInt(2, toUser);
			cs.registerOutParameter(3,Types.BOOLEAN);
			cs.setBoolean(3, accepted);
			cs.executeUpdate();
			success = true;
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

}
