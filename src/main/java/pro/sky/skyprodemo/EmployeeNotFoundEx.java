package pro.sky.skyprodemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundEx extends RuntimeException {
    public EmployeeNotFoundEx(String message) {
        super(message);
    }
}
