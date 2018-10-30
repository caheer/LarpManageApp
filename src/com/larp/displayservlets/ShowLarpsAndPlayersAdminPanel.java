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
import javax.servlet.http.HttpSession;
import com.larp.ejbs.LarpService;
import com.larp.models.Larp;
import com.larp.security.LoginValidator;

/**
 * Servlet implementation class ShowLarps
 */
@WebServlet("/ShowLarpsAndPlayersAdminPanel")
public class ShowLarpsAndPlayersAdminPanel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	LarpService ls;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowLarpsAndPlayersAdminPanel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		String userstatus = null;
		LoginValidator lv = new LoginValidator();
		RequestDispatcher view = null;
		
		try
		{userstatus = (String) session.getAttribute("userstatus");
		}catch(NullPointerException e) {
			String message = "You are NOT LOGGED IN or have no access rights to this page...";
			request.setAttribute("message", message);
			view = request.getRequestDispatcher("login.jsp");
		}
			
		if ((lv.isAdmin(session, userstatus)) == false){
			String message = "You have no access rights to this page...";
			request.setAttribute("message", message);
			view = request.getRequestDispatcher("login.jsp");
			
			
		} else
		{
			List<Larp> lList = (List<Larp>)ls.getLarps(); //cast it to List just in case
			request.setAttribute("larp_list", lList);
			view = request.getRequestDispatcher("WEB-INF/views/manage_reg_larplist_admin.jsp");
		}
		
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
