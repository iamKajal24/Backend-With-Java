package com.kajal.ServletEx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("Inside Servlet Service");
		
		res.setContentType("text/html");

		PrintWriter out = res.getWriter();
		out.println("<h2><b>Hello world</b></h2>");
	}

}
