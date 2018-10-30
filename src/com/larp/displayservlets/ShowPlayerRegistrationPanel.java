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

import com.larp.ejbs.LarpService;
import com.larp.models.Larp;

/**
 * Servlet implementation class ShowPlayerRegistrationPanel
 */
@WebServlet("/ShowPlayerRegistrationPanel")
public class ShowPlayerRegistrationPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	LarpService ls;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowPlayerRegistrationPanel() {
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

		List<Larp> lList = (List<Larp>) ls.getActiveLarps();
		request.setAttribute("larp_list", lList);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/larp_list_register_player.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
