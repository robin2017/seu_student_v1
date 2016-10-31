package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginService;

public class LoginServlet extends HttpServlet{
	 @Override
	    protected void doPost(HttpServletRequest request, 
	    		HttpServletResponse response)throws ServletException, IOException {
		 String user=request.getParameter("user");
		 String password=request.getParameter("password");
		 boolean isValid=LoginService.isValid(user, password);
		 if(!isValid){
			 PrintWriter out=response.getWriter();
			 out.println("error  name or password");
			 return ;
		 }
		 
		 
		 Cookie cookie=new Cookie("username",user);
		 cookie.setMaxAge(30*60);
		 response.addCookie(cookie);
		 
		 RequestDispatcher view=request.getRequestDispatcher("query.jsp");
	     view.forward(request, response);
	 }
	 protected void doGet(HttpServletRequest request, 
	    		HttpServletResponse response)throws ServletException, IOException {
		 doPost(request,response);
	 }
}
