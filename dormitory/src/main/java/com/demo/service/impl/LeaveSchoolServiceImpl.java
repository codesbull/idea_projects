package com.demo.service.impl;

import com.demo.bean.Dormitory;
import com.demo.bean.PageResult;
import com.demo.bean.Result;
import com.demo.bean.Student;
import com.demo.common.RspEnum;
import com.demo.dao.DormitoryMapper;
import com.demo.dao.LeaveSchoolMapper;
import com.demo.dao.StudentMapper;
import com.demo.service.LeaveSchoolService;
import com.demo.utils.ResultUtil;
import com.demo.vo.LeaveSchool;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveSchoolServiceImpl implements LeaveSchoolService {

    @Autowired
    private LeaveSchoolMapper leaveSchoolMapper;

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult getLeaveSchoolInfo(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<LeaveSchool> leaveSchools;
        try {
            leaveSchools = leaveSchoolMapper.getLeaveSchoolInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getPageResult(RspEnum.QUERY_LEAVE_SCHOOL_INFO_ERROR);
        }
        return ResultUtil.getPageResult(RspEnum.SUCCESSFUL, leaveSchools, leaveSchools.size());
    }

    @Override
    public PageResult getStudentLeaveSchool(Integer page, Integer limit, Integer studentId) {
        PageHelper.startPage(page, limit);
        List<LeaveSchool> leaveSchools;
        try {
            leaveSchools = leaveSchoolMapper.getStudentLeaveSchool(studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getPageResult(RspEnum.QUERY_LEAVE_SCHOOL_INFO_ERROR);
        }
        return ResultUtil.getPageResult(RspEnum.SUCCESSFUL, leaveSchools, leaveSchools.size());
    }

    @Override
    public Result createLeaveSchool(String number, String dormitoryNumber, String leaveSchoolTime, String reason, String valuables) {
        Dormitory dormitory = dormitoryMapper.findDormitory(dormitoryNumber);
        if (dormitory == null) {
            return ResultUtil.getResult(RspEnum.DORMITORY_ERROR);
        }
        Student student = studentMapper.findStudent(number);
        if (student == null) {
            return ResultUtil.getResult(RspEnum.NUMBER_ERROR);
        }
        int studentId = student.getStudentId();
        try {
            leaveSchoolMapper.createLeaveSchool(leaveSchoolTime, studentId, reason, valuables);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getResult(RspEnum.CREATE_REPAIR_INFO_ERROR);
        }
        return ResultUtil.getResult(RspEnum.SUCCESSFUL);
    }

    @Override
    public Result deleteLeaveSchool(Integer leaveSchoolId) {
        try {
            leaveSchoolMapper.deleteLeaveSchool(leaveSchoolId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getResult(RspEnum.DELETE_LEAVE_SCHOOL_INFO_ERROR);
        }
        return ResultUtil.getResult(RspEnum.SUCCESSFUL);
    }
}
