package com.larp.displayservlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

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
 * Servlet implementation class EditLarpForm
 */
@WebServlet("/EditLarpForm")
public class EditLarpForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	LarpService ls;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditLarpForm() {
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
		RequestDispatcher view = request.getRequestDispatcher("ManageLarpsListAdminPanel");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String larp_id = request.getParameter("larp_id");
		Larp l = ls.getLarp(larp_id);
		Date larptime = l.getLarpTime();
		Calendar cal = Calendar.getInstance();
		cal.setTime(larptime);

		int larpyear = cal.get(Calendar.YEAR);
		int larpmonth = cal.get(Calendar.MONTH);
		int larpday = cal.get(Calendar.DAY_OF_MONTH);
		larpmonth = ++larpmonth;
		int larphour = cal.get(Calendar.HOUR_OF_DAY);
		int larpminute = cal.get(Calendar.MINUTE);
		String monthS = String.valueOf(larpmonth);
		String dayS = String.valueOf(larpday);

		if (monthS.length() == 1) {
			monthS = "0" + monthS;
		}

		if (dayS.length() == 1) {
			dayS = "0" + dayS;
		}

		String date_in_form = monthS + "/" + dayS + "/" + String.valueOf(larpyear);

		request.setAttribute("date_in_form", date_in_form);
		request.setAttribute("larp_year", larpyear);
		request.setAttribute("larp_month", larpmonth);
		request.setAttribute("larp_day", larpday);
		request.setAttribute("larp_hour", larphour);
		request.setAttribute("larp_minute", larpminute);
		request.setAttribute("chosen_larp", l);

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/edit_larp_admin.jsp");
		view.forward(request, response);
	}

}
