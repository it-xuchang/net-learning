package com.netlearning.framework.context;


import com.netlearning.framework.session.BusinessSessionContextHolder;
import com.netlearning.framework.session.BusinessSessionObject;


public final class BusinessCallContextBuilder {
    /**
     * 构造请求上下文
     *
     * @param sessionContextHolder session会话信息
     * @return 会话信息
     */
    public static BusinessCallContext buildContext(BusinessSessionContextHolder sessionContextHolder) {

        BusinessSessionObject session = sessionContextHolder.getSession();
        BusinessCallContext context = new BusinessCallContext();

        context.setUser(session.getUser());
        context.setCompany(session.getCompany());

        context.setCallTime(session.getCallTime());
        context.setApplicationId(session.getApplicationId());

        return context;
    }

    /**
     * 清除 session会话信息
     * @param sessionContextHolder session会话信息
     */
    public static void cleanContext(BusinessSessionContextHolder sessionContextHolder) {
        sessionContextHolder.clearSession();
    }
}
