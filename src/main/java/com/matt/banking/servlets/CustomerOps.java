package com.matt.banking.servlets;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matt.banking.daos.DAOAccount;
import com.matt.banking.daos.DAOCustomer;
import com.matt.banking.daos.DAOTransaction;

@Path("/customer")
public class CustomerOps {
	private static Logger log = LogManager.getLogger(CustomerOps.class);

	@POST
	@Path("/viewaccounts")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static String viewAccounts(String json) {
		log.info("User trying to view accounts");
		String response="";
		ObjectMapper om = new ObjectMapper();
		try {
			DAOCustomer user = om.readValue(json, DAOCustomer.class);
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
	@Path("/viewpending")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static String viewPending(String json) {
		log.info("User trying to view pending transactions");
		String response="";
		ObjectMapper om = new ObjectMapper();
		try {
			DAOCustomer user = om.readValue(json, DAOCustomer.class);
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
	@Path("/read")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static String readUser(String json) {
		log.info("Updating User info.");
		String response ="";
		ObjectMapper om = new ObjectMapper();
		try {
			DAOCustomer user = om.readValue(json, DAOCustomer.class);
			user.read();
			response = om.writeValueAsString(user);
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
	@Path("/apply")
	@Consumes(MediaType.APPLICATION_JSON)
	public static String applyForAccount(String json) {
		log.info("applying for account.");
		String response ="";
		ObjectMapper om = new ObjectMapper();
		try {
			DAOAccount account = om.readValue(json, DAOAccount.class);
			if(account.create()) {
				response = om.writeValueAsString(account);
			}
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
