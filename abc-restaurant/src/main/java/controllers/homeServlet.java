package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Home") 
public class homeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getSession().getAttribute("username").toString();
			 
		if(req.getSession().getAttribute("username") != null)
		{
			RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/home.jsp");
			view.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("login.jsp");
		}
	}
}
