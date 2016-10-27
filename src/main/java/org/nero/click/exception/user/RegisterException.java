package org.nero.click.exception.user;

import org.nero.click.exception.UserException;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-1
 * time: 下午2:32.
 */
public class RegisterException extends UserException {
    public RegisterException(String message) {
        super(message);
    }

    public RegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegisterException() {
        super();
    }
}
