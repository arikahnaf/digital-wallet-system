package digitalwallet.model;

public class UserFactory {

	/**
	 * Creates a User object based on the provided userType string.
	 * 
	 * @param userType the type of user (Standard, Business, Admin)
	 * @param email    the user's unique email
	 * @param password the user's valid password
	 * @return a concrete subclass of User
	 * @throws IllegalArgumentException if an unknown user type is provided
	 */
	public static User createUser(String userType, String email, String password) {
		if (userType == null) {
			throw new IllegalArgumentException("User type cannot be null");
		}

		return switch (userType.toLowerCase()) {
		case "standard" -> new StandardUser(email, password);
		case "business" -> new BusinessUser(email, password);
		case "admin" -> new AdminUser(email, password);
		default -> throw new IllegalArgumentException("Unknown user type: " + userType);
		};
	}
}
