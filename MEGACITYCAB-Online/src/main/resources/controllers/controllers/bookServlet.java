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

import model.Booking;
import services.loginService;
import services.bookService;

@WebServlet(urlPatterns = "/Book")
public class bookServlet extends HttpServlet{
	
	bookService bookServ = new bookService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pickadd = req.getParameter("pickadd");
		String dropadd = req.getParameter("dropadd");
		String ridetype = req.getParameter("ridetypes");
		String driverid = req.getParameter("driver");
		
		HttpSession session = req.getSession();
		String usrname = session.getAttribute("username").toString();
		
		loginService logServ = new loginService();
		try
		{
			int custid = logServ.GetUserID(usrname);
			
			if (pickadd != "" && dropadd != "" && ridetype != "" && driverid != "" && custid >= 0)
			{
				Booking book = new Booking();
					
				book.setmCustomerID(custid);
				book.setmPickupAddress(pickadd);
				book.setmDropAddress(dropadd);
				book.setmRideType(ridetype);
				book.setmDriverID(Integer.parseInt(driverid));
				
				try
				{
					if (bookServ.Insertion(book))
					{
						req.setAttribute("bookerr" , "");
						resp.sendRedirect("Home");
					}
					else
					{
						req.setAttribute("bookerr" , "Booking Failure!");
						RequestDispatcher view = req.getRequestDispatcher("book.jsp");
						view.forward(req, resp);			
					}
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			else
			{
				req.setAttribute("bookerr" , "Fields are empty!");
				RequestDispatcher view = req.getRequestDispatcher("book.jsp");
				view.forward(req, resp);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
