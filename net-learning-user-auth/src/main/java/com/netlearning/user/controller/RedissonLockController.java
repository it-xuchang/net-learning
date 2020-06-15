package com.netlearning.user.controller;

import com.netlearning.user.util.RedisLockUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @program: net-learning
 * @description: redis分布式锁控制器
 * @author: XUCHANG
 * @time: 2020/5/9 13:32
 */
@RestController
@RequestMapping("/redisson")
public class RedissonLockController {
    @Autowired
    private RedisLockUtils redisLockUtils;

    private Integer lockCount = 10;

    private Integer count = 10;

    private final static int threadNum =10;

    @GetMapping("/test/lock")
    public void lock(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0 ; i <threadNum ; i++){
            MyRunnable myRunnable = new MyRunnable(countDownLatch);
            Thread myThread = new Thread(myRunnable);
            myThread.start();
        }
        countDownLatch.countDown();
    }

    private void testLockCount(){
        String lockKey = "lock-key";
        try {
            redisLockUtils.lock(lockKey, TimeUnit.SECONDS,2);
            lockCount --;
            System.out.println("lockCount :"+count);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            redisLockUtils.unlock(lockKey);
        }
    }

    private void testCount(){
        count -- ;
        System.out.println("count :"+count);
    }
    public class MyRunnable implements Runnable{
        final CountDownLatch countDownLatch;

        public MyRunnable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                countDownLatch.await();
            }catch (InterruptedException e){
                System.out.println(e);
            }
            testCount();
            testLockCount();
        }
    }
}
