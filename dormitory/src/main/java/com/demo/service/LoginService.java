package com.demo.service;

import com.demo.bean.Result;

public interface LoginService {

    Result adminLogin(String adminName, String adminPassword);

    Result studentLogin(String studentNumber, String studentPassword);
}
