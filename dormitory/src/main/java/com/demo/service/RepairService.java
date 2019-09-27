package com.demo.service;

import com.demo.bean.PageResult;
import com.demo.bean.Result;

public interface RepairService {

    PageResult getRepairInfo(Integer page, Integer limit);

    PageResult getStudentRepair(Integer page, Integer limit, Integer studentId);

    Result createRepair(String project, String dormitoryNumber, String repairDate, String number);

    Result updateRepairProject(int id, String project);

}
