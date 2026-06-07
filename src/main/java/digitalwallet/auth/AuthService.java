package digitalwallet.auth;

import java.util.HashMap;
import java.util.Map;

import digitalwallet.model.User;
import digitalwallet.model.UserFactory;

import digitalwallet.auth.validation.ValidationStrategy;
import digitalwallet.auth.validation.StrongPasswordStrategy;
import digitalwallet.auth.validation.SimpleEmailStrategy;

/**
 * Service handling registration and authentication.
 * Makes sure inputs are proper via Strategy validation and outputs via Factory creation.
 */
public class AuthService {
    
    // Simulates a user database
    private final Map<String, User> userDatabase = new HashMap<>();
    
    // Validation rules using the Strategy pattern
    private final ValidationStrategy passwordValidator = new StrongPasswordStrategy();
    private final ValidationStrategy emailValidator = new SimpleEmailStrategy();

    /**
     * Registers a user if the email and password are valid and the email is not already taken.
     * 
     * @param type     the type of user account (Standard, Business, Admin)
     * @param email    the registration email address
     * @param password the account password
     * @return true if registration succeeded, false otherwise
     */
    public boolean register(String type, String email, String password) {
        if (!emailValidator.isValid(email)) {
            System.out.println("Registration Failed: Invalid email format.");
            return false;
        }

        if (!passwordValidator.isValid(password)) {
            System.out.println(
            	"Registration Failed: Password needs to contain 8+ characters, and at least 1 digit, " +
            	"1 uppercase letter, 1 lowercase letter, 1 symbol, and cannot contain any whitespace."
            );
            return false;
        }

        if (userDatabase.containsKey(email)) {
            System.out.println("Registration Failed: An account with this email already exists.");
            return false;
        }

        try {
            User newUser = UserFactory.createUser(type, email, password);
            userDatabase.put(email, newUser);
            System.out.println("Successfully registered " + type + " account: " + email);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Registration Failed: " + e.getMessage());
            return false;
        }
    }

    /**
     * Authenticates a user against stored data.
     * 
     * @param email    the email address entered by the user
     * @param password the password entered by the user
     * @return the verified User instance, or null if verification fails
     */
    public User login(String email, String password) {
        User user = userDatabase.get(email);
        
        // Protect against null pointer exceptions if the email doesn't exist
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Authentication successful for " + email);
            return user;
        }
        
        System.out.println("Authentication Failed: Invalid credentials.");
        return null;
    }
}