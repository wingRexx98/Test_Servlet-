package util;

public class Constrants {
	public static final String REGEX_PHONE_NUMBER = "^//d{9}*$";
	public static final String REGEX_EMAIL="^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
	public static final String REGEX_DoB ="^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$";
	public static final String REGEX_NAME = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
}
