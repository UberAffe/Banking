package com.matt.banking.servlets;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/message")
public class Testlet {

	@GET
	@Path("/no")
	public String message() {
		return "Work Damit!";
	}
}
