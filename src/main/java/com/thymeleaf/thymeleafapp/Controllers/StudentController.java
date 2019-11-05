package com.thymeleaf.thymeleafapp.Controllers;

import com.thymeleaf.thymeleafapp.Models.Student;
import com.thymeleaf.thymeleafapp.Services.Implementation.StudentServiceImpl;
import com.thymeleaf.thymeleafapp.Exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    StudentServiceImpl studentServiceImpl;
    private static final String STUDENT_MODEL = "student";


    @Autowired
    StudentController(StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
    }

    @RequestMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("students", studentServiceImpl.getAll());
        return "students";
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<Student> getOne(Integer Id)
    {
        return studentServiceImpl.getOne(Id);
    }

    @PostMapping(value="/addNew")
    public String addNew(Model model, @Valid @ModelAttribute(STUDENT_MODEL) Student student) throws StudentNotFoundException {
        student.setUpdatedOn();
        studentServiceImpl.createStudent(student);
        return "redirect:/students/getAll";
    }

    @RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Student student) {
        student.setUpdatedOn();
        studentServiceImpl.updateStudent(student);
        return "redirect:/students/getAll";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer Id) {
        studentServiceImpl.delete(Id);
        return "redirect:/students/getAll";
    }

    @RequestMapping(value = "/search", method={RequestMethod.GET})
    public String search(Model model, String search){
        if(search.length()==0)
            return "redirect:/students/getAll";
        else {
            model.addAttribute("students", studentServiceImpl.search(search));
            model.addAttribute("search", search);
            return "students";
        }
    }


}
