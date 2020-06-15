package com.netlearning.user.service;

import org.redisson.api.RCountDownLatch;
import org.redisson.api.RLock;
import org.redisson.api.RSemaphore;

import java.util.concurrent.TimeUnit;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/5/9 13:00
 */
public interface DistributedLocker {
    RLock lock(String key);

    RLock lock(String key, int timeout);

    RLock lock(String key, TimeUnit timeUnit,int timeout);

    boolean tryLock(String key, TimeUnit timeUnit,int waitTime,int leaseTime);

    boolean tryLock(String key, int waitTime,int leaseTime);

    void unlock(String key);

    void unlock(RLock lock);

    RCountDownLatch getCountDownLatch(String key);

    RSemaphore getSemaphore(String key);
}
