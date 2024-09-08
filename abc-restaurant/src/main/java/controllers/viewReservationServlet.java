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

import model.Reservation;
import services.loginService;
import services.reserveService;

@WebServlet(urlPatterns = "/ViewReserve")
public class viewReservationServlet extends HttpServlet{
	
	reserveService ResServ = new reserveService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String usrname = session.getAttribute("username").toString();
		
		loginService logServ = new loginService();
		try
		{
			int custid = logServ.GetCustID(usrname);
			List<Reservation> list = ResServ.GetData(custid);
			req.setAttribute("reservelist" , list);
			RequestDispatcher view = req.getRequestDispatcher("viewreserve.jsp");
			view.forward(req, resp);
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
