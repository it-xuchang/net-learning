package com.netlearning.manage.cms.service;

import com.netlearning.framework.domain.cms.CmsConfig;
import com.netlearning.framework.domain.cms.CmsPage;
import com.netlearning.framework.domain.cms.request.QueryPageRequest;
import com.netlearning.framework.domain.cms.response.CmsPageResult;
import com.netlearning.framework.model.response.QueryResponseResult;
import com.netlearning.framework.model.response.ResponseResult;

public interface CmsPageService {

	public QueryResponseResult<M> findList(int page, int size, QueryPageRequest queryPageRequest);

	public CmsPageResult add(CmsPage cmsPage);

	//public CmsPageResult edit(String id, CmsPage cmsPage);

	public ResponseResult delete(String id);

	public CmsPage findById(String id);

	public CmsPageResult update(String id, CmsPage cmsPage);

	public String getPageHtml(String pageId);

	public CmsConfig getConfigById(String id);

	public ResponseResult post(String pageId);



}
