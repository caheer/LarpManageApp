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
import com.larp.models.Gender;
import com.larp.models.AppUser;
import com.larp.models.UserStatus;
import com.larp.security.PasswordHashing;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddNewUser")
public class AddNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserService us;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewUser() {
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
		RequestDispatcher view = request.getRequestDispatcher("ManageUsersNewUserAdminPanel");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PasswordHashing hash_p = new PasswordHashing();

		String login = request.getParameter("login");
		String emailaddr = request.getParameter("email");

		List<AppUser> auList = (List<AppUser>) us.getUsers();

		for (AppUser appuser : auList) {

			if (login.equals(appuser.getLogin())) {

				String message = "USER LOGIN ALREADY EXISTS, PLEASE PICK DIFFERENT LOGIN";
				request.setAttribute("message", message);
				request.getRequestDispatcher("ManageUsersNewUserAdminPanel").forward(request, response);
				return;
			}
		}

		for (AppUser appuser : auList) {
			if (emailaddr.equals(appuser.getEmail())) {

				String message = "EMAIL ALREADY EXISTS, PLEASE USE DIFFERENT EMAIL";
				request.setAttribute("message", message);
				request.getRequestDispatcher("ManageUsersNewUserAdminPanel").forward(request, response);
				return;
			}
		}

		String password = hash_p.hash_password(request.getParameter("password"));
		String fName = request.getParameter("first_name");
		String lName = request.getParameter("last_name");
		String nickname = request.getParameter("nickname");

		String gender = request.getParameter("gender");
		String userstatus = request.getParameter("userstatus");

		AppUser au = new AppUser();

		au.setLogin(login);
		au.setPassword(password);
		au.setFirstName(fName);
		au.setLastName(lName);
		au.setNickname(nickname);
		au.setEmail(emailaddr);
		au.setGender(Gender.valueOf(gender));
		au.setUserstatus(UserStatus.valueOf(userstatus));

		us.addUser(au);

		response.sendRedirect("ManageUsersListAdminPanel");
	}

}
