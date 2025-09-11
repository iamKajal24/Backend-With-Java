package com.SpringBoot3.Repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.SpringBoot3.model.Student;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public void save(Student student) {
      // System.out.println("Student saved ");
      String sql = "insert into student(rollno, name, marks) values(?,?,?)";
     int rows = jdbc.update(sql, student.getRollno(), student.getName(), student.getMarks());
        System.out.println(rows + " row(s) inserted");
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        return students;

        // String sql = "select * from student";
        // RowMapper<Student> Mapper = new RowMapper<Student>() 
        // {
        //     @Override
        //     public Student mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
        //         Student student = new Student();
        //         student.setRollno(rs.getInt("rollno"));
        //         student.setName(rs.getString("name"));
        //         student.setMarks(rs.getInt("marks"));
        //         return student;
        //     }
            
        // };
        // return jdbc.query(sql, Mapper);
    }


    //generate getter and setter for jdbc
    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    
}
