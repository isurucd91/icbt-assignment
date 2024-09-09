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

import model.Query;
import services.loginService;
import services.queryService;

@WebServlet(urlPatterns = "/ViewQuery")
public class viewQueryServlet extends HttpServlet{
	
	queryService queServ = new queryService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String usrname = session.getAttribute("username").toString();
		
		loginService logServ = new loginService();
		try
		{
			int custid = logServ.GetCustID(usrname);
			List<Query> list = queServ.GetData(custid);
			req.setAttribute("querylist" , list);
			RequestDispatcher view = req.getRequestDispatcher("viewquery.jsp");
			view.forward(req, resp);
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
