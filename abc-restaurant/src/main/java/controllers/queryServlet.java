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

import model.Query;
import services.loginService;
import services.queryService;

@WebServlet(urlPatterns = "/Query")
public class queryServlet extends HttpServlet{
	
	queryService ResServ = new queryService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String queryText = req.getParameter("querytext");

		HttpSession session = req.getSession();
		String usrname = session.getAttribute("username").toString();
		
		loginService logServ = new loginService();
		try
		{
			int custid = logServ.GetCustID(usrname);
			
			if (queryText != "" && custid >= 0)
			{
				Query que = new Query();
				
				que.setQueryText(queryText);
				que.setReplyText("");
				que.setmCustId(custid);
					
				try
				{
					if (ResServ.Insertion(que))
					{
						req.setAttribute("queryerr" , "");
						resp.sendRedirect("Home");
					}
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			else
			{
				req.setAttribute("queryerr" , "Fields are empty!");
				RequestDispatcher view = req.getRequestDispatcher("query.jsp");
				view.forward(req, resp);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
