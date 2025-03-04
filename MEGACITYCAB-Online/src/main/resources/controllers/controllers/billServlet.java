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
import services.distanceCalcService;
import services.loginService;
import services.bookService;

@WebServlet(urlPatterns = "/BillBook")
public class billServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String usrname = session.getAttribute("username").toString();
		
		loginService logServ = new loginService();
		bookService bookServ = new bookService();
		try
		{
			int custid = logServ.GetUserID(usrname);
			List<Booking> list = bookServ.GetData(custid);
			
			Enumeration<String> parameterNames = req.getParameterNames();
			String paramName = parameterNames.nextElement();
			int bookID = Integer.parseInt(paramName);
		
			for(Booking book : list)
			{
				if (book.getmID() == bookID)
				{
					String startpt = book.getmPickupAddress();
					String droppt = book.getmDropAddress();
					
		            String jsonResponse = distanceCalcService.getDistance(startpt, droppt);
		            System.out.println(jsonResponse);
		            String distance = distanceCalcService.parseDistance(jsonResponse);
		            System.out.println(distance);
		            
		            double Tax = 0.1;
		            double PricePerKM = 100.0;//RS
		            double dist = Double.parseDouble(distance);
		            double Tot = dist * PricePerKM;
		            Tot += Tot * Tax;
		            
		            req.setAttribute("billval" , Double.toString(Tot));
		            req.setAttribute("bid" , Integer.toString(bookID));
					RequestDispatcher view = req.getRequestDispatcher("bill.jsp");
					view.forward(req, resp);
					break;	
				}
	
			}
		}
		catch (ClassNotFoundException e1)
		{
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
