package com.larp.security;

import javax.servlet.http.HttpSession;

public class LoginValidator {

	public boolean isAdmin(HttpSession session, String userstatus) {
		if (userstatus == null) {
			return false;
		}

		if (session == null) {
			return false;
		}
		if (!userstatus.equals("Admin")) {
			return false;
		}

		return true;

	}

	public boolean isPlayer(HttpSession session, String userstatus) {
		if (userstatus == null) {
			return false;
		}

		if (session == null) {
			return false;
		}
		if (!userstatus.equals("Player")) {
			return false;
		}

		return true;

	}
}
