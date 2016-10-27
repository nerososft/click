package org.nero.click.exception.user;

import org.nero.click.exception.UserException;

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
