package com.netlearning.framework.context;

import java.io.Serializable;


public class CompanyContext implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 7852895769123192530L;

    /**
     * 企业编号
     */
    private String companyId;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 获取 企业编号
     *
     * @return 企业编号
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 设置 企业编号
     *
     * @param companyId 企业编号
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * 企业名称
     *
     * @return 企业名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 企业名称
     *
     * @param companyName 企业名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
