package com.netlearning.dao;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.netlearning.framework.domain.filesystem.FileSystem;

public interface FileSystemRepository extends MongoRepository<FileSystem,String> {
}