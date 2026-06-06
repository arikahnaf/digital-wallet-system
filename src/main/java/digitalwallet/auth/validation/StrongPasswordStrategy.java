package digitalwallet.auth.validation;

/**
 * Concrete strategy that enforces strong password rules.
 */
public class StrongPasswordStrategy implements ValidationStrategy {

	/*
	 * 8+ characters, and contains at least:
	 * 		- 1 digit 
	 * 		- 1 lowercase letter
	 * 		- 1 uppercase letter
	 * 		- 1 symbol
	 * 		- no whitespace.
	 */
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!_])(?=\\S+$).{8,}$";

    @Override
    public boolean isValid(String password) {
        if (password == null) {
            return false;
        }
        return password.matches(PASSWORD_REGEX);
    }
}