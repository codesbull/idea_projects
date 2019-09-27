package com.demo.dao;

import com.demo.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    Student findStudent(@Param("studentNumber") String studentNumber);

    com.demo.vo.Student findStudentById(@Param("studentId") Integer studentId);

    void createStudent(Student student);

    List<com.demo.vo.Student> getStudentInfo();

    void changePassword(@Param("studentId") Integer studentId, @Param("password") String password);
}
