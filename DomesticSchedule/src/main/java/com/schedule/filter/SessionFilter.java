package com.schedule.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.schedule.app.Account;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/*")
public class SessionFilter extends HttpFilter implements Filter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public SessionFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Account account = (Account) session.getAttribute("account");

		//ログイン時、新規作成時は除外
		//		if (req.getRequestURI().contains("login") || req.getRequestURI().contains("regist")) {
		//			chain.doFilter(request, response);
		//			return;
		//		}
		//
		//		if (account == null) { //セッション切れの場合
		//			session.setAttribute("loginMsg", "セッションが切れました");
		//			res.sendRedirect(req.getContextPath() + "/page/login.jsp");
		//		} else {//セッション復活したとき
		//			session.setAttribute("loginMsg", "");
		//		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
