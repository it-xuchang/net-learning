package com.netlearning.fss.mapper;

import com.netlearning.framework.domain.fss.FileRecord;
import com.netlearning.framework.domain.fss.FileRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRecordMapper {
    long countByExample(FileRecordExample example);

    int deleteByExample(FileRecordExample example);

    int deleteByPrimaryKey(Long recordId);

    int insert(FileRecord record);

    int insertSelective(FileRecord record);

    List<FileRecord> selectByExample(FileRecordExample example);

    FileRecord selectByPrimaryKey(Long recordId);

    int updateByExampleSelective(@Param("record") FileRecord record, @Param("example") FileRecordExample example);

    int updateByExample(@Param("record") FileRecord record, @Param("example") FileRecordExample example);

    int updateByPrimaryKeySelective(FileRecord record);

    int updateByPrimaryKey(FileRecord record);
}
