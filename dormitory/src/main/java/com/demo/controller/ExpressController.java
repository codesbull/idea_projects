package com.demo.controller;

import com.demo.bean.PageResult;
import com.demo.bean.Result;
import com.demo.service.ExpressService;
import com.demo.vo.Express;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExpressController {

    @Autowired
    private ExpressService expressService;

    @GetMapping(value = "/admin/expresses")
    public PageResult getExpressInfo(@RequestParam Integer page, @RequestParam Integer limit) {
        return expressService.getExpressInfo(page, limit);
    }

    @GetMapping(value = "/student/expresses")
    public PageResult getStudentExpress(@RequestParam Integer page, @RequestParam Integer limit,
                                        @RequestParam Integer studentId) {
        return expressService.getStudentExpress(page, limit,studentId);
    }

    @PostMapping(value = "/admin/expresses")
    public Result createExpress(@RequestBody Express express) {
        String name = express.getName();
        String number = express.getNumber();
        String receiveDate = express.getReceiveDate();
        return expressService.createExpress(name, number, receiveDate);
    }
}
