package com.netlearning.fss.mapper;

import com.netlearning.framework.domain.fss.FileType;
import com.netlearning.framework.domain.fss.response.FileTypeResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/4 19:07
 */
@Repository
public interface FileTypeMapper {

    List<FileTypeResult> get(FileType fileType);

    List<FileTypeResult> query(FileType fileType);

    void insert(FileType fileType);

    void delete(FileType fileType);

    void update(FileType fileType);
}
