package digitalwallet.auth.validation;

/**
 * Concrete strategy that validates if a string is a properly formatted email address.
 */
public class SimpleEmailStrategy implements ValidationStrategy {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    @Override
    public boolean isValid(String email) {
        if (email == null) {
            return false;
        }
        return email.matches(EMAIL_REGEX);
    }
}