package com.admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.model.Profile;
import com.admin.service.IprofileService;
import com.admin.service.ProfileServiceimpl;

/**
 * Servlet implementation class updateProfileServlet
 */
@WebServlet("/updateProfileServlet")
public class updateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateProfileServlet() {
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
		
		Profile profile = new Profile();
		
		String profilenumber = request.getParameter("profilenumber");
		
		profile.setProfilenumber(profilenumber);
		profile.setFullname(request.getParameter("fullname"));
		profile.setItnumber(request.getParameter("itnumber"));
		profile.setEmail(request.getParameter("email"));
		profile.setPhonenumber(request.getParameter("phonenumber"));
		profile.setAddress(request.getParameter("address"));
		profile.setUsername(request.getParameter("username"));
		profile.setPassword(request.getParameter("password"));
		
		System.out.println(profile.getProfilenumber());
		
		IprofileService iprofileservice = new ProfileServiceimpl();
		iprofileservice.UpdateProfile(profilenumber,profile);
		
		
		request.setAttribute("profile", profile);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/allprofile.jsp");
		
		dispatcher.forward(request, response);
		
	}

}
