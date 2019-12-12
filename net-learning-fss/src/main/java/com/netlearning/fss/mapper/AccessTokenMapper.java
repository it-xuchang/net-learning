package com.netlearning.fss.mapper;

import com.netlearning.framework.domain.fss.AccessToken;
import com.netlearning.framework.domain.fss.response.AccessTokenResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2019/12/4 19:07
 */
@Repository
public interface AccessTokenMapper {
    /**
     * 匹配查询
     * @param accessToken
     * @return
     */
    List<AccessTokenResult> get(AccessToken accessToken);

    /**
     * 模糊查询
     * @param accessToken
     * @return
     */
    List<AccessTokenResult> query(AccessToken accessToken);

    void insert(AccessToken accessToken);

    void delete(AccessToken accessToken);

    void update(AccessToken accessToken);
}
