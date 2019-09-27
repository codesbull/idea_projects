package com.demo.service.impl;

import com.demo.bean.PageResult;
import com.demo.bean.Result;
import com.demo.bean.Student;
import com.demo.common.RspEnum;
import com.demo.dao.LateBackMapper;
import com.demo.dao.StudentMapper;
import com.demo.service.LateBackService;
import com.demo.utils.ResultUtil;
import com.demo.vo.LateBack;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LateBackServiceImpl implements LateBackService {

    @Autowired
    private LateBackMapper lateBackMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult getLateBackInfo(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<LateBack> lateBacks;
        try {
            lateBacks = lateBackMapper.getLateBackInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getPageResult(RspEnum.QUERY_LATE_BACK_INFO_ERROR);
        }
        return ResultUtil.getPageResult(RspEnum.SUCCESSFUL, lateBacks, lateBacks.size());
    }

    @Override
    public Result createLateBack(String number, String lateBackTime, String reason) {
        Student student = studentMapper.findStudent(number);
        if (student == null) {
            return ResultUtil.getResult(RspEnum.NUMBER_ERROR);
        }
        int id = student.getStudentId();
        try {
            lateBackMapper.createLateBack(id, lateBackTime, reason);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getResult(RspEnum.CREATE_LATE_BACK_ERROR);
        }
        return ResultUtil.getResult(RspEnum.SUCCESSFUL);
    }
}
