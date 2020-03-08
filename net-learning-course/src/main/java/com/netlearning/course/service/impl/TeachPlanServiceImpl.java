package com.netlearning.course.service.impl;

import com.netlearning.course.mapper.TeachPlanMapper;
import com.netlearning.course.mapper.TeachPlanMediaMapper;
import com.netlearning.course.service.TeachPlanService;
import com.netlearning.framework.base.CommonPageInfo;
import com.netlearning.framework.base.CommonPageResult;
import com.netlearning.framework.base.CommonResult;
import com.netlearning.framework.bean.BeanCopyUtils;
import com.netlearning.framework.domain.course.TeachPlan;
import com.netlearning.framework.domain.course.TeachPlanExample;
import com.netlearning.framework.domain.course.TeachPlanMedia;
import com.netlearning.framework.domain.course.TeachPlanMediaExample;
import com.netlearning.framework.domain.course.param.TeachPlanAddParam;
import com.netlearning.framework.domain.course.param.TeachPlanDeleteParam;
import com.netlearning.framework.domain.course.param.TeachPlanEditParam;
import com.netlearning.framework.domain.course.param.TeachPlanQueryParam;
import com.netlearning.framework.domain.course.result.BaseCourseTeachPlanResult;
import com.netlearning.framework.domain.course.result.TeachPlanMediaResult;
import com.netlearning.framework.domain.course.result.TeachPlanResult;
import com.netlearning.framework.exception.ExceptionCode;
import com.netlearning.framework.snowflake.SequenceService;
import com.netlearning.framework.utils.CollectionUtils;
import com.netlearning.framework.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/25 22:29
 */
@Service
public class TeachPlanServiceImpl implements TeachPlanService {
    @Autowired
    private TeachPlanMapper teachPlanMapper;
    @Autowired
    private TeachPlanMediaMapper teachPlanMediaMapper;
    @Autowired
    private SequenceService sequenceService;

