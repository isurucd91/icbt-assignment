package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

@WebServlet(urlPatterns = "/ViewRide")
public class viewRideServlet extends HttpServlet{
	
	rideService rideServ = new rideService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String usrname = session.getAttribute("username").toString();
		
		loginService logServ = new loginService();
		try
		{
			int drvid = logServ.GetUserID(usrname);
			List<RideType> list = rideServ.GetData(drvid);
			req.setAttribute("ridelist" , list);
			RequestDispatcher view = req.getRequestDispatcher("viewRide.jsp");
			view.forward(req, resp);
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
