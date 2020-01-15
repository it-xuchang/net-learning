package com.netlearning.course.controller;

import com.netlearning.course.service.SystemNavService;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.SystemNavAddParam;
import com.netlearning.framework.domain.course.param.SystemNavEditParam;
import com.netlearning.framework.domain.course.result.SystemNavResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/1/6 10:56
 */
@RequestMapping("/system/nav")
@RestController
public class SystemNavController {
    @Autowired
    private SystemNavService systemNavService;

    @GetMapping("/query")
    public CommonResult<List<SystemNavResult>> query(){
        return systemNavService.query();
    }

    @PostMapping("/add")
    public CommonResult<Boolean> add(@RequestBody SystemNavAddParam requset){
        return systemNavService.add(requset);
    }

    @PostMapping("/edit")
    public CommonResult<Boolean> edit(@RequestBody SystemNavEditParam requset){
        return systemNavService.edit(requset);
    }

    @PostMapping("/delete")
    public CommonResult<Boolean> delete(@RequestBody Long systemNavId){
        return systemNavService.delete(systemNavId);
    }
}
