package com.demo.controller;

import com.demo.bean.PageResult;
import com.demo.bean.Result;
import com.demo.service.RepairService;
import com.demo.vo.Repair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RepairController {

    @Autowired
    private RepairService repairService;

    @GetMapping(value = "/admin/repairs")
    public PageResult getRepairInfo(@RequestParam Integer page, @RequestParam Integer limit) {
        return repairService.getRepairInfo(page, limit);
    }

    @GetMapping(value = "/student/repairs")
    public PageResult getStudentRepair(@RequestParam Integer page, @RequestParam Integer limit,
                                       @RequestParam Integer studentId) {
        return repairService.getStudentRepair(page, limit, studentId);
    }

    @PostMapping(value = "/admin/repairs")
    public Result createAdminRepair(@RequestBody Repair repair) {
        String project = repair.getProject();
        String dormitory = repair.getDormitory();
        String repairDate = repair.getRepairDate();
        String number = repair.getNumber();
        return repairService.createRepair(project, dormitory, repairDate, number);
    }

    @PostMapping(value = "/student/repairs")
    public Result createStudentRepair(@RequestBody Repair repair) {
        String project = repair.getProject();
        String dormitory = repair.getDormitory();
        String repairDate = repair.getRepairDate();
        String number = repair.getNumber();
        return repairService.createRepair(project, dormitory, repairDate, number);
    }

    @PutMapping(value = "/admin/repairs")
    public Result updateRepairProject(@RequestBody Repair repair) {
        int id = repair.getId();
        String project = repair.getProject();
        return repairService.updateRepairProject(id, project);
    }
}
