package com.netlearning.manage.cms.client.service;

import com.netlearning.framework.domain.cms.CmsPage;

public interface PageService {

	CmsPage findCmsPageById(String pageId);

	void savePageToServerPath(String pageId);

}
