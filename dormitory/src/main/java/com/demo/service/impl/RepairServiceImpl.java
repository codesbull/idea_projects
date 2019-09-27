package com.demo.service.impl;

import com.demo.bean.Dormitory;
import com.demo.bean.PageResult;
import com.demo.bean.Result;
import com.demo.bean.Student;
import com.demo.common.RspEnum;
import com.demo.dao.DormitoryMapper;
import com.demo.dao.RepairMapper;
import com.demo.dao.StudentMapper;
import com.demo.service.RepairService;
import com.demo.utils.ResultUtil;
import com.demo.vo.Repair;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairMapper repairMapper;

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult getRepairInfo(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Repair> repairs;
        try {
            repairs = repairMapper.getRepairInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getPageResult(RspEnum.QUERY_REPAIR_INFO_ERROR);
        }
        return ResultUtil.getPageResult(RspEnum.SUCCESSFUL, repairs, repairs.size());
    }

    @Override
    public PageResult getStudentRepair(Integer page, Integer limit, Integer studentId) {
        PageHelper.startPage(page, limit);
        List<Repair> repairs;
        try {
            repairs = repairMapper.getStudentRepair(studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getPageResult(RspEnum.QUERY_REPAIR_INFO_ERROR);
        }
        return ResultUtil.getPageResult(RspEnum.SUCCESSFUL, repairs, repairs.size());
    }

    @Override
    public Result createRepair(String project, String dormitoryNumber, String repairDate, String number) {
        Dormitory dormitory = dormitoryMapper.findDormitory(dormitoryNumber);
        if (dormitory == null) {
            return ResultUtil.getResult(RspEnum.DORMITORY_ERROR);
        }
        Student student = studentMapper.findStudent(number);
        if (student == null) {
            return ResultUtil.getResult(RspEnum.NUMBER_ERROR);
        }
        int dormitoryId = dormitory.getDormitoryId();
        int studentId = student.getStudentId();
        try {
            repairMapper.createRepair(project, dormitoryId, repairDate, studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getResult(RspEnum.CREATE_REPAIR_INFO_ERROR);
        }
        return ResultUtil.getResult(RspEnum.SUCCESSFUL);
    }

    @Override
    public Result updateRepairProject(int id, String project) {
        try {
            repairMapper.update(id, project);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getResult(RspEnum.UPDATE_REPAIR_INFO_ERROR);
        }
        return ResultUtil.getResult(RspEnum.SUCCESSFUL);
    }
}
