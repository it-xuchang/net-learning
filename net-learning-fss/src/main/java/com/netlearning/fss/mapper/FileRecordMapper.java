package com.netlearning.fss.mapper;

import com.netlearning.framework.domain.fss.FileRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/4 19:07
 */
@Repository
public interface FileRecordMapper {

    void insert(FileRecord fileRecord);

    void delete(FileRecord fileRecord);

    void update(FileRecord fileRecord);

    List<FileRecord> get(FileRecord fileRecord);

    List<FileRecord> query(FileRecord fileRecord);
}