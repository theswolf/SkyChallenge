package uk.sky.challenge.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Problem retrieving data")
public class NotFoundError extends Exception{

    public NotFoundError(String message) {
        super(message);
    }
}
