package com.matt.banking.servlets;

import org.junit.jupiter.api.Test;

import com.matt.banking.utils.DB;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

public class TestLoginAndRegister {

	@BeforeAll
	public static void setup() {
		DB.isTestCase = true;
	}

	
	 @Test public void goodUserLogin() { 
		 LoginAndRegister lar = new LoginAndRegister(); 
		 String user =  lar.login("{\"username\":\"matt\",\"password\":\"keran\"}");
		 Assertions.assertFalse(user.equals("{\"username\":\"matt\",\"password\":\"keran\"}")); 
	 }
	 
	 @Test public void badUserLogin() { 
		 LoginAndRegister lar = new
		 LoginAndRegister(); String user =
		 lar.login("{\"username\":\"matt\",\"password\":\"\"}");
		 Assertions.assertTrue(user.equals("{\"username\":\"matt\",\"password\":\"\"}")); 
	 }
	 
}
