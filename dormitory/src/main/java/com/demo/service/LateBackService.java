package com.demo.service;

import com.demo.bean.PageResult;
import com.demo.bean.Result;

public interface LateBackService {

    PageResult getLateBackInfo(Integer page, Integer limit);

    Result createLateBack(String number, String lateBackTime, String reason);
}
