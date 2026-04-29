package digitalwallet.model;

public class BusinessUser extends User {

	public BusinessUser(String email, String password) {
		super(email, password);
	}

	@Override
	public String getUserType() {
		return "Business";
	}

}
