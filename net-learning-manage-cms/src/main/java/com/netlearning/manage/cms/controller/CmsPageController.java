package com.netlearning.manage.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netlearning.api.cms.CmsPageControllerApi;
import com.netlearning.framework.domain.cms.CmsPage;
import com.netlearning.framework.domain.cms.request.QueryPageRequest;
import com.netlearning.framework.domain.cms.response.CmsPageResult;
import com.netlearning.framework.model.response.QueryResponseResult;
import com.netlearning.framework.model.response.ResponseResult;
import com.netlearning.manage.cms.service.CmsPageService;

@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
    private CmsPageService cmspageService;

    /**
     * 	分页查找
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, QueryPageRequest queryPageRequest) {

        //调用service
        return cmspageService.findList(page,size,queryPageRequest);
    }

    /**
     * 	添加
     */
    @Override
    @PostMapping("/add")
    public CmsPageResult add(@RequestBody  CmsPage cmsPage) {
        return cmspageService.add(cmsPage);
    }

    /**
     * 	根据id获取
     */
    @Override
    @GetMapping("/get/{id}")
    public CmsPage findById(@PathVariable("id") String id) {
        return cmspageService.findById(id);
    }

    /**
     * 	根据id修改
     */
    @Override
    @PutMapping("/edit/{id}")
    public CmsPageResult edit(@PathVariable("id")String id, @RequestBody CmsPage cmsPage) {
        return cmspageService.update(id,cmsPage);
    }

    /**
     * 	这里使用put方法，http 方法中put表示更新
     */
    @Override
    @DeleteMapping("/del/{id}")
    public ResponseResult delete(@PathVariable("id") String id) {
        return cmspageService.delete(id);
    }

    @Override
    @PostMapping("/postPage/{pageId}")
    public ResponseResult post(@PathVariable("pageId") String pageId) {
        return cmspageService.post(pageId);
    }

}
