package com.netlearning.user.util;

import com.netlearning.user.service.DistributedLocker;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RLock;
import org.redisson.api.RSemaphore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/5/9 13:11
 */
@Component
public class RedisLockUtils {
    @Autowired
    private DistributedLocker distributedLocker;

    /**
     * 加锁
     * @param key
     * @return
     */
    public  RLock lock(String key){
        return distributedLocker.lock(key);
    }
    /**
     * 释放锁
     * @param key
     * @return
     */
    public  void unlock(String key){
        distributedLocker.unlock(key);
    }
    /**
     * 释放锁
     * @param key
     * @return
     */
    public  void unlock(RLock key){
        distributedLocker.unlock(key);
    }

    /**
     * 带超时的锁
     * @param key
     * @param timeout 超时时间 单位分钟
     * @return
     */
    public RLock lock(String key, int timeout){
        return distributedLocker.lock(key,timeout);
    }

    /**
     *
     * @param key
     * @param timeUnit 时间单位
     * @param timeout 超时时间
     * @return
     */
    public RLock lock(String key, TimeUnit timeUnit, int timeout){
        return distributedLocker.lock(key,timeUnit,timeout);
    }

    /**
     * 尝试获取锁
     * @param key
     * @param timeUnit 时间单位
     * @param waitTime 最多等待时间
     * @param leaseTime 上锁后自动释放锁时间
     * @return
     */
    public boolean tryLock(String key, TimeUnit timeUnit,int waitTime,int leaseTime){
        return distributedLocker.tryLock(key, timeUnit, waitTime, leaseTime);
    }

    /**
     * 尝试获取锁
     * @param key
     * @param waitTime 最多等待时间
     * @param leaseTime 上锁后自动释放锁时间
     * @return
     */
    public boolean tryLock(String key, int waitTime,int leaseTime){
        return distributedLocker.tryLock(key, waitTime, leaseTime);
    }

    /**
     * 获取计数器
     * @param key
     * @return
     */
    public RCountDownLatch getCountDownLatch(String key) {
        return distributedLocker.getCountDownLatch(key);
    }

    /**
     * 获取信号量
     * @param key
     * @return
     */
    public RSemaphore getSemaphore(String key) {
        return distributedLocker.getSemaphore(key);
    }

}
