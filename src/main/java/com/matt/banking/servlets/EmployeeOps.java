package com.matt.banking.servlets;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matt.banking.daos.DAOAccount;
import com.matt.banking.daos.DAOCustomer;

@Path("/employee")
public class EmployeeOps {

	@POST
	@Path("/useraccounts")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static String getUserAccounts(String json) {
		String response="";
		ObjectMapper om = new ObjectMapper();
		try {
			DAOCustomer user = om.readValue(json, DAOCustomer.class);
			System.out.println(user.toString());
			user.read();
			response = om.writeValueAsString(user.getAccounts());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	@POST
	@Path("/pendingaccounts")
	@Produces(MediaType.APPLICATION_JSON)
	public static String getPendingAccounts() {
		String response="";
		ObjectMapper om = new ObjectMapper();
		try {
			response = om.writeValueAsString(DAOAccount.getPending());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	@POST
	@Path("/pendingusers")
	@Produces(MediaType.APPLICATION_JSON)
	public static String getPendingUsers() {
		String response="";
		ObjectMapper om = new ObjectMapper();
		try {
			response = om.writeValueAsString(DAOCustomer.getPending());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
}
