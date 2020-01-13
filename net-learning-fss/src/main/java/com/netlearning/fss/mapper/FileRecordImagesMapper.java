package com.netlearning.fss.mapper;

import com.netlearning.framework.domain.fss.FileRecordImages;
import com.netlearning.framework.domain.fss.FileRecordImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRecordImagesMapper {
    long countByExample(FileRecordImagesExample example);

    int deleteByExample(FileRecordImagesExample example);

    int deleteByPrimaryKey(Long recordImageId);

    int insert(FileRecordImages record);

    int insertSelective(FileRecordImages record);

    List<FileRecordImages> selectByExample(FileRecordImagesExample example);

    FileRecordImages selectByPrimaryKey(Long recordImageId);

    int updateByExampleSelective(@Param("record") FileRecordImages record, @Param("example") FileRecordImagesExample example);

    int updateByExample(@Param("record") FileRecordImages record, @Param("example") FileRecordImagesExample example);

    int updateByPrimaryKeySelective(FileRecordImages record);

    int updateByPrimaryKey(FileRecordImages record);
}
