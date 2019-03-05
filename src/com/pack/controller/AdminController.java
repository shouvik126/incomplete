package com.pack.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack.model.Login;
import com.pack.model.Profile;
import com.pack.service.AdminServiceImpl;

/**
 * Servlet implementation class AdminController
 */
//@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String usr=request.getParameter("username");
		String pass=request.getParameter("password");
		
		//fetching login details
		AdminServiceImpl as=new AdminServiceImpl();
		Login l=as.fetchLogin(usr,pass);
		//fetching profile details
		if(l!=null)
		{
			String usertype=l.getUsertype();
			System.out.println(usertype);
			Profile p=as.fetchProfile(l.getId());
			HttpSession hs=request.getSession(true);
			hs.setAttribute("login", l);
			hs.setAttribute("profile", p);
			if(usertype.equals("admin"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/AdminListProduct.jsp");
				rd.forward(request, response);
			}
		}
		else
		{
			AdminServiceImpl as1=new AdminServiceImpl();
			Login l1=as1.fetchLoginByUser(usr);
			if(l1!=null)
			{
				//setting status no for incorrect password
				int i=as.setLoginStatus(l1);
				response.sendRedirect("/grizzly-store-admin-web/AdminLogin.jsp");
			}
			else
			{
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Username and Password is incorrect');");
				pw.println("location='/grizzly-store-admin-web/AdminLogin.jsp';");
				pw.println("</script>");
			}
			//System.out.println("user not found");
		}
	}//do post end

}
