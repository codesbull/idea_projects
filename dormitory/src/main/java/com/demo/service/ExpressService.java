package com.demo.service;

import com.demo.bean.PageResult;
import com.demo.bean.Result;

public interface ExpressService {

    PageResult getExpressInfo(Integer page, Integer limit);

    PageResult getStudentExpress(Integer page, Integer limit,Integer studentId);

    Result createExpress(String name, String number, String receiveDate);
}
