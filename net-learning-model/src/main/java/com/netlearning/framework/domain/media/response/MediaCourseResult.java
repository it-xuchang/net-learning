package com.netlearning.framework.domain.media.response;

import com.netlearning.framework.domain.media.MediaFile;
import com.netlearning.framework.domain.media.MediaVideoCourse;
import com.netlearning.framework.model.response.ResponseResult;
import com.netlearning.framework.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class MediaCourseResult extends ResponseResult {
    public MediaCourseResult(ResultCode resultCode, MediaVideoCourse mediaVideoCourse) {
        super(resultCode);
        this.mediaVideoCourse = mediaVideoCourse;
    }

    MediaFile mediaVideo;
    MediaVideoCourse mediaVideoCourse;
}
