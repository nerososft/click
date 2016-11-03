package org.nero.click.sso.exceptions.user;

import org.nero.click.sso.exceptions.UserException;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-5
 * time: 下午3:32.
 */
public class ActiveException extends UserException {
    public ActiveException(String message) {
        super(message);
    }

    public ActiveException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActiveException() {
        super();
    }
}
