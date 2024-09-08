package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import services.loginService;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/Login")
public class loginServlet extends HttpServlet {
	
	loginService LogServ = new loginService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User TheUser = new User();
		
		TheUser.setmName(username);
		TheUser.setmPassword(password);

		try
		{
			if (LogServ.Validate(TheUser))
			{
				HttpSession session = req.getSession();
				session.setAttribute("username", username);
				
				try {
					session.setAttribute("role", LogServ.GetRole(username));
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
	
				req.setAttribute("loginerr" , "");
				resp.sendRedirect("Home");
			}
			else
			{
				req.setAttribute("loginerr" , "Invalid Username or Password!");
				RequestDispatcher view = req.getRequestDispatcher("login.jsp");
				view.forward(req, resp);
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
