package com.SpringBoot3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.SpringBoot3.Service.StudentService;
import com.SpringBoot3.model.Student;

@SpringBootApplication
public class SpringJdbCeXApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(SpringJdbCeXApplication.class, args);

	Student student = context.getBean(Student.class);
	student.setRollno(103);
	student.setName("John Smith");
	student.setMarks(100);	

	StudentService service = context.getBean(StudentService.class);
	service.addStudent(student);

	List<Student> students = service.getStudent;
	System.out.println(students);
	

	}

}
