package com.netlearning.course.controller;

import com.netlearning.course.service.TeachPlanMediaService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.domain.course.param.TeachPlanMediaAddParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaDeleteParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaEditParam;
import com.netlearning.framework.domain.course.param.TeachPlanMediaQueryParam;
import com.netlearning.framework.domain.course.result.TeachPlanMediaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/25 20:50
 */
@RestController
@RequestMapping("/techplan/media")
public class TeachPlanMediaController {
    @Autowired
    private TeachPlanMediaService teachPlanMediaService;


    @GetMapping("page")
    public CommonResult<CommonPageResult<TeachPlanMediaResult>> page(@RequestParam(value = "pageNum",required = false) Integer pageNum,
                                                                     @RequestParam(value = "pageSize",required = false) Integer pageSize,
                                                                     @RequestParam(value = "teachplanMediaId",required = false) Long teachplanMediaId,
                                                                     @RequestParam(value = "mediaId",required = false) Long mediaId,
                                                                     @RequestParam(value = "mediaFileoriginalName",required = false) String mediaFileoriginalName,
                                                                     @RequestParam(value = "mediaUrl",required = false) String mediaUrl,
                                                                     @RequestParam(value = "courseId",required = false) Long courseId,
                                                                     @RequestParam(value = "teachplanId",required = false) Long teachplanId,
                                                                     @RequestParam(value = "recordId",required = false) Long recordId){

        TeachPlanMediaQueryParam param = new TeachPlanMediaQueryParam();
        param.setCourseId(courseId);
        param.setRecordId(recordId);
        param.setMediaFileoriginalName(mediaFileoriginalName);
        param.setMediaUrl(mediaUrl);
        param.setTeachplanId(teachplanId);
        param.setTeachplanMediaId(teachplanMediaId);
        param.setMediaId(mediaId);

        CommonPageInfo commonPageInfo = new CommonPageInfo(pageNum,pageSize);
        return teachPlanMediaService.page(param,commonPageInfo);
    }
    @GetMapping("query")
    public CommonResult<List<TeachPlanMediaResult>> query(@RequestParam(value = "teachplanMediaId",required = false) Long teachplanMediaId,
                                                          @RequestParam(value = "mediaId",required = false) Long mediaId,
                                                          @RequestParam(value = "mediaFileoriginalName",required = false) String mediaFileoriginalName,
                                                          @RequestParam(value = "mediaUrl",required = false) String mediaUrl,
                                                          @RequestParam(value = "courseId",required = false) Long courseId,
                                                          @RequestParam(value = "teachplanId",required = false) Long teachplanId,
                                                          @RequestParam(value = "recordId",required = false) Long recordId){
        TeachPlanMediaQueryParam param = new TeachPlanMediaQueryParam();
        param.setCourseId(courseId);
        param.setRecordId(recordId);
        param.setMediaFileoriginalName(mediaFileoriginalName);
        param.setMediaUrl(mediaUrl);
        param.setTeachplanId(teachplanId);
        param.setTeachplanMediaId(teachplanMediaId);
        param.setMediaId(mediaId);
        return teachPlanMediaService.query(param);
    }

    @PostMapping("add")
    public CommonResult<Boolean> add(@RequestBody TeachPlanMediaAddParam request){

        return teachPlanMediaService.add(request);
    }
    @PostMapping("edit")
    public CommonResult<Boolean> edit(@RequestBody TeachPlanMediaEditParam request){
       return teachPlanMediaService.edit(request);
    }
    @PostMapping("delete")
    public CommonResult<Boolean> delete(@RequestBody List<Long> teachplanMediaIds){

        return teachPlanMediaService.delete(teachplanMediaIds);
    }
}
