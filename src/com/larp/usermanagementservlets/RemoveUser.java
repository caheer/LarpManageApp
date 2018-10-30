package com.larp.usermanagementservlets;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.larp.ejbs.LarpService;
import com.larp.ejbs.RegistrationService;
import com.larp.ejbs.UserService;
import com.larp.models.LarpRegistration;

/**
 * Servlet implementation class RemovePlayer
 */
@WebServlet("/RemoveUser")
public class RemoveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserService us;

	@EJB
	RegistrationService rs;

	@EJB
	LarpService ls;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveUser() {
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
		request.getRequestDispatcher("ManageUsersListAdminPanel").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String uid = request.getParameter("user_id");

		try {
			Integer.parseInt(request.getParameter("user_id"));
		} catch (NullPointerException e) {
			response.sendRedirect("ManageUsersListAdminPanel");
			return;
		} catch (NumberFormatException e) {
			response.sendRedirect("ManageUsersListAdminPanel");
			return;
		}

		List<LarpRegistration> lrList = (List<LarpRegistration>) rs.getLarpRegistrations();

		for (Integer i = 0; i < lrList.size(); i++) {

			String u_id = String.valueOf(lrList.get(i).getId_user().getId());
			String l_id = String.valueOf(lrList.get(i).getId_larp().getId());
			if (uid.equals(u_id)) {
				ls.removeUserFromLarp(u_id, l_id);
				String r_id = String.valueOf(lrList.get(i).getId());
				rs.removeLarpRegistration(r_id);
			}

		}

		us.removeUser(uid);

		request.getRequestDispatcher("ManageUsersListAdminPanel").include(request, response);

	}

	private int parseInt(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
