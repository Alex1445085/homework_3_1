package hogwardsschool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "NoStudentExistException")
public class NoStudentExistException extends RuntimeException {
    public NoStudentExistException(String note) { super("NoStudentExistException = " + note); }
}
