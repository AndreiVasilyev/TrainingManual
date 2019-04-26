package by.bobruisk.trainingmanual.data;

public class Login {

	private static final String USER = "Admin";
	private static final String PASSWORD = "Admin";

	public static boolean authenticate(String username, String password) {
		if (USER.equals(username) && PASSWORD.equals(password)) {
			return true;
		}
		return false;
	}
}