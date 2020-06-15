package com.netlearning.user.service.impl;

import com.netlearning.user.service.DistributedLocker;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RLock;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/5/9 13:04
 */
@Service
public class RedisDistributedLocker implements DistributedLocker {
    @Autowired
    private RedissonClient redissonClient;

    @Override
    public RLock lock(String key) {
        RLock lock = redissonClient.getLock(key);
        lock.lock();
        return lock;
    }

    @Override
    public RLock lock(String key, int timeout) {
        RLock lock = redissonClient.getLock(key);
        lock.lock(timeout,TimeUnit.MINUTES);
        return lock;
    }

    @Override
    public RLock lock(String key, TimeUnit timeUnit, int timeout) {
        RLock lock = redissonClient.getLock(key);
        lock.lock(timeout,timeUnit);
        return lock;
    }

    @Override
    public boolean tryLock(String key, TimeUnit timeUnit, int waitTime, int leaseTime) {
        RLock lock = redissonClient.getLock(key);
        try {
            return lock.tryLock(waitTime,leaseTime,timeUnit);
        }catch (InterruptedException e){
            return false;
        }
    }

    @Override
    public boolean tryLock(String key, int waitTime, int leaseTime) {
        RLock lock = redissonClient.getLock(key);
        try {
            return lock.tryLock(waitTime,leaseTime,TimeUnit.MINUTES);
        }catch (InterruptedException e){
            return false;
        }
    }

    @Override
    public void unlock(String key) {
        RLock lock = redissonClient.getLock(key);
        lock.unlock();
    }

    @Override
    public void unlock(RLock lock) {
        lock.unlock();
    }

    @Override
    public RCountDownLatch getCountDownLatch(String key) {
        return redissonClient.getCountDownLatch(key);
    }

    @Override
    public RSemaphore getSemaphore(String key) {
        return redissonClient.getSemaphore(key);
    }
}
