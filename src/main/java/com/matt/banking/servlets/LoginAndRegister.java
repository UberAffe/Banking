package com.matt.banking.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matt.banking.daos.DAOCustomer;
import com.matt.banking.daos.DAOTransaction;
import com.matt.banking.pojos.POJOUser;
import com.matt.banking.utils.FactoryUser;

@Path("/user")
public class LoginAndRegister {
	private static final org.apache.logging.log4j.Logger log =LogManager.getLogger(LoginAndRegister.class);

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String login(String content) {
		log.info("Attempting login.");
		System.out.println("Attempting Login");
		ObjectMapper om = new ObjectMapper();
		POJOUser user;
		try {
			user = om.readValue(content, POJOUser.class);
			user = FactoryUser.userLogin(user.getUsername(), user.getPassword());
			log.info("user found "+user.getUserID());
			return om.writeValueAsString(user);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "you suck!";
	}

	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String register(String content) {
		String response="";
		log.info("Registering user");
		ObjectMapper om = new ObjectMapper();
		DAOCustomer user;
		try {
			user = om.readValue(content, DAOCustomer.class);
			response = om.writeValueAsString(user.create());
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
	@Path("/decisions")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String userDecision(String json) {
		String response="";
		ObjectMapper om = new ObjectMapper();
		try {
			response="{\"results\":[";
			List<DAOCustomer> users=om.readValue(json, om.getTypeFactory().constructCollectionType(ArrayList.class, DAOCustomer.class));
			for(DAOCustomer user:users) {
				if(!response.equals("{\"results\":[")) {
					response+=",";
				}
					response+="\""+user.update()+"\"";
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
