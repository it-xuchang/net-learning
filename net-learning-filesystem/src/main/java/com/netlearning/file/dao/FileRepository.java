package com.netlearning.file.dao;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.netlearning.framework.domain.filesystem.FileSystem;

public interface FileRepository extends MongoRepository<FileSystem,String> {
}