package com.netlearning.manage.cms.mapper;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.netlearning.framework.domain.cms.CmsTemplate;

public interface CmsTemplateRepository extends MongoRepository<CmsTemplate,String> {
}
