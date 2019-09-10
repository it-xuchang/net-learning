package com.netlearning.manage.cms.mapper;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.netlearning.framework.domain.cms.CmsPage;

public interface CmsPageRepository extends MongoRepository<CmsPage,String> {
    //根据页面名称查询
    CmsPage findByPageName(String pageName);
    //根据页面名称、站点Id、页面webpath查询
    CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName,String siteId,String pageWebPath);
}
