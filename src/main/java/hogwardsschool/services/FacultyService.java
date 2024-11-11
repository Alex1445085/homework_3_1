package hogwardsschool.services;

import hogwardsschool.exceptions.FacultyAlreadyExistException;
import hogwardsschool.exceptions.NoFacultyExistException;
import hogwardsschool.exceptions.NoStudentExistException;
import hogwardsschool.model.Faculty;
import hogwardsschool.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FacultyService {
    private final Map<Long, Faculty> facultyMap = new HashMap<>();
    Long id = 0L;

    public Faculty addFaculty(Faculty temp) {
        temp.setId(++id);
        for (Faculty actual : facultyMap.values()) {
            if (actual.getName().equals(temp.getName()) &&
                    actual.getColor().equals(temp.getColor())) {
                throw new FacultyAlreadyExistException("e");
            }
        }
        facultyMap.put(id, temp);
        return temp;
    }

    public void deleteFaculty(Long id) {
        if (!facultyMap.containsKey(id)) {
            throw new NoFacultyExistException("e");
        }
        facultyMap.remove(id);
    }

    public Faculty findFaculty(Long id) {
        return facultyMap.get(id);
    }

    public Faculty editFaculty(Faculty temp) {
        Set<Long> keys = facultyMap.keySet();
        for (Long key : keys) {
            if (temp.equalName(facultyMap.get(key))) {
                temp.setId(key);
                facultyMap.replace(key, temp);
                break;
            } else { throw new NoFacultyExistException("e"); }
        }
        return temp;
    }

    public Collection<Faculty> allFaculty() {
        return Collections.unmodifiableCollection(facultyMap.values());
    }

    public Collection<Faculty> facultyByColor(String color) {
        Collection<Faculty> result = new HashSet<>();
        for (Faculty actual : facultyMap.values()) {
            if (color.equals(actual.getColor())) {
                result.add(actual);
            }
        }
        return Collections.unmodifiableCollection(result);
    }
}
