package com.resisterlogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/submitform")

public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("myname");
		String email=req.getParameter("myemail");
		String password=req.getParameter("mypassword");
		String gender=req.getParameter("mygender");
		String city=req.getParameter("mycity");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register_login","root","root");
			PreparedStatement ps=con.prepareStatement("insert into registerlogin values(?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, gender);
			ps.setString(5, city);
           	int count=ps.executeUpdate();
			 
			 if(count>0) {
				resp.setContentType("text/html");
				out.println("user regiterd successfully");
				RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
				rd.include(req,resp);
			 }
			 else {
				 resp.setContentType("text/html");
				 out.println("faild");
				 RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
				 rd.include(req,resp);
			 }
			
			
		}catch (Exception e) {
			e.printStackTrace();
			resp.setContentType("text/html");
			 out.println("faild"+e.getMessage());
			 RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
			 rd.include(req,resp);
		}
	}

}
