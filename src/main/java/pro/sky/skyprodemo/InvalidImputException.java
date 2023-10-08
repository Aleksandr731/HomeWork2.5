package pro.sky.skyprodemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidImputException extends RuntimeException {

    public InvalidImputException() {
    }

    public InvalidImputException(String message) {
        super(message);
    }

    public InvalidImputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidImputException(Throwable cause) {
        super(cause);
    }

    public InvalidImputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
