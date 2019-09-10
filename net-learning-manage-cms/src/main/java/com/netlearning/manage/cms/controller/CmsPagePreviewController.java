package com.netlearning.manage.cms.controller;
import java.io.IOException;

import javax.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netlearning.framework.web.BaseController;
import com.netlearning.manage.cms.service.CmsPageService;


@Controller
public class CmsPagePreviewController extends BaseController {

    @Autowired
    CmsPageService cmsPageService;

    /**
     * 	页面预览
     * @param pageId
     * @throws IOException
     */
    @RequestMapping(value="/cms/preview/{pageId}",method = RequestMethod.GET)
    public void preview(@PathVariable("pageId") String pageId) throws IOException {
        //执行静态化
        String pageHtml = cmsPageService.getPageHtml(pageId);
        //通过response对象将内容输出
        ServletOutputStream outputStream = response.getOutputStream();

        outputStream.write(pageHtml.getBytes("utf-8"));

    }
}