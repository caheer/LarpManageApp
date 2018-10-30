package com.larp.usermanagementservlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.larp.ejbs.UserService;
import com.larp.models.AppUser;
import com.larp.models.Gender;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser_Admin_Player")
public class EditUser_Admin_Player extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserService us;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUser_Admin_Player() {
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
		AppUser u = us.getUser(String.valueOf(user_id));

		String fName = request.getParameter("first_name");
		String lName = request.getParameter("last_name");
		String nickname = request.getParameter("nickname");
		String emailaddr = request.getParameter("email");
		String gender = request.getParameter("gender");

		u.setFirstName(fName);
		u.setLastName(lName);
		u.setNickname(nickname);
		u.setEmail(emailaddr);
		u.setGender(Gender.valueOf(gender));

		us.editUser(u);

		response.sendRedirect("ViewUserForm_Admin_Player");
	}

}
