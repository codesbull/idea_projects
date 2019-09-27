package com.demo.controller;

import com.demo.bean.Result;
import com.demo.service.RegisterService;
import com.demo.vo.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping(value = "/student/register")
    public Result studentRegister(@RequestBody Register register) {
        String studentNumber = register.getStudentNumber();
        String studentPassword = register.getStudentPassword();
        return registerService.studentRegister(studentNumber, studentPassword);
    }
}
