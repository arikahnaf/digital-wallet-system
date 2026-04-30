package digitalwallet.model;

public abstract class User {
	private String email;
	private String password;

	/**
	 * Indicates whether the user's account is frozen by an admin.
	 */
	private boolean accountFrozen;

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAccountFrozen() {
		return this.accountFrozen;
	}

	public void setAccountFrozen(boolean accountFrozen) {
		this.accountFrozen = accountFrozen;
	}

	/**
	 * Returns the type of user. User types are: Standard, Business, Admin.
	 * To be implemented by subclasses.
	 * 
	 * @return The user type as a string.
	 */
	public abstract String getUserType();
}