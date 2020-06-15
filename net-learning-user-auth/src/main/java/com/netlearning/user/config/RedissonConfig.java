package com.netlearning.user.config;

import com.netlearning.framework.utils.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/5/8 18:36
 */
@Configuration
public class RedissonConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private String port;
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public RedissonClient redissonClient () {

        Config config = new Config();
        config.useSingleServer().setAddress("redis://"+host+":"+port);
        if (StringUtils.isEmpty(password)){
            config.useSingleServer().setPassword(null);
        }else {
            config.useSingleServer().setPassword(password);
        }
        //添加主从配置
//        config.useMasterSlaveServers().setMasterAddress("").setPassword("").addSlaveAddress(new String[]{"",""});
        //添加集群配置
//        config.useClusterServers().setScanInterval(2000).addNodeAddress("redis://127.0.0.1:7001","redis://127.0.0.1:7001").addNodeAddress();
        return Redisson.create ( config );
    }
}
