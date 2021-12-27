package com.cdp.amazonNeptune.exception;

public class SigV4PropertiesNotFoundException extends RuntimeException {
    /**
     * @param message the error message.
     */
    public SigV4PropertiesNotFoundException(final String message) {
        super(message);
    }

    /**
     * @param message the error message.
     * @param cause the root cause exception.
     */
    public SigV4PropertiesNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
