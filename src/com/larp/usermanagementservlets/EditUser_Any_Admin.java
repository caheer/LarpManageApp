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
import com.larp.ejbs.UserService;
import com.larp.models.AppUser;
import com.larp.models.Gender;
import com.larp.security.PasswordHashing;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser_Any_Admin")
public class EditUser_Any_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserService us;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUser_Any_Admin() {
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
		AppUser u = us.getUser(request.getParameter("user_id"));
		request.setAttribute("chosen_user", u);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/test/edit_user.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		AppUser u = us.getUser(request.getParameter("user_id"));
		PasswordHashing hash_p = new PasswordHashing();

		String login = request.getParameter("login");
		String emailaddr = request.getParameter("email");

		Integer user_id_int = Integer.valueOf(request.getParameter("user_id"));

		List<AppUser> auList = (List<AppUser>) us.getUsers();

		for (AppUser appuser : auList) {
			if (login.equals(appuser.getLogin()) && (user_id_int != appuser.getId())) {
				String message = "USER LOGIN ALREADY EXISTS, PLEASE PICK DIFFERENT LOGIN";
				request.setAttribute("message", message);
				request.getRequestDispatcher("ManageUsersListAdminPanel").forward(request, response);
				return;
			}
		}

		for (AppUser appuser : auList) {
			if (emailaddr.equals(appuser.getEmail()) && (user_id_int != appuser.getId())) {

				String message = "EMAIL ALREADY EXISTS, PLEASE USE DIFFERENT EMAIL";
				request.setAttribute("message", message);
				request.getRequestDispatcher("ManageUsersListAdminPanel").forward(request, response);
				return;
			}
		}

		String password = hash_p.hash_password(request.getParameter("password"));

		String fName = request.getParameter("first_name");
		String lName = request.getParameter("last_name");
		String nickname = request.getParameter("nickname");

		String gender = request.getParameter("gender");

		u.setLogin(login);
		u.setPassword(password);
		u.setFirstName(fName);
		u.setLastName(lName);
		u.setNickname(nickname);
		u.setEmail(emailaddr);
		u.setGender(Gender.valueOf(gender));

		us.editUser(u);

		response.sendRedirect("ManageUsersListAdminPanel");
	}

}
