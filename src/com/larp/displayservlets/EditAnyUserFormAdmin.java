package com.larp.displayservlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.larp.ejbs.UserService;
import com.larp.models.AppUser;

/**
 * Servlet implementation class EditLarpForm
 */
@WebServlet("/EditAnyUserFormAdmin")
public class EditAnyUserFormAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserService us;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditAnyUserFormAdmin() {
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
		RequestDispatcher view = request.getRequestDispatcher("ManageUsersListAdminPanel");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			Integer.parseInt(request.getParameter("user_id"));
		} catch (NullPointerException e) {
			response.sendRedirect("ManageUsersListAdminPanel");
			return;
		} catch (NumberFormatException e) {
			response.sendRedirect("ManageUsersListAdminPanel");
			return;
		}

		Integer user_id = Integer.valueOf(request.getParameter("user_id"));
		AppUser u = us.getUser(String.valueOf(user_id));
		request.setAttribute("chosen_user", u);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/edit_user_any_admin.jsp");
		view.forward(request, response);
	}

}
