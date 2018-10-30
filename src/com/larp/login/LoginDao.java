package com.larp.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	static String url = "jdbc:derby://localhost:1527/";
	static String dbName = "larp_db";
	static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	static String userName = "Larp";
	static String password = "Larp";

	public static boolean validate(String user_login, String pass) {
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			pst = conn.prepareStatement("select * from APPUSER where LOGIN=? and password=?");
			pst.setString(1, user_login);
			pst.setString(2, pass);

			rs = pst.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return status;
	}

	public static Integer getUserId(String user_login, String pass) {
		Integer user_id = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			pst = conn.prepareStatement("select user_id from APPUSER where LOGIN=? and password=?");
			pst.setString(1, user_login);
			pst.setString(2, pass);

			rs = pst.executeQuery();

			while (rs.next()) {
				user_id = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user_id;
	}

	public static String getUserStatus(String user_login, String pass) {
		String userstatus = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			pst = conn.prepareStatement("select userstatus from APPUSER where LOGIN=? and password=?");
			pst.setString(1, user_login);
			pst.setString(2, pass);

			rs = pst.executeQuery();

			while (rs.next()) {
				userstatus = rs.getString(1);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userstatus;
	}
}