package com.netlearning.framework.domain.media.response;

import com.netlearning.framework.domain.media.MediaFile;
import com.netlearning.framework.model.response.ResponseResult;
import com.netlearning.framework.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MediaFileResult extends ResponseResult {
    MediaFile mediaFile;
    public MediaFileResult(ResultCode resultCode, MediaFile mediaFile) {
        super(resultCode);
        this.mediaFile = mediaFile;
    }
}
