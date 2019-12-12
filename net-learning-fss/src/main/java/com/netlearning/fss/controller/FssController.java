package com.netlearning.fss.controller;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.fss.service.FssService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/4 10:51
 */
@RestController
@RequestMapping("/fss")
public class FssController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FssController.class);
    @Autowired
    private FssService fssService;

    @PostMapping("/upload")
    public CommonResult upload(MultipartFile[] files,
                               @RequestParam("userId") String userId ,
                               @RequestParam("tokenKey") String tokenKey){
        return fssService.upload(files,userId,tokenKey);
    }

    @PostMapping("/uploadToken")
    public String applyUploadToken(){

        return null;
    }
    @PostMapping("/download")
    public CommonResult download(){
        return null;
    }

    @GetMapping("/query")
    public CommonResult query(){
        return null;
    }

    @PostMapping("/remove")
    public CommonResult remove(){
        return null;
    }
}
