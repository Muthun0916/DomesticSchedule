package com.schedule.service;

import com.schedule.app.Account;
import com.schedule.dao.AccountDao;
import com.schedule.exception.DaoException;
import com.schedule.exception.ServiceException;

public class AccountManager {

	public Account findAccount(String id) throws ServiceException {
		AccountDao dao = new AccountDao();
		Account account;
		try {
			account = dao.findAccountById(id);
		} catch (DaoException e) {
			throw new ServiceException("サービス関連エラー", e);
		}
		return account;
	}

	public Account registAccount(Account account) throws ServiceException {
		AccountDao dao = new AccountDao();
		try {
			dao.registAccount(account);
		} catch (DaoException e) {
			throw new ServiceException("サービス関連エラー", e);
		}
		return account;
	}

}
