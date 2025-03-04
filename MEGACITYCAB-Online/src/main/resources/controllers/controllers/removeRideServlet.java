package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RideType;
import services.rideService;

@WebServlet(urlPatterns = "/RemoveRide")
public class removeRideServlet extends HttpServlet{
	
	rideService rideServ = new rideService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		{
			Enumeration<String> parameterNames = req.getParameterNames();
			
			RideType tmpR = new RideType();
			{
				String paramName = parameterNames.nextElement();
				tmpR.setmID(Integer.parseInt(paramName));
			}
			try
			{
				rideServ.Deletion(tmpR);
				RequestDispatcher view = req.getRequestDispatcher("removeRide.jsp");
				view.forward(req, resp);
			} 
			catch (ClassNotFoundException e1)
			{
				e1.printStackTrace();
			}
		}
	}
}
