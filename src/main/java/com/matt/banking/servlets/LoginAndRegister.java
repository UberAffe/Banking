package com.matt.banking.servlets;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

	public void register() {

	}
}
