package hogwardsschool.controllers;

import hogwardsschool.model.Faculty;
import hogwardsschool.model.Student;
import hogwardsschool.services.FacultyService;
import hogwardsschool.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    public final StudentService servStudent;
    public StudentController(StudentService servStudent) { this.servStudent = servStudent; }

    @GetMapping("{id}")
        public Student findStudent(@PathVariable Long id) {
            return servStudent.findStudent(id);
        }

        @PostMapping
        public Student addStudent(Student student) {
            return servStudent.addStudent(student);
        }

        @PutMapping
        public Student editStudent(Student student) {
            return servStudent.editStudent(student);
        }

        @DeleteMapping("{id}")
        public String deleteStudent(@PathVariable Long id) {
            servStudent.daleteStudent(id);
            return "Success, student with id# " + id + " deleted.";
        }
        @GetMapping
        public Collection<Student> allStudents() {
            return servStudent.allStudents();
        }

        @GetMapping("/age/{age}")
        public Collection<Student> studentsByAge(@PathVariable int age) {
            return servStudent.studentsByAge(age);
        }
    }
