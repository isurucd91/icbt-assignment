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

@WebServlet(urlPatterns = "/UpdateQuery")
public class updateQueryServlet extends HttpServlet{
	
	queryService queServ = new queryService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		{
			Enumeration<String> parameterNames = req.getParameterNames();
			
			Query tmpQ = new Query();
			{
				String paramName = parameterNames.nextElement();
				String paramValue = req.getParameter(paramName);
				tmpQ.setReplyText(paramValue);
			}
			{
				String paramName = parameterNames.nextElement();
				tmpQ.setmID(Integer.parseInt(paramName));
			}
			try
			{
				queServ.Update(tmpQ);
				RequestDispatcher view = req.getRequestDispatcher("manqueries.jsp");
				view.forward(req, resp);
			} 
			catch (ClassNotFoundException e1)
			{
				e1.printStackTrace();
			}
		}
	}
}
