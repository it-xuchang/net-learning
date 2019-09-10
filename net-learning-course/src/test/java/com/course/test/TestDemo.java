package com.course.test;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.netlearning.course.CourseApp;
import com.netlearning.course.dao.CourseBaseRepository;
import com.netlearning.course.dao.CourseMapper;
import com.netlearning.course.dao.TeachplanMapper;
import com.netlearning.framework.domain.course.CourseBase;
import com.netlearning.framework.domain.course.ext.TeachplanNode;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE, classes = CourseApp.class)
@RunWith(SpringRunner.class)
public class TestDemo {
    @Autowired
    CourseBaseRepository courseBaseRepository;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TeachplanMapper teachplanMapper;
    @Test
    public void testCourseBaseRepository(){
        Optional<CourseBase> optional = courseBaseRepository.findById("402885816240d276016240f7e5000002");
        if(optional.isPresent()){
            CourseBase courseBase = optional.get();
            System.out.println(courseBase);
        }

    }

    @Test
    public void testCourseMapper(){
        CourseBase courseBase = courseMapper.findCourseBaseById("297e7c7c62b8aa9d0162b8ab13910000");
        System.out.println(courseBase);
        
        

    }
    @Test
    public void testFindTeachplan(){
        TeachplanNode teachplanNode = teachplanMapper.selectList("4028e581617f945f01617f9dabc40000");
        System.out.println(teachplanNode);
    }
    @Test
    public void testPageHelper(){
        //查询第1页，每页显示10条记录
        PageHelper.startPage(1,10);
        Page<CourseBase> courseList = courseMapper.findCourseList();
        List<CourseBase> result = courseList.getResult();
        long total = courseList.getTotal();

        System.out.println(result);
    }
    
    @Test
    public void name() {
		System.out.println("helloworld");
	}
    
}
