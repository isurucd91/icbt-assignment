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

import model.Reservation;
import services.loginService;
import services.reserveService;

@WebServlet(urlPatterns = "/Reserve")
public class reserveServlet extends HttpServlet{
	
	reserveService ResServ = new reserveService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String date = req.getParameter("resdate");
		String time = req.getParameter("restime");
		String type = req.getParameter("type");
		String status = req.getParameter("status");
		
		HttpSession session = req.getSession();
		String usrname = session.getAttribute("username").toString();
		
		loginService logServ = new loginService();
		try
		{
			int custid = logServ.GetCustID(usrname);
			
			if (date != "" && time != "" && type != "" && status != "" && custid >= 0)
			{
				Reservation res = new Reservation();
					
				res.setmDate(date);
				res.setmTime(time);
				res.setmStatus(status);
				res.setmType(type);
				res.setmCustID(custid);
					
				try
				{
					if (!ResServ.Validate(res))
					{
						try
						{
							if (ResServ.Insertion(res))
							{
								req.setAttribute("reserveerr" , "");
								resp.sendRedirect("Home");
							}
						}
						catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
					else
					{
						req.setAttribute("reserveerr" , "Reservation exists!");
						RequestDispatcher view = req.getRequestDispatcher("reserve.jsp");
						view.forward(req, resp);			
					}
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			else
			{
				req.setAttribute("reserveerr" , "Fields are empty!");
				RequestDispatcher view = req.getRequestDispatcher("reserve.jsp");
				view.forward(req, resp);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
