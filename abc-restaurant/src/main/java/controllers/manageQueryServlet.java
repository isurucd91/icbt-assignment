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

import model.Query;
import services.queryService;

@WebServlet(urlPatterns = "/ManageQuery")
public class manageQueryServlet extends HttpServlet{
	
	queryService queServ = new queryService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String custid = req.getParameter("custid");
		int cid = custid != "" ? Integer.parseInt(custid) : -1;
		
		{
			if (cid >= 0)
			{
				try
				{
					List<Query> list = queServ.GetData(cid);
					req.setAttribute("querylist" , list);
					RequestDispatcher view = req.getRequestDispatcher("manqueries.jsp");
					view.forward(req, resp);
				}
				catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
