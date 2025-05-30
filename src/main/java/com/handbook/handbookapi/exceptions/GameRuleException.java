package com.handbook.handbookapi.exceptions;

/**
 * Exception thrown when a game rule is violated.
 * This exception is used to indicate that a specific game rule has been broken,
 * and it can be used to provide feedback to the user or log the violation.
 */
public class GameRuleException extends RuntimeException {

    public GameRuleException(String message) {
        super(message);
    }

    public GameRuleException(String message, Throwable cause) {
        super(message, cause);
    }
}
