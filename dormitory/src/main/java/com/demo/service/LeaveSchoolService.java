package com.demo.service;

import com.demo.bean.PageResult;
import com.demo.bean.Result;

public interface LeaveSchoolService {

    PageResult getLeaveSchoolInfo(Integer page, Integer limit);

    PageResult getStudentLeaveSchool(Integer page, Integer limit, Integer studentId);

    Result createLeaveSchool(String number, String dormitoryNumber, String leaveSchoolTime,
                             String reason, String valuables);

    Result deleteLeaveSchool(Integer leaveSchoolId);
}
