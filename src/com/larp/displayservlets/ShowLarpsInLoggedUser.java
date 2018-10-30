package com.larp.displayservlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.larp.ejbs.UserService;
import com.larp.models.Larp;

/**
 * Servlet implementation class ShowLarpsInUser
 */
@WebServlet("/ShowLarpsInLoggedUser")
public class ShowLarpsInLoggedUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserService us;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowLarpsInLoggedUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		RequestDispatcher view = null;
		if (session != null) {
			Integer user_id = (Integer) session.getAttribute("user_id");
			List<Larp> larp_list = (List<Larp>) us.getLarpsInUser(user_id);
			request.setAttribute("larp_list", larp_list);
			view = request.getRequestDispatcher("WEB-INF/views/larp_list_manage_player.jsp");
			
		} else {
			String message = "You are NOT LOGGED IN...";
			request.setAttribute("message", message);
			view = request.getRequestDispatcher("login.jsp");
		}
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
