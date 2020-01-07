package com.netlearning.fss.mapper;

import com.netlearning.framework.domain.fss.FileRecordResources;
import com.netlearning.framework.domain.fss.FileRecordResourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileRecordResourcesMapper {
    long countByExample(FileRecordResourcesExample example);

    int deleteByExample(FileRecordResourcesExample example);

    int deleteByPrimaryKey(Long recordResourcesId);

    int insert(FileRecordResources record);

    int insertSelective(FileRecordResources record);

    List<FileRecordResources> selectByExample(FileRecordResourcesExample example);

    FileRecordResources selectByPrimaryKey(Long recordResourcesId);

    int updateByExampleSelective(@Param("record") FileRecordResources record, @Param("example") FileRecordResourcesExample example);

    int updateByExample(@Param("record") FileRecordResources record, @Param("example") FileRecordResourcesExample example);

    int updateByPrimaryKeySelective(FileRecordResources record);

    int updateByPrimaryKey(FileRecordResources record);
}
