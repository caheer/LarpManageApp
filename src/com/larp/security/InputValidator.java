package com.larp.security;

public class InputValidator {

	String output;
	boolean result;

	public boolean isInteger(String hour, String minute, String Larp_cur_partic, String larp_max_partic) {
		try {

			Integer.parseInt(hour);
			Integer.parseInt(minute);
			Integer.parseInt(Larp_cur_partic);
			Integer.parseInt(larp_max_partic);

		} catch (NumberFormatException e) {
			output = "Incorrect value was entered, please enter a correct number";
			result = false;
			return false;
		} catch (NullPointerException e) {
			output = "Incorrect value was entered, please enter a correct number";
			result = false;
			return false;
		}

		if (Integer.parseInt(hour) < 0 || Integer.parseInt(minute) < 0 || Integer.parseInt(Larp_cur_partic) < 0
				|| Integer.parseInt(larp_max_partic) < 0) {
			output = "One or more negative values, please enter a correct value";
			result = false;
			return false;
		}

		if (Integer.parseInt(hour) < 0 || Integer.parseInt(hour) > 23) {
			output = "Incorrect hour value, please enter a correct value (0-23)";
			result = false;
			return false;
		} else if (Integer.parseInt(minute) < 0 || Integer.parseInt(minute) >= 60) {
			output = "Incorrect minute value, please enter a correct value (0-59)";
			result = false;
			return false;
		}

		return true;
	}

	public boolean isNull(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			output = "NumberFormatException";
			result = false;
			return false;
		}
		return true;

	}

	public String getOutput() {
		return output;
	}

	public boolean getResult() {
		return result;
	}

}
