package com.demo.controller;

import com.demo.bean.PageResult;
import com.demo.bean.Result;
import com.demo.service.LeaveSchoolService;
import com.demo.vo.LeaveSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LeaveSchoolController {

    @Autowired
    private LeaveSchoolService leaveSchoolService;

    @GetMapping(value = "/admin/leave-schools")
    public PageResult getLeaveSchoolInfo(@RequestParam Integer page, @RequestParam Integer limit) {
        return leaveSchoolService.getLeaveSchoolInfo(page, limit);
    }

    @GetMapping(value = "/student/leave-schools")
    public PageResult getStudentLeaveSchool(@RequestParam Integer page, @RequestParam Integer limit,
                                            @RequestParam Integer studentId) {
        return leaveSchoolService.getStudentLeaveSchool(page, limit, studentId);
    }

    @PostMapping(value = "/student/leave-schools")
    public Result createLeaveSchool(@RequestBody LeaveSchool leaveSchool) {
        String number = leaveSchool.getNumber();
        String dormitory = leaveSchool.getDormitory();
        String leaveSchoolTime = leaveSchool.getLeaveSchoolTime();
        String reason = leaveSchool.getReason();
        String valuables = leaveSchool.getValuables();
        return leaveSchoolService.createLeaveSchool(number, dormitory, leaveSchoolTime, reason, valuables);
    }

    @DeleteMapping(value = "/student/leave-schools/{leaveSchoolId}")
    public Result deleteLeaveSchool(@PathVariable("leaveSchoolId") Integer leaveSchoolId) {
        return leaveSchoolService.deleteLeaveSchool(leaveSchoolId);
    }
}
