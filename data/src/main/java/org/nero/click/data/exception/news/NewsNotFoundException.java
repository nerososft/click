package org.nero.click.data.exception.news;

/**
 * Created by nero on 2016/10/14 0014.
 */
public class NewsNotFoundException extends RuntimeException {
    public NewsNotFoundException() {
        super();
    }

    public NewsNotFoundException(String message) {
        super(message);
    }

    public NewsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewsNotFoundException(Throwable cause) {
        super(cause);
    }

    protected NewsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
