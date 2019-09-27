package com.demo.service;

import com.demo.bean.Result;

public interface ChangePasswordService {

    Result adminChangePassword(String adminName, String oldPassword, String newPassword);

    Result studentChangePassword(String studentNumber, String oldPassword, String newPassword);

}
