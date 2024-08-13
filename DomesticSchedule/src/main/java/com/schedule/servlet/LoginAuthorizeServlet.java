package com.schedule.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.schedule.app.Account;
import com.schedule.exception.ServiceException;
import com.schedule.service.AccountManager;
import com.schedule.service.LogManager;
import com.schedule.service.TimeManager;

/**
 * Servlet implementation class LoginAuthorize
 */
@WebServlet("/loginAuthorize")
public class LoginAuthorizeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAuthorizeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("account_id");
		String password = request.getParameter("account_password");

		HttpSession session = request.getSession();
		AccountManager am = new AccountManager();
		Account account = new Account();
		try {
			account = am.findAccount(id);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		account.isValid();
		//アカウントが存在しない場合
		if (!account.isAuthorized()) {
			session.setAttribute("loginMsg", "IDもしくはパスワードが違います");
			LogManager.print("ERROR:指定のIDのアカウントが存在しませんでした(ID:" + id + ")");
			response.sendRedirect(request.getContextPath() + "/page/login.jsp");
			return;
		}

		//アカウントは存在するがパスワードが異なる場合
		if (!account.getPassword().equals(password)) {
			session.setAttribute("loginMsg", "IDもしくはパスワードが違います");
			LogManager.print("ERROR:指定のアカウントとパスワードが一致しませんでした(ID:" + id + "," + "PS:" + password + ")");
			response.sendRedirect(request.getContextPath() + "/page/login.jsp");
			return;
		}

		session.setAttribute("account", account);
		session.setAttribute("greeting", TimeManager.getGreeting());
		LogManager.print("SUCCESS:以下のIDでアカウントにログインされました(ID:" + id + ")");
		response.sendRedirect(request.getContextPath() + "/page/menu.jsp");
	}

}
