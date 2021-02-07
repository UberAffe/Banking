package com.matt.banking.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.matt.banking.daos.DAO;
import com.matt.banking.daos.DAOCustomer;
import com.matt.banking.daos.DAOEmployee;
import com.matt.banking.pojos.POJOUser;

public final class FactoryUser {
	public static final POJOUser userLogin(String username, String password) {
		POJOUser user = null;
		try {
			System.out.println("attempting login");
			Connection conn = DB.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from getuseridandtype(?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				switch(rs.getString("utype")) {
				case "CUSTOMER":
					user=new DAOCustomer();
					break;
				case "EMPLOYEE":
					user = new DAOEmployee();
					break;
				default:
					break;
				}
				user.setUserID(rs.getInt("uid"));
				user.setUsername(username);
				((DAO)user).read();
				System.out.println("login successful");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
