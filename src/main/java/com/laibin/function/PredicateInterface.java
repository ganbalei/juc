package com.laibin.function;

import java.util.function.Predicate;

/**
 * 函数式接口 Predicate
 * public interface Predicate<T> {}
 * public boolean test(String s) {}
 * 断定型接口，有一个输入参数，返回值只能是布尔值
 */
public class PredicateInterface {
    public static void main(String[] args) {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };

        Predicate<String> predicate1 = (str)->{return str.isEmpty();};

        System.out.println(predicate.test(""));
        System.out.println(predicate1.test(" "));
    }
}
