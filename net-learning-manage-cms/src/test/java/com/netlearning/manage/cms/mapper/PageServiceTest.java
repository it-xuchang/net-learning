package com.netlearning.manage.cms.mapper;
import com.netlearning.manage.cms.service.CmsPageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PageServiceTest {

    @Autowired
    CmsPageService cmsPageService;

    @Test
    public void testGetPageHtml(){
        String pageHtml = cmsPageService.getPageHtml("5cf4ce37d0e8bf2e7c43c9cc");
        System.out.println(pageHtml);

    }

}