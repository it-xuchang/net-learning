package com.netlearning.framework.domain.userAuth.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class TeacherEditParam {
    private Long teacherId;

    private String teacherName;

    private Long deptId;

    private String email;

    private String mobile;

    private String status;

    private String sex;

    private String description;

    private String avatar;

}
