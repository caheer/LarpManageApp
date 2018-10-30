package com.larp.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.larp.security.PasswordHashing;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);

		try {
			Integer user_id = (Integer) session.getAttribute("user_id");
		} catch (NullPointerException e) {
			String message = "You are NOT LOGGED IN or have no access rights to this page...";
			request.setAttribute("message", message);
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		}

		String userstatus = (String) session.getAttribute("userstatus");

		RequestDispatcher view = null;
		if (userstatus.equals("Admin")) {
			view = request.getRequestDispatcher("WEB-INF/views/admin_panel.jsp");
		} else {
			view = request.getRequestDispatcher("WEB-INF/views/player_player.jsp");
		}

		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String message = null;

		PasswordHashing hash_p = new PasswordHashing();
		String user_login = request.getParameter("user_login");
		String password = hash_p.hash_password(request.getParameter("password"));

		if (LoginDao.validate(user_login, password)) {

			Integer user_id = LoginDao.getUserId(user_login, password);
			String userstatus = LoginDao.getUserStatus(user_login, password);
			HttpSession session = request.getSession();
			session.setAttribute("user_login", user_login);
			session.setAttribute("user_id", user_id);
			session.setAttribute("userstatus", userstatus);

			if (userstatus.equals("Admin")) {
				request.getRequestDispatcher("/ShowAdminPanel").forward(request, response);
			} else {
				request.getRequestDispatcher("/ShowPlayerPanel").forward(request, response);
			}
		} else {
			message = "LOGIN FAILED";
			request.setAttribute("message", message);
			request.getRequestDispatcher("login.jsp").include(request, response);
		}

		out.close();
	}

}
