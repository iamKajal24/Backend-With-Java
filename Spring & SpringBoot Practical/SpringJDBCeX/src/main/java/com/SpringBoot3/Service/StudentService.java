package com.SpringBoot3.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBoot3.Repo.StudentRepo;
import com.SpringBoot3.model.Student;

@Service
public class StudentService {

    private StudentRepo studentRepo;
    public List<Student> getStudent;
   
    public List<Student> getStudent() {
        return studentRepo.findAll();
    }

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void addStudent(Student student) {
       studentRepo.save(student);
       System.out.println("student added successfully: ");
    }
    
}
