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

import model.RideType;
import services.loginService;
import services.rideService;

@WebServlet(urlPatterns = "/AddRide")
public class addRideServlet extends HttpServlet{
	
	rideService rideServ = new rideService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ridetype = req.getParameter("ridetypes");
		String ridedetails = req.getParameter("ridedetails");
		
		HttpSession session = req.getSession();
		String usrname = session.getAttribute("username").toString();
		
		loginService logServ = new loginService();
		try
		{
			int drvid = logServ.GetUserID(usrname);
			
			if (ridedetails != "" && ridetype != "" && drvid >= 0)
			{
				RideType ride = new RideType();
					
				ride.setmRideDetails(ridedetails);
				ride.setmRideType(ridetype);
				ride.setmDriverID(drvid);
				
				try
				{
					if (rideServ.Insertion(ride))
					{
						req.setAttribute("rideerr" , "");
						resp.sendRedirect("Home");
					}
					else
					{
						req.setAttribute("rideerr" , "Adding Ride Failure!");
						RequestDispatcher view = req.getRequestDispatcher("addRide.jsp");
						view.forward(req, resp);			
					}
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			else
			{
				req.setAttribute("rideerr" , "Fields are empty!");
				RequestDispatcher view = req.getRequestDispatcher("addRide.jsp");
				view.forward(req, resp);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
