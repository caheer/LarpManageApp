package com.larp.TESTONLY;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.larp.ejbs.LarpService;
import com.larp.ejbs.UserService;
import com.larp.models.Gender;
import com.larp.models.Larp;
import com.larp.models.LarpRegistrStatus;
import com.larp.models.AppUser;
import com.larp.models.UserStatus;
import com.larp.security.PasswordHashing;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddTestUsers")
public class AddTestUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UserService us;

	@EJB
	LarpService ls;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTestUsers() {
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
		PasswordHashing hash_p = new PasswordHashing();
		AppUser au = new AppUser();
		String login = "player";
		String password = hash_p.hash_password("qwerty");
		String fName = "Jacek";
		String lName = "Placek";
		String nickname = "nick";
		String emailaddr = "email@email.com";

		au.setLogin(login);
		au.setPassword(password);
		au.setFirstName(fName);
		au.setLastName(lName);
		au.setNickname(nickname);
		au.setEmail(emailaddr);
		au.setGender(Gender.Male);
		au.setUserstatus(UserStatus.Player);

		us.addUser(au);

		AppUser au2 = new AppUser();

		login = "admin";
		password = hash_p.hash_password("qwerty");
		fName = "Jacek";
		lName = "Placek";
		nickname = "nick";
		emailaddr = "email@email.com";

		au2.setLogin(login);
		au2.setPassword(password);
		au2.setFirstName(fName);
		au2.setLastName(lName);
		au2.setNickname(nickname);
		au2.setEmail(emailaddr);
		au2.setGender(Gender.Male);
		au2.setUserstatus(UserStatus.Admin);

		us.addUser(au2);

		Larp l1 = new Larp();
		Larp l2 = new Larp();

		String Larp_title = "larp_title";
		String Larp_descr = "larp_descr";
		String Larp_place = "larp_place";
		String Larp_authors = "larp_authors";
		String Larp_cur_partic = "5";
		String Larp_max_partic = "15";
		String hourS = "12";
		String minuteS = "30";
		Integer year = 2017;
		Integer month = 12;
		Integer day = 15;
		Integer hour = Integer.parseInt(hourS);
		Integer minute = Integer.parseInt(minuteS);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		Date larptime = cal.getTime();

		l1.setLarpTitle(Larp_title);
		l1.setLarpDescription(Larp_descr);
		l1.setLarpPlace(Larp_place);
		l1.setLarp_authors(Larp_authors);
		l1.setLarp_reg_stat(LarpRegistrStatus.Registration_active);
		l1.setCurrent_participants_no(Integer.parseInt(Larp_cur_partic));
		l1.setMax_participants_no(Integer.parseInt(Larp_max_partic));
		l1.setLarpTime(larptime);

		ls.addLarp(l1);

		l2.setLarpTitle(Larp_title);
		l2.setLarpDescription(Larp_descr);
		l2.setLarpPlace(Larp_place);
		l2.setLarp_authors(Larp_authors);
		l2.setLarp_reg_stat(LarpRegistrStatus.Registration_active);
		l2.setCurrent_participants_no(Integer.parseInt(Larp_cur_partic));
		l2.setMax_participants_no(Integer.parseInt(Larp_max_partic));
		l2.setLarpTime(larptime);

		ls.addLarp(l2);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
