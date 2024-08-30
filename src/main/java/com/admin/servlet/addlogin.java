package com.admin.servlet;
 
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
 
import com.admin.model.adminlogin;
import com.admin.service.adminLoginService;
 
 
@WebServlet("/addlogin")

public class addlogin extends HttpServlet {

	private static final long serialVersionUID = 1L;


    public addlogin() {

        super();

    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

	}
 
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		com.admin.model.adminlogin al = new com.admin.model.adminlogin();

		al.setAdmail(request.getParameter("admail"));

		al.setAdpassword(request.getParameter("adpassword"));
		
		com.admin.service.adminLoginService service = new com.admin.service.adminLoginService();
		
        boolean status = service.validate(al);
        
        if(status) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("admindashboard.jsp");
        	dispatcher.forward(request, response);
        	
         }
        else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        	dispatcher.forward(request, response);
        	
        }
        
		

	}
 
}
