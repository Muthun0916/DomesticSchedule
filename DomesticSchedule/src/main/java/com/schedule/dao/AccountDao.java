package com.schedule.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.schedule.app.Account;
import com.schedule.exception.DaoException;

public class AccountDao {

	private static final String SELECT_SQL = "SELECT * FROM ACCOUNT WHERE ACCOUNT_ID = ?;";
	private static final String INSERT_SQL = "INSERT INTO ACCOUNT (ACCOUNT_ID, ACCOUNT_PASSWORD, ACCOUNT_NAME) VALUES (?, ?, ?);";

	public Account findAccountById(String id) throws DaoException {

		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:h2:~/test";
		String user = "sa";
		String password = "";
		Account account = new Account();
		try (Connection con = DriverManager.getConnection(url, user, password);) {
			PreparedStatement ps = con.prepareStatement(SELECT_SQL);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				account.setId(id);
				account.setPassword(rs.getString("ACCOUNT_PASSWORD"));
				account.setUsername(rs.getString("ACCOUNT_NAME"));
			}

		} catch (SQLException e) {
			throw new DaoException("データベース関連エラー", e);
		}

		return account;
	}

	public void registAccount(Account account) throws DaoException {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		String url = "jdbc:h2:~/test";
		String user = "sa";
		String password = "";
		try (Connection con = DriverManager.getConnection(url, user, password);) {
			PreparedStatement ps = con.prepareStatement(INSERT_SQL);
			ps.setString(1, account.getId());
			ps.setString(2, account.getPassword());
			ps.setString(3, account.getUsername());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException("データベース関連エラー", e);
		}
	}

}
