package com.thymeleaf.thymeleafapp.Services.Implementation;

import com.thymeleaf.thymeleafapp.Models.Student;
import com.thymeleaf.thymeleafapp.Repository.StudentRepo;
import com.thymeleaf.thymeleafapp.Services.StudentService;
import com.thymeleaf.thymeleafapp.Exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {


    private StudentRepo studentRepo;
    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    @Transactional
    public List<Student> search(String s){
        return studentRepo.search(s);
    }

    @Transactional
    public Student save(Student s){
        studentRepo.save(s);
        return s;
    }

    @Transactional
    public int createStudent(Student s) throws StudentNotFoundException {
        if(!studentExisted(s)){
            studentRepo.save(s);
            return s.getId();
        }else if(getId(s)!=null){
            return getId(s);
        }
        throw new StudentNotFoundException();
    }

    @Transactional
    public boolean studentExisted(Student student){
        int c = studentRepo.countStudent(student.getDepartment(),student.getName(), student.getUpdatedBy(), student.getUpdatedOn());
        if(c!=0)
            return true;
        return false;
    }


    @Transactional
    public Integer getId(Student student){
        if(studentExisted(student)){
            return studentRepo.findStudent(student.getDepartment(),student.getName(), student.getUpdatedBy(), student.getUpdatedOn());
        }else
            return null;
    }

    @Transactional
    public List<Student> getAll(){
        return (List<Student>) studentRepo.findAll();
    }


    public Optional<Student> getOne(Integer id) {
        return studentRepo.findById(id);
    }

    public void updateStudent(Student student){
        studentRepo.save(student);
    }

    public void delete(int id){
        studentRepo.deleteById(id);
    }

}
