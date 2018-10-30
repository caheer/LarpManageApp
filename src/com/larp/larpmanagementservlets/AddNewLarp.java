package com.larp.larpmanagementservlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.larp.ejbs.LarpService;
import com.larp.models.Larp;
import com.larp.models.LarpRegistrStatus;
import com.larp.security.InputValidator;

/**
 * Servlet implementation class AddNewLarp
 */
@WebServlet("/AddNewLarp")
public class AddNewLarp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	LarpService ls;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewLarp() {
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

		HttpSession session = request.getSession();
		String addedBy = (String) session.getAttribute("user_login");
		String Larp_title = request.getParameter("larp_title");
		String Larp_descr = request.getParameter("larp_descr");
		String Larp_place = request.getParameter("larp_place");
		String Larp_authors = request.getParameter("larp_authors");
		String Registr_status = request.getParameter("registr_status");
		String Larp_cur_partic = request.getParameter("larp_cur_partic");
		String Larp_max_partic = request.getParameter("larp_max_partic");
		String larpdate = request.getParameter("selDate");
		String hourS = request.getParameter("hour");
		String minuteS = request.getParameter("minute");

		InputValidator ivalNum = new InputValidator();

		if ((ivalNum.isInteger(hourS, minuteS, Larp_cur_partic, Larp_max_partic)) == false) {
			String message = ivalNum.getOutput();
			request.setAttribute("message", message);
			request.getRequestDispatcher("ManageLarpsNewLarpAdminPanel").include(request, response);
			return;
		}

		Integer year = Integer.parseInt(larpdate.substring(6, 10));
		Integer month = (Integer.parseInt(larpdate.substring(0, 2))) - 1;
		Integer day = Integer.parseInt(larpdate.substring(3, 5));
		Integer hour = Integer.parseInt(hourS);
		Integer minute = Integer.parseInt(minuteS);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);

		Date larptime = cal.getTime();

		Larp l = new Larp();

		l.setLarpTitle(Larp_title);
		l.setLarpDescription(Larp_descr);
		l.setLarpPlace(Larp_place);
		l.setLarp_authors(Larp_authors);
		l.setLarp_reg_stat(LarpRegistrStatus.valueOf(Registr_status));
		l.setCurrent_participants_no(Integer.parseInt(Larp_cur_partic));
		l.setMax_participants_no(Integer.parseInt(Larp_max_partic));
		l.setLarpTime(larptime);
		l.setAddedBy(addedBy);

		ls.addLarp(l);

		response.sendRedirect("ManageLarpsListAdminPanel");
	}

}
