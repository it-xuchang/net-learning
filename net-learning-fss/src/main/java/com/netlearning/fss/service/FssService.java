package com.netlearning.fss.service;

import com.netlearning.framework.base.CommonResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/4 14:22
 */
public interface FssService {
    CommonResult upload(MultipartFile[] files);
}
