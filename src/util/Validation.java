package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public boolean isValidEmail(String email) {
		Pattern pattern = Pattern.compile(Constrants.REGEX_EMAIL);
		Matcher matches = pattern.matcher(email);
		return matches.matches();
	}

	public boolean isValidDoB(String dob) {
		Pattern pattern = Pattern.compile(Constrants.REGEX_DoB);
		Matcher matches = pattern.matcher(dob);
		return matches.matches();
	}

	public boolean isValidName(String name) {
		Pattern pattern = Pattern.compile(Constrants.REGEX_NAME);
		Matcher matches = pattern.matcher(name);
		return matches.matches();
	}
}
