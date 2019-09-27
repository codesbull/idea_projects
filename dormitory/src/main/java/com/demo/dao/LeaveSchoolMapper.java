package com.demo.dao;

import com.demo.vo.LeaveSchool;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaveSchoolMapper {

    List<LeaveSchool> getLeaveSchoolInfo();

    List<LeaveSchool> getStudentLeaveSchool(@Param("studentId") Integer studentId);

    void createLeaveSchool(@Param("leaveSchoolTime") String leaveSchoolTime, @Param("studentId") Integer studentId,
                           @Param("reason") String reason, @Param("valuables") String valuables);

    void deleteLeaveSchool(@Param("leaveSchoolId") Integer leaveSchoolId);
}
