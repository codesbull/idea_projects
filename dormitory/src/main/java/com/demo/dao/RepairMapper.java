package com.demo.dao;

import com.demo.vo.Repair;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepairMapper {

    List<Repair> getRepairInfo();

    List<Repair> getStudentRepair(@Param("studentId") Integer studentId);

    void createRepair(@Param("project") String project, @Param("dormitoryId") int dormitoryId,
                      @Param("repairDate") String repairDate,@Param("studentId")int studentId);

    void update(@Param("id") int id, @Param("project") String project);

}
