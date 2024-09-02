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
import services.registerService;

@WebServlet(urlPatterns = "/Register")
public class registerServlet extends HttpServlet{
	
	registerService RegServ = new registerService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String role = req.getParameter("roles");
		String password_1 = req.getParameter("password_1");
		String password_2 = req.getParameter("password_2");
		
		if (username != "" && password_1 != "" && password_2 != "" && email != "" && role != "")
		{
			if (!password_1.equals(password_2))
			{
				req.setAttribute("loginerr" , "Password mismatch!");
				RequestDispatcher view = req.getRequestDispatcher("register.jsp");
				view.forward(req, resp);
			}
			else
			{
				User TheUser = new User();
				
				TheUser.setmName(username);
				TheUser.setmEmail(email);
				TheUser.setmRole(role);
				TheUser.setmPassword(password_1);
				
				try
				{
					if (!RegServ.Validate(TheUser))
					{
						try
						{
							if (RegServ.Insertion(TheUser))
							{
								HttpSession session = req.getSession();
								session.setAttribute("username", username);
								req.setAttribute("loginerr" , "");
								resp.sendRedirect("Home");
							}
						}
						catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
					else
					{
						req.setAttribute("loginerr" , "Account exists!");
						RequestDispatcher view = req.getRequestDispatcher("register.jsp");
						view.forward(req, resp);			
					}
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		else
		{
			req.setAttribute("loginerr" , "Fields are empty!");
			RequestDispatcher view = req.getRequestDispatcher("register.jsp");
			view.forward(req, resp);
		}
	}
}
