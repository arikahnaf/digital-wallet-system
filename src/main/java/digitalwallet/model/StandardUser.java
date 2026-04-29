package digitalwallet.model;

public class StandardUser extends User {

	public StandardUser(String email, String password) {
		super(email, password);
	}

	@Override
	public String getUserType() {
		return "Standard";
	}
}
