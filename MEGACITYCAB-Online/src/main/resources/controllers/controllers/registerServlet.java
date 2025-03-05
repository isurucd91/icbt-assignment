package controllers;

import java.io.IOException;	

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import services.registerService;

import java.util.Random;

@WebServlet(urlPatterns = "/Register")
public class registerServlet extends HttpServlet{
	
	registerService RegServ = new registerService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Random rand = new Random();
		int regno = rand.nextInt(100000);
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String type = req.getParameter("type");
		String nic = req.getParameter("nic");
		String tp = req.getParameter("telephone");
		String address = req.getParameter("address");
		String password_1 = req.getParameter("password_1");
		String password_2 = req.getParameter("password_2");
		
		if (username != "" && password_1 != "" && password_2 != "" && email != "" && type != "" && nic != "" && tp != "" && address != "" && regno != 0)
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
				TheUser.setmType(type);
				TheUser.setmRegNo(regno);
				TheUser.setmAddress(address);
				TheUser.setmNIC(nic);
				TheUser.setmTelePhoneNo(tp);
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
								
								try {
									session.setAttribute("type", RegServ.GetType(username));
									session.setAttribute("rno", RegServ.GetRegNo(username));
									session.setAttribute("email", RegServ.GetEMail(username));
									session.setAttribute("tp", RegServ.GetTelephone(username));
									session.setAttribute("address", RegServ.GetAddress(username));
									session.setAttribute("nic", RegServ.GetNIC(username));
								}
								catch (SQLException e)
								{
									e.printStackTrace();
								}
								
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
