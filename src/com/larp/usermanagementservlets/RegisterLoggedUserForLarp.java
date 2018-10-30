package com.larp.usermanagementservlets;

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
import com.larp.ejbs.LarpService;
import com.larp.ejbs.RegistrationService;
import com.larp.ejbs.UserService;
import com.larp.models.Larp;

/**
 * Servlet implementation class RegisterUserForLarp
 */
@WebServlet("/RegisterLoggedUserForLarp")
public class RegisterLoggedUserForLarp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	RegistrationService rs;

	@EJB
	LarpService ls;

	@EJB
	UserService us;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterLoggedUserForLarp() {
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
		RequestDispatcher view = request.getRequestDispatcher("ShowLarpsInLoggedUser");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		Integer user_id = (Integer) session.getAttribute("user_id");
		String uid = String.valueOf(user_id);
		String lid = request.getParameter("larp_id");
		List<Larp> larp_list = (List<Larp>) us.getLarpsInUser(user_id);

		String message = null;

		Larp l = ls.getLarp(lid);
		Integer currentusers = l.getCurrent_participants_no();
		Integer maxusers = l.getMax_participants_no();

		if (currentusers < maxusers) {
			for (Larp larp : larp_list) {
				if (lid.equals(String.valueOf(larp.getId()))) {
					message = "You are already registered for this game!";
					request.setAttribute("message", message);
					request.getRequestDispatcher("ShowPlayerRegistrationPanel").forward(request, response);
					return;

				}
			}
			message = "You are now registered for this game!";
			request.setAttribute("message", message);
			rs.addLarpRegistration(uid, lid);
			ls.addUserToLarp(uid, lid);
			request.getRequestDispatcher("ShowPlayerRegistrationPanel").forward(request, response);
			return;
		} else {
			message = "Max number of users has already been reached, you cannot register for this game!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("ShowPlayerRegistrationPanel").forward(request, response);

		}

	}

}
