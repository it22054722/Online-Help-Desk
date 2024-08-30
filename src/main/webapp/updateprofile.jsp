<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     
    <%@ page import = "com.admin.model.Profile" %>
     <%@ page import = "com.admin.service.IprofileService" %>
     <%@ page import = "com.admin.service.ProfileServiceimpl" %>
     <%@ page import = "java.util.ArrayList" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
<style>

        body {
            font-family: 'Arial', sans-serif;
            background-color: #e9ecef;
            margin: 0;
            padding: 0;
            color: #333;
        }
        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #d1bea8;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1, h2, p {
            text-align: center;
        }
        h1 {
            margin-top: 0;
            color: #4f3a3c;
        }
        .content {
            margin-top: 20px;
        }
        .team-members {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
            gap: 20px;
            margin-top: 30px;
        }
        .team-member {
            text-align: center;
            flex: 0 1 calc(33.33% - 20px);
        }
        .team-member img {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            border: 3px solid #007bff;
        }
        .team-member p {
            margin-top: 10px;
        }
        
        footer {
      background-color: rgba(0, 0, 0, 0.5); /* Semi-transparent background */
      color: #fff;
      padding: 20px 0;
      text-align: center;
      position: absolute; /* Position the footer */
      bottom: 0; /* Align to the bottom of the viewport */
      width: 100%; /* Full width */
      z-index: 2; /* Ensure the footer appears on top of the image */
    }

    /* Define styles for the image */
    .bg-image {
      position: relative; /* Ensure the image container is relative */
      height: 120px; /* Set the height of the image */
      width:120%;
    }

    .bg-image img {
      width: 100%; /* Make the image fill its container */
      height: 100%; /* Make the image fill its container */
      object-fit: cover; /* Ensure the image covers the entire container */
      position: absolute; /* Position the image */
      top: 0;
      left: 0;
      z-index: 1; /* Ensure the image appears behind the footer */
    }
    </style>
</head>
<body class="p-3 m-0 border-0 bd-example m-0 border-0">

<img src ="imgs/webbanner.png" >
    <br>
    <br>
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="home.jsp">Help Desk</a>
        </li>
        <li class="nav-item dropdown">
            <a
                class="nav-link dropdown-toggle"
                data-bs-toggle="dropdown"
                href="#"
                role="button"
                aria-expanded="false"
                >Login</a
            >
            <ul class="dropdown-menu" style="">
                <li><a class="dropdown-item" href="#">Student Login</a></li>
                <li><a class="dropdown-item" href="#">Lecture Login</a></li>
                <li><a class="dropdown-item" href="#">Academic Officer</a></li>
                <li><a class="dropdown-item" href="login.jsp">Administration Login</a></li>
            </ul>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="aboutus.jsp">About Us</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="contactus.jsp" colour ="#ffffff " >Connect With Us</a>
        </li>
    </ul>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <br>
<h1>Update Profile</h1>

<%

     String profilenumber = (String)request.getAttribute("profilenumber");

   IprofileService iprofileService = new ProfileServiceimpl();
   ArrayList<Profile> profileList  = iprofileService.getProfileById(profilenumber);

%>
      <%
        for(Profile profiles:profileList){
      %>
     
     
     <form  action = "<%=request.getContextPath() %>/updateProfileServlet" method="post">
     
     <div class="form-floating mb-3">
		  <input type="hidden" class="form-control" id="floatingInput" name = "profilenumber" value ="<%= profiles.getProfilenumber()  %>">
		  <label for="floatingInput">Profilen</label>
		</div>
		   <div class="form-floating mb-3">
		  <input type="text" class="form-control" id="floatingInput" name = "fullname" value ="<%= profiles.getFullname()  %>">
		  <label for="floatingInput"> Full Name</label>
		</div>
		
		 <div class="form-floating mb-3">
		  <input type="text" class="form-control" id="floatingInput" name = "itnumber" value ="<%= profiles.getItnumber() %>">
		  <label for="floatingInput"> IT Number </label>
		</div>
		
		 <div class="form-floating mb-3">
		  <input type="text" class="form-control" id="floatingInput" name = "email" value ="<%= profiles.getEmail() %>">
		  <label for="floatingInput">  Email</label>
		</div>
		
		<div class="form-floating mb-3">
		  <input type="text" class="form-control" id="floatingInput" name = "phonenumber" value ="<%= profiles.getPhonenumber() %>">
		  <label for="floatingInput">  Phone Number</label>
		</div>
		
		<div class="form-floating mb-3">
		  <input type="text" class="form-control" id="floatingInput" name = "address"  value ="<%= profiles.getAddress()  %>">
		  <label for="floatingInput">  Address</label>
		</div>
		
		<div class="form-floating mb-3">
		  <input type="text" class="form-control" id="floatingInput" name = "username" value ="<%= profiles.getUsername()  %>">
		  <label for="floatingInput">  User Name</label>
		</div>
		
		<div class="form-floating mb-3">
		  <input type="text" class="form-control" id="floatingInput" name = "password"  value ="<%= profiles.getPassword()  %>">
		  <label for="floatingInput">  Password </label>
		</div>
     
   
  
     
     <input type="submit" class ="btn btn-danger"value ="update">
      </form>
     
      <% 
          }
      %>
      
      <div class="bg-image">
    <img src="imgs/webbanner.png" alt="Background Image">
    
     
    <!-- Your webpage content goes here -->
    <h1 style="position: relative; z-index: 2;"></h1>
    <p style="position: relative; z-index: 2;">This is an example of a webpage content.</p>
  
    <!-- Footer section -->
    <footer>
      <p>&copy; 2024 Evolve University. All rights reserved.</p>
      <p>Contact: www.evolveuni.lk | Phone: +112257824</p>
    </footer>
  </div>
</body>
</html>