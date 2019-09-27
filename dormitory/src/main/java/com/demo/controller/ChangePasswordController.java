package com.demo.controller;

import com.demo.bean.Result;
import com.demo.service.ChangePasswordService;
import com.demo.vo.ChangePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangePasswordController {

    @Autowired
    private ChangePasswordService changePasswordService;

    @PostMapping(value = "/admin/change-password")
    public Result adminChangePassword(@RequestBody ChangePassword changePassword) {
        String userName = changePassword.getUserName();
        String oldPassword = changePassword.getOldPassword();
        String newPassword = changePassword.getNewPassword();
        return changePasswordService.adminChangePassword(userName, oldPassword, newPassword);
    }

    @PostMapping(value = "/student/change-password")
    public Result studentChangePassword(@RequestBody ChangePassword changePassword) {
        String userName = changePassword.getUserName();
        String oldPassword = changePassword.getOldPassword();
        String newPassword = changePassword.getNewPassword();
        return changePasswordService.studentChangePassword(userName, oldPassword, newPassword);
    }

}
