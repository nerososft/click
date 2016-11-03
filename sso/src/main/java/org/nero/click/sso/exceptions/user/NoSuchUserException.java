package org.nero.click.sso.exceptions.user;
import org.nero.click.sso.exceptions.UserException;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-5
 * time: 下午2:47.
 */
public class NoSuchUserException extends UserException {
    public NoSuchUserException(String message) {
        super(message);
    }

    public NoSuchUserException() {
        super();
    }

    public NoSuchUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
