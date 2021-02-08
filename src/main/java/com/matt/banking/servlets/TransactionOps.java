package com.matt.banking.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matt.banking.daos.DAOCustomer;
import com.matt.banking.daos.DAOEmployee;
import com.matt.banking.daos.DAOTransaction;

@Path("/transaction")
public class TransactionOps {

	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String postTransaction(String content) {
		ObjectMapper om = new ObjectMapper();
		System.out.println(content);
		try {
			DAOTransaction transaction=om.readValue(content, DAOTransaction.class);
			if(transaction.create()) {
				return "{\"completed\":\"true\"}";
			}
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"completed\":\"false\"}";
	}
	
	@POST
	@Path("/decisions")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String transactionDecision(String json) {
		String response="";
		ObjectMapper om = new ObjectMapper();
		try {
			response="{\"results\":[";
			List<DAOTransaction> transactions=om.readValue(json, om.getTypeFactory().constructCollectionType(ArrayList.class, DAOTransaction.class));
			for(DAOTransaction dt:transactions) {
				if(!response.equals("{\"results\":[")) {
					response+=",";
				}
					response+="\""+dt.update()+"\"";
			}
			response+="]}";
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response);
		return response;
	}
	
	@POST
	@Path("/viewpending")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static String viewPending(String json) {
		String response="";
		ObjectMapper om = new ObjectMapper();
		try {
			DAOCustomer user = om.readValue(json, DAOCustomer.class);
			response = om.writeValueAsString(user.getTransactions());
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
	@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public static String viewAllTransactions(String json) {
		System.out.println("viewAllTransactions reached");
		String response="";
		ObjectMapper om = new ObjectMapper();
		try {
			DAOEmployee user = om.readValue(json, DAOEmployee.class);
			response = om.writeValueAsString(user.getTransactions());
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
