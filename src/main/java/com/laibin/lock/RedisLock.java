//package com.laibin.lock;
//
//import org.redisson.Redisson;
//import org.redisson.api.RLock;
//import org.redisson.config.Config;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//
//public class RedisLock {
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Autowired
//    private Redisson redisson;
//
//    public static String query() {
//        String lockKey = "product_001";
//
//        RLock lock = redisson.getLock(lockKey);
//
////        String clientId = UUID.randomUUID().toString();
//        try{
////            boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, clientId, 10, TimeUnit.SECONDS);
////            if (!result){
////                return "error";
////            }
//            lock.lock();
//            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
//            if (stock > 0){
//                int resultStock = stock - 1;
//                stringRedisTemplate.opsForValur().set("stock", String.valueOf(resultStock));
//                System.out.println("扣减成功，剩余库存" + resultStock);
//            } else {
//                System.out.println("扣减失败，库存不足");
//            }
//        } finally {
////            if (clientId.equals(stringRedisTemplate.opsForValue().get("stock"))){
////                stringRedisTemplate.delete(lockKey);
////            }
//            lock.unlock();
//        }
//        return "end";
//    }
//
//    @Bean
//    public Redisson redisson(){
//        // 此为单机模式
//        Config config = new config();
//        config.useSingleServer().setAddress("redis://localhost:6379").setDatabase(0);
//        return (Redisson)Redisson.create(config);
//    }
//}
//
