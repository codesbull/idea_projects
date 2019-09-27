package com.demo.service.impl;

import com.demo.bean.PageResult;
import com.demo.bean.Result;
import com.demo.bean.Student;
import com.demo.common.RspEnum;
import com.demo.dao.ExpressMapper;
import com.demo.dao.StudentMapper;
import com.demo.service.ExpressService;
import com.demo.utils.ResultUtil;
import com.demo.vo.Express;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    private ExpressMapper expressMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult getExpressInfo(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Express> expresses;
        try {
            expresses = expressMapper.getExpressInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getPageResult(RspEnum.QUERY_EXPRESS_INFO_ERROR);
        }
        return ResultUtil.getPageResult(RspEnum.SUCCESSFUL, expresses, expresses.size());
    }

    @Override
    public PageResult getStudentExpress(Integer page, Integer limit,Integer studentId) {
        PageHelper.startPage(page, limit);
        List<Express> expresses;
        try {
            expresses = expressMapper.getStudentExpress(studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getPageResult(RspEnum.QUERY_EXPRESS_INFO_ERROR);
        }
        return ResultUtil.getPageResult(RspEnum.SUCCESSFUL, expresses, expresses.size());
    }

    @Override
    public Result createExpress(String name, String number, String receiveDate) {
        Student student = studentMapper.findStudent(number);
        if (student == null) {
            return ResultUtil.getResult(RspEnum.NUMBER_ERROR);
        }
        if (!name.equals(student.getStudentName())) {
            return ResultUtil.getResult(RspEnum.NAME_ERROR);
        }
        int id = student.getStudentId();
        try {
            expressMapper.createExpress(id, receiveDate);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getResult(RspEnum.CREATE_EXPRESS_INFO_ERROR);
        }
        return ResultUtil.getResult(RspEnum.SUCCESSFUL);
    }

}
