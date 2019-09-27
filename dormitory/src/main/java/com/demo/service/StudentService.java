package com.demo.service;

import com.demo.bean.PageResult;
import com.demo.bean.Result;

public interface StudentService {

    PageResult getStudentsInfo(Integer page, Integer limit);

    Result getPersonInfo(Integer studentId);
}
