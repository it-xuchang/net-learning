package com.netlearning.fss.service.impl;

import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.fss.service.FssService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/4 14:23
 */
@Service
public class FssServiceImpl implements FssService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected SequenceService sequenceService;
    public String createGeneralCode() {
        return String.valueOf(this.sequenceService.nextValue(null));
    }
    @Value("{fss_file_path}")
    private String FILE_PATH ;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public CommonResult upload(MultipartFile[] files) {
        //查询是否有token

        //写入数据库

        //获取上传的文件数组
        for (MultipartFile file : files) {
            //创建本地文件
            file.getSize();
            file.getContentType();

            String originalFilename = file.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
            File localFile = new File(FILE_PATH, newName);
            //把传上来的文件写到本地文件
            try {
                file.transferTo(localFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
