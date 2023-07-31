package pro.sky.skyprodemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAddedEx extends RuntimeException{
    public EmployeeAlreadyAddedEx(String message) {
        super(message);
    }
}
