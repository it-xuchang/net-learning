package com.netlearning.framework.domain.cms.ext;

import com.netlearning.framework.domain.cms.CmsTemplate;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CmsTemplateExt extends CmsTemplate {

    //模版内容
    private String templateValue;

}
