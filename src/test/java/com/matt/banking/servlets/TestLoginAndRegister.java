package com.matt.banking.servlets;

import org.junit.jupiter.api.Test;

import com.matt.banking.utils.DB;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

public class TestLoginAndRegister {

	@BeforeAll
	public static void setup() {
		DB.isTestCase=true;
	}
	
	/*
	 * @Test public void goodUserLogin() { LoginAndRegister lar = new
	 * LoginAndRegister(); String user =
	 * lar.login("{\"username\":\"matt\",\"password\":\"keran\"}");
	 * System.out.println(user); Assertions.assertTrue(
	 * "{\"userID\":3,\"username\":\"matt\",\"password\":\"\",\"accounts\":[]}".
	 * equals(user)); }
	 * 
	 * @Test public void badUserLogin() { LoginAndRegister lar = new
	 * LoginAndRegister(); String user =
	 * lar.login("{\"username\":\"matt\",\"password\":\"\"}");
	 * System.out.println(user); Assertions.assertFalse(
	 * "{\"userID\":3,\"username\":\"matt\",\"password\":\"\",\"accounts\":[]}".
	 * equals(user)); }
	 */
}
