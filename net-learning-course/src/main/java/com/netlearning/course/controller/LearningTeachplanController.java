package com.netlearning.course.controller;

import com.netlearning.course.service.LearningTeachplanService;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.LearningTeachplanAddParam;
import com.netlearning.framework.domain.course.param.LearningTeachplanEditParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/2/12 15:22
 */
@RestController
@RequestMapping("/learning/teachplan")
public class LearningTeachplanController {
    @Autowired
    private LearningTeachplanService learningTeachplanService;

    @PostMapping("/join")
    public CommonResult<Boolean> add(@RequestBody LearningTeachplanAddParam param){

        return learningTeachplanService.add(param);
    }

    @PostMapping("/edit")
    public CommonResult<Boolean> edit(@RequestBody LearningTeachplanEditParam param){

        return learningTeachplanService.edit(param);
    }

}
