package com.larp.larpmanagementservlets;

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
 * Servlet implementation class RemoveLarp
 */
@WebServlet("/RemoveLarp")
public class RemoveLarp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	LarpService ls;

	@EJB
	UserService us;

	@EJB
	RegistrationService rs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveLarp() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String lid = request.getParameter("larp_id");

		try {
			Integer.parseInt(request.getParameter("larp_id"));
		} catch (NullPointerException e) {
			response.sendRedirect("ManageLarpsListAdminPanel");
			return;
		} catch (NumberFormatException e) {
			response.sendRedirect("ManageLarpsListAdminPanel");
			return;
		}

		List<LarpRegistration> lrList = (List<LarpRegistration>) rs.getLarpRegistrations();

		for (Integer i = 0; i < lrList.size(); i++) {

			String u_id = String.valueOf(lrList.get(i).getId_user().getId());
			String l_id = String.valueOf(lrList.get(i).getId_larp().getId());
			if (lid.equals(l_id)) {
				us.removeLarpFromUser(u_id, l_id);
				String r_id = String.valueOf(lrList.get(i).getId());
				rs.removeLarpRegistration(r_id);
			}

		}

		ls.removeLarp(lid);

		response.sendRedirect("ManageLarpsListAdminPanel");

	}

}
