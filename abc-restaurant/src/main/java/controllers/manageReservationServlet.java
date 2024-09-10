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

@WebServlet(urlPatterns = "/ManageReservation")
public class manageReservationServlet extends HttpServlet{
	
	reserveService resServ = new reserveService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String custid = req.getParameter("custid");
		int cid = custid != "" ? Integer.parseInt(custid) : -1;
		
		{
			if (cid >= 0)
			{
				try
				{
					List<Reservation> list = resServ.GetData(cid);
					req.setAttribute("reslist" , list);
					RequestDispatcher view = req.getRequestDispatcher("upreservations.jsp");
					view.forward(req, resp);
				}
				catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
