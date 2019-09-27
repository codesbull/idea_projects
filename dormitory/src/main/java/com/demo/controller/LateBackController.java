package com.demo.controller;

import com.demo.bean.PageResult;
import com.demo.bean.Result;
import com.demo.service.LateBackService;
import com.demo.vo.LateBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LateBackController {

    @Autowired
    private LateBackService lateBackService;

    @GetMapping(value = "/admin/late-backs")
    public PageResult getLateBackInfo(@RequestParam Integer page, @RequestParam Integer limit) {
        return lateBackService.getLateBackInfo(page, limit);
    }

    @PostMapping(value = "/admin/late-backs")
    public Result createLateBack(@RequestBody LateBack lateBack) {
        String number = lateBack.getNumber();
        String lateBackTime = lateBack.getLateBackTime();
        String reason = lateBack.getReason();
        return lateBackService.createLateBack(number, lateBackTime, reason);
    }
}
