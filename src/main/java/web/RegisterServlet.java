package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginService;

public class RegisterServlet extends HttpServlet{
	 @Override
	    protected void doPost(HttpServletRequest request, 
	    		HttpServletResponse response)throws ServletException, IOException {
		 String user=request.getParameter("user");
		 String password=request.getParameter("password");
		 String phone=request.getParameter("phone");
		 LoginService.register(user, password);
		 PrintWriter out=response.getWriter();
		 out.println("register success");
		 return ;
	 }
	 protected void doGet(HttpServletRequest request, 
	    		HttpServletResponse response)throws ServletException, IOException {
		 doPost(request,response);
	 }
}
