package com.laibin.function;

import java.util.function.Consumer;

/**
 * 消费型接口。只有输入， 没有返回值
 */
public class ConsumerInterface {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<String> consumer1 = s -> {
            System.out.println(s);
        };

        consumer.accept("ssss");
        consumer1.accept("ssss");

    }
}
