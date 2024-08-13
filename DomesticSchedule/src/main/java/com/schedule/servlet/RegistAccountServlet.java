package com.schedule.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

/**
 * Servlet implementation class RegistAccount
 */
@WebServlet("/registAccount")
public class RegistAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistAccountServlet() {
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
		String name = request.getParameter("username");
		String id = request.getParameter("user_id");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");

		System.out.println("ログイン認証");

		AccountManager am = new AccountManager();
		try {
			Account account = am.findAccount(id);
			account.isValid();
			System.out.println(account);
			//存在するアカウントなら認証済み
			if (account.isAuthorized()) {
				request.setAttribute("message", "すでにそのIDは使用されています");
				LogManager.print("ERROR:既存のIDで新規作成を試みました(ID:" + id + ")");
				RequestDispatcher rd = request.getRequestDispatcher("/page/regist.jsp");
				rd.forward(request, response);
				return;
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		if (!password1.equals(password2)) {
			request.setAttribute("message", "パスワードが一致していません");
			LogManager.print("ERROR:登録用の2つのパスワードが一致しませんでした");
			RequestDispatcher rd = request.getRequestDispatcher("/page/regist.jsp");
			rd.forward(request, response);
			return;
		}

		Account account = new Account();
		account.setId(id);
		account.setPassword(password1);
		account.setUsername(name);
		try {
			am.registAccount(account);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		session.setAttribute("account", account);

		response.sendRedirect(request.getContextPath() + "/page/menu.jsp");
		return;

	}

}
