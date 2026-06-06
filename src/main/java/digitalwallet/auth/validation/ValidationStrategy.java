package digitalwallet.auth.validation;

/**
 * Strategy interface for user registration validation (unique email and strong password).
 */
public interface ValidationStrategy {

	/**
	 * Validates the given input string against a specific rule.
	 * 
	 * @param input the string to validate
	 * @return true if the input passes the validation criteria, false otherwise
	 */
	boolean isValid(String input);
}