    @Override
    public CommonResult add(TeachPlanAddParam request) {
        try {
            //添加教学计划，教学计划的资源
            TeachPlan record = new TeachPlan();
            BeanCopyUtils.copyProperties(request,record);
            record.setTeachplanId(sequenceService.nextValue(null));
            teachPlanMapper.insertSelective(record);
            return CommonResult.success(record);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE002.code,ExceptionCode.CourseCode.CODE002.message);
        }
    }

    @Override
    public CommonResult<Boolean> edit(TeachPlanEditParam request) {
        try {
            TeachPlan record = new TeachPlan();
            BeanCopyUtils.copyProperties(request,record);
            teachPlanMapper.updateByPrimaryKeySelective(record);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE003.code,ExceptionCode.CourseCode.CODE003.message);
        }
    }

    @Override
    public CommonResult<Boolean> delete(TeachPlanDeleteParam param) {
        try {
            if (CollectionUtils.isEmpty(param.getTeachplanIds())){
                return CommonResult.fail(ExceptionCode.CourseCode.CODE007.code,ExceptionCode.CourseCode.CODE007.message);
            }
            TeachPlanExample example = new TeachPlanExample();
            example.createCriteria().andTeachplanIdIn(param.getTeachplanIds());
            teachPlanMapper.deleteByExample(example);
            return CommonResult.success(true);
        }catch (Exception e){
            return CommonResult.fail(ExceptionCode.CourseCode.CODE004.code,ExceptionCode.CourseCode.CODE004.message);
        }
    }

    @Override
    public CommonResult<List<BaseCourseTeachPlanResult>> query(TeachPlanQueryParam param) {
        TeachPlanExample example = new TeachPlanExample();
        TeachPlanExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(param.getCourseId())){
            criteria.andCourseIdEqualTo(param.getCourseId());
        }
        if (param.getTeachplanId() != null){
            criteria.andTeachplanIdEqualTo(param.getTeachplanId());
        }
        if (!StringUtils.isEmpty(param.getTeachplanName())){
            criteria.andTeachplanNameLike("%"+param.getTeachplanName()+"%");
        }
        if (!StringUtils.isEmpty(param.getStatus())){
            criteria.andStatusEqualTo(param.getStatus());
        }
        List<TeachPlan> teachPlanList = teachPlanMapper.selectByExample(example);
        List<TeachPlanResult> teachPlanResults = BeanCopyUtils.copy(teachPlanList,TeachPlanResult.class);
        List<Long> teachplanIds = new ArrayList<>();
        Map<String,List<TeachPlanResult>> teachPlanMap = new HashMap<>();
        for (TeachPlanResult teachPlanResult:teachPlanResults){
            if (!teachplanIds.contains(teachPlanResult.getTeachplanId())){
                teachplanIds.add(teachPlanResult.getTeachplanId());
            }
            if (teachPlanMap.containsKey(teachPlanResult.getCourseId())){
                teachPlanMap.get(teachPlanResult.getCourseId()).add(teachPlanResult);
            }else {
                List<TeachPlanResult> list = new ArrayList<>();
                list.add(teachPlanResult);
                teachPlanMap.put(teachPlanResult.getCourseId(),list);
            }
        }
        TeachPlanMediaExample teachPlanMediaExample = new TeachPlanMediaExample();
        TeachPlanMediaExample.Criteria teachPlanMediaExampleCriteria = teachPlanMediaExample.createCriteria();
        teachPlanMediaExampleCriteria.andTeachplanIdIn(teachplanIds);
        Map<Long,List<TeachPlanMedia>> teachPlanMediaMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(teachplanIds)){
            List<TeachPlanMedia> teachPlanMediaList = teachPlanMediaMapper.selectByExample(teachPlanMediaExample);
            for (TeachPlanMedia teachPlanMedia : teachPlanMediaList){
                if (teachPlanMediaMap.containsKey(teachPlanMedia.getTeachplanId())){
                    teachPlanMediaMap.get(teachPlanMedia.getTeachplanId()).add(teachPlanMedia);
                }else {
                    List<TeachPlanMedia> list = new ArrayList<>();
                    list.add(teachPlanMedia);
                    teachPlanMediaMap.put(teachPlanMedia.getTeachplanId(),list);
                }
            }
        }

        List<BaseCourseTeachPlanResult> results = new ArrayList<>();
        for (Map.Entry<String,List<TeachPlanResult>> entry : teachPlanMap.entrySet()){
            BaseCourseTeachPlanResult result = new BaseCourseTeachPlanResult();
            result.setCourseId(entry.getKey());
            result.setTeachPlans(this.getTreeTeachPlan(entry.getValue(),teachPlanMediaMap));
            results.add(result);
        }

        return CommonResult.success(results);
    }

    /**
     * 教学计划--教学资源
     * @param teachPlanResults
     * @param teachPlanMediaMap
     * @return
     */
    private List<TeachPlanResult> getTreeTeachPlan(List<TeachPlanResult> teachPlanResults,
                                                   Map<Long, List<TeachPlanMedia>> teachPlanMediaMap){
        List<TeachPlanResult> results = new ArrayList<>();
        //第一层
        Map<Long,TeachPlanResult> oneTree = new HashMap<>();
        for (TeachPlanResult teachPlanResult : teachPlanResults){
            if (teachPlanMediaMap.containsKey(teachPlanResult.getTeachplanId())){
                List<TeachPlanMediaResult> list = BeanCopyUtils.copy(teachPlanMediaMap.get(teachPlanResult.getTeachplanId()),TeachPlanMediaResult.class);
                teachPlanResult.setTeachPlanMediaResults(list);
            }

            if (teachPlanResult.getParentId() == null){
                if (!oneTree.containsKey(teachPlanResult.getTeachplanId())){
                    oneTree.put(teachPlanResult.getTeachplanId(),teachPlanResult);
                }
            }
        }
        //第二层
        Map<Long,List<TeachPlanResult>> twoTree = new HashMap<>();
        for (TeachPlanResult teachPlanResult : teachPlanResults){
            if (oneTree.containsKey(teachPlanResult.getParentId())){
                if (twoTree.containsKey(teachPlanResult.getParentId())){
                    twoTree.get(teachPlanResult.getParentId()).add(teachPlanResult);
                }else {
                    List<TeachPlanResult> list = new ArrayList<>();
                    list.add(teachPlanResult);
                    twoTree.put(teachPlanResult.getParentId(),list);
                }
            }
        }
        //第三层
        Map<Long,List<TeachPlanResult>> threeTree = new HashMap<>();
        for (Map.Entry<Long,List<TeachPlanResult>> twoEntey : twoTree.entrySet()){
            List<TeachPlanResult> twoTreeVlaue = twoEntey.getValue();
            for (TeachPlanResult twoMenu : twoTreeVlaue){
                Long twoKey = twoMenu.getTeachplanId();
                for (TeachPlanResult teachPlanResult : teachPlanResults){
                    if (twoKey.equals(teachPlanResult.getParentId())){
                        if (threeTree.containsKey(twoKey)){
                            threeTree.get(twoKey).add(teachPlanResult);
                        }else {
                            List<TeachPlanResult> list = new ArrayList<>();
                            list.add(teachPlanResult);
                            threeTree.put(twoKey,list);
                        }
                    }
                }
            }
        }
        //封装返回
        for (Map.Entry<Long,TeachPlanResult> oneEntry : oneTree.entrySet()){
            TeachPlanResult oneTreeMenu = new TeachPlanResult();
            Long oneKey = oneEntry.getKey();
            TeachPlanResult oneValue = oneEntry.getValue();
            BeanCopyUtils.copyProperties(oneValue,oneTreeMenu);
            if (twoTree.containsKey(oneKey)){
                List<TeachPlanResult> twoMenus = twoTree.get(oneKey);
                List<TeachPlanResult> twoMenuItems = BeanCopyUtils.copy(twoMenus,TeachPlanResult.class);
                if (CollectionUtils.isEmpty(twoMenuItems)){
                    oneTreeMenu.setSubTeachPlanResult(new ArrayList<>());
                }else {
                    oneTreeMenu.setSubTeachPlanResult(twoMenuItems);
                }

                for (TeachPlanResult twoMenu : twoMenuItems){
                    if (threeTree.containsKey(twoMenu.getTeachplanId())){
                        List<TeachPlanResult> threeMenus = threeTree.get(twoMenu.getTeachplanId());
                        List<TeachPlanResult> threeMenuItems = BeanCopyUtils.copy(threeMenus,TeachPlanResult.class);
                        if (CollectionUtils.isEmpty(threeMenuItems)){
                            twoMenu.setSubTeachPlanResult(new ArrayList<>());
                        }else {
                            twoMenu.setSubTeachPlanResult(threeMenuItems);
                        }

                    }
                }
            }else {
                oneTreeMenu.setSubTeachPlanResult(new ArrayList<>());
            }
            results.add(oneTreeMenu);
        }


        return results;
    }

    @Override
    public CommonResult<CommonPageResult<BaseCourseTeachPlanResult>> page(TeachPlanQueryParam param, CommonPageInfo commonPageInfo) {
        TeachPlanExample example = new TeachPlanExample();
        TeachPlanExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(param.getCourseId())){
            criteria.andCourseIdEqualTo(param.getCourseId());
        }
        if (param.getTeachplanId() != null){
            criteria.andTeachplanIdEqualTo(param.getTeachplanId());
        }
        if (!StringUtils.isEmpty(param.getTeachplanName())){
            criteria.andTeachplanNameLike("%"+param.getTeachplanName()+"%");
        }
        if (!StringUtils.isEmpty(param.getStatus())){
            criteria.andStatusEqualTo(param.getStatus());
        }
        List<TeachPlan> teachPlanList = teachPlanMapper.selectByExample(example);
        List<TeachPlanResult> teachPlanResults = BeanCopyUtils.copy(teachPlanList,TeachPlanResult.class);
        List<Long> teachplanIds = new ArrayList<>();
        Map<String,List<TeachPlanResult>> teachPlanMap = new HashMap<>();
        for (TeachPlanResult teachPlanResult:teachPlanResults){
            if (!teachplanIds.contains(teachPlanResult.getTeachplanId())){
                teachplanIds.add(teachPlanResult.getTeachplanId());
            }
            if (teachPlanMap.containsKey(teachPlanResult.getCourseId())){
                teachPlanMap.get(teachPlanResult.getCourseId()).add(teachPlanResult);
            }else {
                List<TeachPlanResult> list = new ArrayList<>();
                list.add(teachPlanResult);
                teachPlanMap.put(teachPlanResult.getCourseId(),list);
            }
        }
        TeachPlanMediaExample teachPlanMediaExample = new TeachPlanMediaExample();
        TeachPlanMediaExample.Criteria teachPlanMediaExampleCriteria = teachPlanMediaExample.createCriteria();
        teachPlanMediaExampleCriteria.andTeachplanIdIn(teachplanIds);
        Map<Long,List<TeachPlanMedia>> teachPlanMediaMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(teachplanIds)){
            List<TeachPlanMedia> teachPlanMediaList = teachPlanMediaMapper.selectByExample(teachPlanMediaExample);
            for (TeachPlanMedia teachPlanMedia : teachPlanMediaList){
                if (teachPlanMediaMap.containsKey(teachPlanMedia.getTeachplanId())){
                    teachPlanMediaMap.get(teachPlanMedia.getTeachplanId()).add(teachPlanMedia);
                }else {
                    List<TeachPlanMedia> list = new ArrayList<>();
                    list.add(teachPlanMedia);
                    teachPlanMediaMap.put(teachPlanMedia.getTeachplanId(),list);
                }
            }
        }

        List<BaseCourseTeachPlanResult> results = new ArrayList<>();
        for (Map.Entry<String,List<TeachPlanResult>> entry : teachPlanMap.entrySet()){
            BaseCourseTeachPlanResult result = new BaseCourseTeachPlanResult();
            result.setCourseId(entry.getKey());
            result.setTeachPlans(this.getTreeTeachPlan(entry.getValue(),teachPlanMediaMap));
            results.add(result);
        }
        int pageNo=(commonPageInfo.getPageNum()-1)*commonPageInfo.getPageSize();   //每页的起始索引
        int pageSize=commonPageInfo.getPageSize(); // 每页记录数
        long total = results.size();
        if (pageNo+pageSize > total) {
            results = results.subList(pageNo, (int) total);
        }else {
            results = results.subList(pageNo,pageNo+pageSize);
        }
        CommonPageResult<BaseCourseTeachPlanResult> pageResult = CommonPageResult.build(results,commonPageInfo,total);
        return CommonResult.success(pageResult);
    }
}
