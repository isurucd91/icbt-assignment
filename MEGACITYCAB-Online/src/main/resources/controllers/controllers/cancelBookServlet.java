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

import model.Booking;
import services.bookService;

@WebServlet(urlPatterns = "/CancelBook")
public class cancelBookServlet extends HttpServlet{
	
	bookService bookServ = new bookService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		{
			Enumeration<String> parameterNames = req.getParameterNames();
			
			Booking tmpB = new Booking();
			{
				String paramName = parameterNames.nextElement();
				tmpB.setmID(Integer.parseInt(paramName));
			}
			try
			{
				bookServ.Deletion(tmpB);
				RequestDispatcher view = req.getRequestDispatcher("cancelBook.jsp");
				view.forward(req, resp);
			} 
			catch (ClassNotFoundException e1)
			{
				e1.printStackTrace();
			}
		}
	}
}
