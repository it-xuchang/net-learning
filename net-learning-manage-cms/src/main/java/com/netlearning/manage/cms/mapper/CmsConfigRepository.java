package com.netlearning.manage.cms.mapper;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.netlearning.framework.domain.cms.CmsConfig;

public interface CmsConfigRepository extends MongoRepository<CmsConfig,String> {
}