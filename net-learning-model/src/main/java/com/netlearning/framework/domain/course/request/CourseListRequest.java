package com.netlearning.framework.domain.course.request;

import com.netlearning.framework.model.request.RequestData;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CourseListRequest extends RequestData {
    //公司Id
    private String companyId;
}
