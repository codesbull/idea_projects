package com.demo.service.impl;

import com.demo.bean.PageResult;
import com.demo.bean.Result;
import com.demo.common.RspEnum;
import com.demo.dao.StudentMapper;
import com.demo.service.StudentService;
import com.demo.utils.ResultUtil;
import com.demo.vo.Student;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult getStudentsInfo(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Student> students;
        try {
            students = studentMapper.getStudentInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.getPageResult(RspEnum.QUERY_STUDENT_INFO_ERROR);
        }
        return ResultUtil.getPageResult(RspEnum.SUCCESSFUL, students, students.size());
    }

    @Override
    public Result getPersonInfo(Integer studentId) {
        Student student = studentMapper.findStudentById(studentId);
        return ResultUtil.getResult(RspEnum.SUCCESSFUL, student);
    }
}
