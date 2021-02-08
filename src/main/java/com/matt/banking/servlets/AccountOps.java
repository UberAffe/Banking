package com.matt.banking.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matt.banking.daos.DAOAccount;

@Path("/account")
public class AccountOps{
	@POST
	@Path("/decisions")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String accountDecision(String json) {
		String response="";
		ObjectMapper om = new ObjectMapper();
		try {
			response="{\"results\":[";
			List<DAOAccount> accounts=om.readValue(json, om.getTypeFactory().constructCollectionType(ArrayList.class, DAOAccount.class));
			for(DAOAccount account:accounts) {
				if(!response.equals("{\"results\":[")) {
					response+=",";
				}
					response+="\""+account.update()+"\"";
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
}