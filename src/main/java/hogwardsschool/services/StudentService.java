package hogwardsschool.services;

import hogwardsschool.exceptions.NoFacultyExistException;
import hogwardsschool.exceptions.NoStudentExistException;
import hogwardsschool.exceptions.StudentAlreadyExistException;
import hogwardsschool.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    Map<Long, Student> studentMap = new HashMap<>();
    Long id = 0L;

    public Student addStudent(Student temp) {
        for(Student actual : studentMap.values()) {
            if(actual.getName().equals(temp.getName()) && actual.getAge() == temp.getAge()) {
                throw new StudentAlreadyExistException("e");
            }
        }
        temp.setId(++id);
        studentMap.put(id, temp);
        return temp;
    }

    public void daleteStudent(Long id) {
        if(!studentMap.containsKey(id)) {
            throw new NoStudentExistException("e");
        }
        studentMap.remove(id);
    }

    public Student findStudent(Long id) {
        return studentMap.get(id);
    }

    public Student editStudent(Student temp) {
        Set<Long> keys = studentMap.keySet();
        for(Long key : keys) {
            if(temp.equalName(studentMap.get(key))) {
                temp.setId(key);
                studentMap.put(key, temp);
                break;
            } else { throw new NoStudentExistException("e"); }
        }
        return temp;
    }

    public Collection<Student> allStudents() {
        return Collections.unmodifiableCollection(studentMap.values());
    }

    public Collection<Student> studentsByAge(int age) {
        Collection<Student> result = new HashSet<>();
        for (Student actual : studentMap.values()) {
            if (age == actual.getAge()) {
                result.add(actual);
            }
        }
        return Collections.unmodifiableCollection(result);
    }
}
