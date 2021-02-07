package com.matt.banking.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet(value="/CC/*", loadOnStartup=1)
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("operating");
		String operation = request.getParameter("operation");
		String answer = "";
		String temp = request.getParameter("firstNum");
		Double first = temp!=null ?Double.parseDouble(temp):0;
		temp = request.getParameter("secondNum");
		Double second = temp!=null ?Double.parseDouble(temp):0;
		switch(operation!=null?operation:"") {
		case "add":System.out.println(first+"+"+second);
			answer= (first+second)+"";
			break;
		case "subtract":System.out.println(first+"-"+second);
			answer= (first-second)+"";
			break;
		case "divide":System.out.println(first+"/"+second);
			answer= second!=0 ?(first/second)+"":"Cannot divide by 0";
			break;
		case "multiply":System.out.println(first+"*"+second);
			answer= (first*second)+"";
			break;
		default:System.out.println("This is first load.");
			answer="";
			break;
		}
		request.setAttribute("answer", answer);
		RequestDispatcher view =request.getRequestDispatcher("/index.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
