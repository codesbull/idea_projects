package com.demo.controller;

import com.demo.bean.Result;
import com.demo.service.LoginService;
import com.demo.vo.Login;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private Logger logger = LogManager.getLogger();

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/admin/login")
    public Result adminLogin(@RequestBody Login login) {
        String userName = login.getUserName();
        String password = login.getPassword();
        return loginService.adminLogin(userName, password);
    }

    @PostMapping(value = "/student/login")
    public Result studentLogin(@RequestBody Login login) {
        String userName = login.getUserName();
        String password = login.getPassword();
        return  loginService.studentLogin(userName, password);
    }

}
