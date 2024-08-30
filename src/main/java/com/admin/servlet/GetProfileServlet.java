package com.admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.service.IprofileService;
import com.admin.service.ProfileServiceimpl;

/**
 * Servlet implementation class GetProfileServlet
 */
@WebServlet("/GetProfileServlet")
public class GetProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		String profilenumber = request.getParameter("profilenumber");
		
		IprofileService iprofileService = new ProfileServiceimpl();
		
		iprofileService.getProfileById(profilenumber);
		
		
        request.setAttribute("profilenumber", profilenumber);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateprofile.jsp");
		
		dispatcher.forward(request, response);
		
	}

}
