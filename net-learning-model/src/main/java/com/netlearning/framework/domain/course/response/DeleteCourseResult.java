package com.netlearning.framework.domain.course.response;

import com.netlearning.framework.model.response.ResponseResult;
import com.netlearning.framework.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DeleteCourseResult extends ResponseResult {
    public DeleteCourseResult(ResultCode resultCode, String courseId) {
        super(resultCode);
        this.courseid = courseid;
    }
    private String courseid;

}
