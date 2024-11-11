package hogwardsschool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "FacultyAlreadyExistException")
public class FacultyAlreadyExistException extends RuntimeException {
    public FacultyAlreadyExistException(String note) {
        super("FacultyAlreadyExistException = " + note);
    }
}