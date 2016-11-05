package org.nero.click.sso.exceptions.user;

import org.nero.click.sso.exceptions.UserException;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-10-5
 * time: 下午3:11.
 */
public class TimeOutException extends UserException {
    public TimeOutException(String message) {
        super(message);
    }

    public TimeOutException() {
        super();
    }

    public TimeOutException(String message, Throwable cause) {
        super(message, cause);
    }
}
