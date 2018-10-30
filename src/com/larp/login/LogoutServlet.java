package com.larp.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		String message = null;
		if (session == null) {
			message = "You are not logged in!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").include(request, response);
		} else {
			message = "Logged out!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").include(request, response);
			session.invalidate();
		}
	}
}
