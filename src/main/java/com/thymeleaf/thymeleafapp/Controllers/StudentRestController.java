package com.thymeleaf.thymeleafapp.Controllers;

import com.thymeleaf.thymeleafapp.Exception.StudentNotFoundException;
import com.thymeleaf.thymeleafapp.Models.Student;
import com.thymeleaf.thymeleafapp.Services.Implementation.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    StudentServiceImpl studentServiceImpl;
    private static final String STUDENT_MODEL = "student";


    @Autowired
    StudentRestController(StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
    }

    @GetMapping("/")
    List<Student> all() {
        return studentServiceImpl.getAll();
    }

    @PostMapping("/")
    Student newStudent(@RequestBody Student newStudent) {
        return studentServiceImpl.save(newStudent);
    }

    // Single item

    @GetMapping("/{id}")
    Student one(@PathVariable int id) throws StudentNotFoundException{

        return studentServiceImpl.getOne(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PutMapping("/{id}")
    Student replaceStudent(@RequestBody Student newStudent, @PathVariable int id) {
        return studentServiceImpl.getOne(id)
        .map(student -> {
            student.setName(newStudent.getName());
            student.setDepartment(newStudent.getDepartment());
            student.setUpdatedOn();
            student.setUpdatedBy(newStudent.getUpdatedBy());
            return studentServiceImpl.save(student);
        })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentServiceImpl.save(newStudent);
                });
    }

    @DeleteMapping(value="/delete")
    public void delete(@PathVariable Integer Id) {
        studentServiceImpl.delete(Id);
    }
}
