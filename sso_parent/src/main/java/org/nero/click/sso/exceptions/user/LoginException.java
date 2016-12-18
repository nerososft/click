package org.nero.click.sso.exceptions.user;

import org.nero.click.sso.exceptions.UserException;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-1
 * time: 下午2:31.
 */
public class LoginException extends UserException {
    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException() {
        super();
    }
}
