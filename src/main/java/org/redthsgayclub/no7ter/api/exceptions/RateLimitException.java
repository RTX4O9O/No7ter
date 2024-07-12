package org.redthsgayclub.no7ter.api.exceptions;

public class RateLimitException extends ApiException {

    public RateLimitException(String message) {
        super(message);
    }

}
