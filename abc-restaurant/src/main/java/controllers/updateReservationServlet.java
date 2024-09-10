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

import model.Reservation;
import services.reserveService;

@WebServlet(urlPatterns = "/UpdateReservation")
public class updateReservationServlet extends HttpServlet{
	
	reserveService resServ = new reserveService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		{
			Enumeration<String> parameterNames = req.getParameterNames();
			
			Reservation tmpR = new Reservation();
			{
				String paramName = parameterNames.nextElement();
				String paramValue = req.getParameter(paramName);
				tmpR.setmStatus(paramValue);
			}
			{
				String paramName = parameterNames.nextElement();
				tmpR.setmID(Integer.parseInt(paramName));
			}
			try
			{
				resServ.Update(tmpR);
				RequestDispatcher view = req.getRequestDispatcher("upreservations.jsp");
				view.forward(req, resp);
			} 
			catch (ClassNotFoundException e1)
			{
				e1.printStackTrace();
			}
		}
	}
}
