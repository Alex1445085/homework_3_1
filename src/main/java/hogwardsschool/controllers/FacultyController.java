package hogwardsschool.controllers;

import hogwardsschool.model.Faculty;
import hogwardsschool.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    public final FacultyService servFaculty;
    public FacultyController(FacultyService servFaculty) { this.servFaculty = servFaculty; }

    @GetMapping("{id}")
    public Faculty findFaculty(@PathVariable Long id) {
        return servFaculty.findFaculty(id);
    }

    @PostMapping
    public Faculty addFaculty(Faculty faculty) {
        return servFaculty.addFaculty(faculty);
    }

    @PutMapping
    public Faculty editFaculty(Faculty faculty) {
        return servFaculty.editFaculty(faculty);
    }

    @DeleteMapping("{id}")
    public String deleteFaculty(@PathVariable Long id) {
        servFaculty.deleteFaculty(id);
        return "Success, faculty with id#" + id + " deleted.";
    }
    @GetMapping
    public Collection<Faculty> allFaculty() {
        return servFaculty.allFaculty();
    }

    @GetMapping("/color/{color}")
    public Collection<Faculty> facultyByColor(@PathVariable String color) {
        return servFaculty.facultyByColor(color);
    }
}
