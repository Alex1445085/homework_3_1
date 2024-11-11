package hogwardsschool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "NoFacultyExistException")
public class NoFacultyExistException extends RuntimeException {
    public NoFacultyExistException(String note) { super("NoFacultyExistException = " + note); }
}
