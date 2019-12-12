package com.netlearning.manage.media.dao;

import com.netlearning.framework.domain.media.MediaFile;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/12 10:29
 */
public interface MediaFileRepository extends MongoRepository<MediaFile,String> {
}
