package com.demo.controller;

import com.demo.bean.PageResult;
import com.demo.bean.Result;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/admin/students")
    public PageResult getStudentsInfo(@RequestParam Integer page, @RequestParam Integer limit) {
        return studentService.getStudentsInfo(page, limit);
    }

    @GetMapping(value = "/students/{studentId}")
    public Result getPersonInfo(@PathVariable("studentId") Integer studentId) {
        return studentService.getPersonInfo(studentId);
    }
}
