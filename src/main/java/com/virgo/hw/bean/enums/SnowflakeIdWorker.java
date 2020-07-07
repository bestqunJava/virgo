package com.virgo.hw.bean.enums;



import com.virgo.hw.util.TimeUtils;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * https://www.cnblogs.com/relucent/p/4955340.html
 *
 * Program Name: Ground
 * <p>
 * Description: ID 生成器,long型
 * ID转为字符串的话，位数<=19位
 * 基于 Twitter_Snowflake，整体有序，适用于分布式服务
 *
 * 如何使用：通过new 构造SnowflakeIDWorker 实例，nexId方法获取id即可，正式使用最好使用单例模式
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2018/7/6 12:22 PM
 */
public enum SnowflakeIdWorker {
    /**
     *
     **/
    ID_WORKER(0, 0),
    ID_WORKER_1(1, 0),
    ID_WORKER_2(2, 0),
    ID_WORKER_3(3, 0),
    ;

    private static final Random RANDOM = new Random();
    public static String takeIdString(){
//        return String.valueOf(ID_WORKER.nextId());
        return takeIdStringRandom();
    }

    public static String takePayIdString(){
        return "ws" + "0" + TimeUtils.dateTimeDDMMFormatToStr(LocalDateTime.now()) + ID_WORKER.nextId();
    }

    public static String takeIdStringRandom(){
        final int random = new Random().nextInt(100) % 4;
        switch (random){
            case 0:
                return String.valueOf(ID_WORKER.nextId());
            case 1:
                return String.valueOf(ID_WORKER_1.nextId());
            case 2:
                return String.valueOf(ID_WORKER_2.nextId());
            case 3:
                return String.valueOf(ID_WORKER_3.nextId());
            default:
                return null;
        }
    }

    /**
     * 开始时间 2019年08月06日13:02:52
     */
    private final long twepoch = 1565067754081L;

    /**
     * id占位长度
     **/
    private final long workerIdBits = 5L;

    /**
     *  ...
     **/
    private final long datacenterIdBits = 5L;

    /**
     * ...-1L ^ (-1L << workerIdBits);
     **/
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /**
     * ...
     **/
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    /**
     *...
     **/
    private final long sequenceBits = 12L;
    /**
     *...
     **/
    private final long workerIdShift = sequenceBits;

    /**
     *...
     **/
    private final long datacenterIdShift = sequenceBits + workerIdBits;

    /**
     *
     **/
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    /**
     * -1L ^ (-1L << sequenceBits);
     **/
    private final long sequenceMask = ~(-1L << sequenceBits);
    /**
     *
     **/
    private long workerId;
    /**
     * ...
     **/
    private long datacenterId;
    /**
     * ...
     **/
    private long sequence = 0L;
    /**
     * ...
     **/
    private long lastTimestamp = -1L;


    SnowflakeIdWorker(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new RuntimeException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new RuntimeException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public synchronized long nextId() {
        long currentTimestamp = timeGen();
        if (currentTimestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - currentTimestamp));
        }

        if (lastTimestamp == currentTimestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                //seq 为0的时候表示是下一毫秒时间开始对seq做随机
                sequence = RANDOM.nextInt(100);
                currentTimestamp = tilNextMillis(lastTimestamp);
            }
        } else {
//            sequence = 0L;
            //如果是新的ms开始
            sequence = RANDOM.nextInt(100);
        }

        lastTimestamp = currentTimestamp;
        return ((currentTimestamp - twepoch) << timestampLeftShift)
                | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift)
                | sequence;
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

}
