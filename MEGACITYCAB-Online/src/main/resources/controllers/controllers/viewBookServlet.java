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

import model.Booking;
import services.loginService;
import services.bookService;

@WebServlet(urlPatterns = "/ViewBook")
public class viewBookServlet extends HttpServlet{
	
	bookService bookServ = new bookService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String usrname = session.getAttribute("username").toString();
		
		loginService logServ = new loginService();
		try
		{
			int custid = logServ.GetUserID(usrname);
			List<Booking> list = bookServ.GetData(custid);
			req.setAttribute("booklist" , list);
			RequestDispatcher view = req.getRequestDispatcher("viewBook.jsp");
			view.forward(req, resp);
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
