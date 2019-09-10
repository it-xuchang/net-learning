package com.netlearning.manage.cms.client.mapper;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.netlearning.framework.domain.cms.CmsSite;

public interface CmsSiteRepository extends MongoRepository<CmsSite,String> {
}