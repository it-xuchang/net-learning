package com.netlearning.fss.mapper.test;

import com.netlearning.fss.pojo.FileRecord;

public interface FileRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(FileRecord record);

    int insertSelective(FileRecord record);

    FileRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FileRecord record);

    int updateByPrimaryKey(FileRecord record);
}