package digitalwallet.model;

public class AdminUser extends User {

	public AdminUser(String email, String password) {
		super(email, password);
	}

	@Override
	public String getUserType() {
		return "Admin";
	}
}
