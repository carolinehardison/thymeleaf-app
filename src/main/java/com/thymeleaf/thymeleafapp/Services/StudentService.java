package com.thymeleaf.thymeleafapp.Services;

import com.thymeleaf.thymeleafapp.Models.Student;
import com.thymeleaf.thymeleafapp.Exception.StudentNotFoundException;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    public List<Student> search(String s);
    public int createStudent(Student s) throws StudentNotFoundException;
    public boolean studentExisted(Student student);
    public Integer getId(Student student);
    public List<Student> getAll();
    public Optional<Student> getOne(Integer id);
    public void updateStudent(Student student);
    public void delete(int id);

}
