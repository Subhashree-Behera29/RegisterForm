package com.resisterlogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/loginform")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String myemail=req.getParameter("email");
		String mypassword=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register_login","root","root");
			PreparedStatement ps=con.prepareStatement("select * from registerlogin where email=? and password=?");
			ps.setString(1, myemail);
			ps.setString(2, mypassword);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				HttpSession session=req.getSession();
				session.setAttribute("session_name", rs.getString("name"));
				RequestDispatcher rd=req.getRequestDispatcher("/profile.jsp");
				rd.include(req, resp);
			}else {
				RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
